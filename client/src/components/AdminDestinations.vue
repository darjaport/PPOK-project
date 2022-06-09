<template>
  <Loading v-if="loading" />
  <table v-else>
    <thead>
      <tr>
        <th>Name</th>
        <th>Country</th>
        <th>Guide</th>
        <th>Date Added</th>
        <th class="admin-more-data">More Data</th>
      </tr>
    </thead>

    <tbody v-for="destination in destinations" :key="destination.destinationId">
      <tr @click="toggleMoreInfo(destination.destinationId)">
        <td>{{ destination.name }}</td>
        <td>{{ destination.countryName }}</td>
        <td>{{ destination.guideName }} {{ destination.guideLastName }}</td>
        <td>{{ destination.dateAdded }}</td>
        <td className="icon">
          <button type="button" class="more-info-button" @click:self="toggleMoreInfo">
            <div className="circle-icon">
              <svg xmlns="http://www.w3.org/2000/svg" width="14" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="1.5" d='M19 9l-7 7-7-7' />
              </svg>
            </div>
          </button>
        </td>
      </tr>
      <tr v-if="showMoreInfoId == destination.destinationId">
        <td colSpan="5" class="description-container">
          <p>Price: <b>{{ destination.price }} €</b></p>
          <p>City: <b>{{ destination.cityName }}</b></p>
          <p>Start date: <b>{{ destination.startDate }}</b></p>
          <p>End date: <b>{{ destination.endDate }}</b></p>
          <p>Group size: <b>{{ destination.groupSize }}</b></p>
          <p>Description: <b>{{ destination.description }}</b></p>
          <div class="buttons">
            <button @click="deleteDestination(destination.destinationId)" type="button"
              class="btn tertiary">Delete</button>
            <button @click="updateDestination(destination)" type="button" class="btn primary">Update</button>
          </div>
        </td>
      </tr>
    </tbody>
  </table>

  <div v-if="openModalDestinationsUpdate" class="add-destination" @click.self="openModalDUpdate">
    <FormDestinationUpdate :getUpdatedDestinations="getDestinations" :oldDestination="editDestination"
      @close="openModalDUpdate" />
  </div>
</template>

<script>
import axios from 'axios';
import Loading from './Loading.vue';
import FormDestinationUpdate from './FormDestinationUpdate.vue';

export default {
  name: 'Admin Destinations',
  components: { Loading, FormDestinationUpdate },
  data() {
    return {
      showMoreInfoId: null,
      loading: true,
      openModalDestinationsUpdate: false,
      editDestination: null,
      destinations: [],
    }
  },
  mounted() {
    this.getDestinations();
  },
  methods: {
    toggleMoreInfo(id) {
      if (this.showMoreInfoId === id) {
        this.showMoreInfoId = null;
      } else {
        this.showMoreInfoId = id;
      }
    },
    getDestinations() {
      axios
        .get("http://localhost:8080/api/v1/destinations")
        .then(response => {
          this.destinations = response.data;
          this.loading = false;
        })
        .catch(function (error) {
          console.log(error)
          this.loading = false;
        })
    },
    deleteDestination(id) {
      this.loading = true;
      axios
        .delete(`http://localhost:8080/api/v1/destinations/delete/${id}`)
        .then(response => {
          this.getDestinations();
        })
        .catch(function (error) {
          console.log(error);
          this.loading = false;
        })
    },
    openModalDUpdate() {
      this.openModalDestinationsUpdate = !this.openModalDestinationsUpdate;
    },
    updateDestination(destination) {
      this.editDestination = destination;
      this.openModalDUpdate();
    }
  }
}
</script>

<style>
  #admin .description-container {
    background-color: var(--color-gray-primary);
    padding: var(--padding-element);
    color: var(--color-white);
  }

  #admin p {
    width: 100%;
  }

  #admin p:not(:last-of-type) {
    border-bottom: 1px dotted var(--color-gray-medium);
  }

  #admin .buttons .btn {
    font-size: 1.2rem;
  }

    #admin .buttons .btn:first-of-type {
      margin-right: 1rem;
    }

  table {
    border-spacing: 0 0.3rem;
    width: 100%;
  }

  thead tr {
    background-color: var(--color-gray-primary);
    color: var(--color-white);
  }

  tbody tr:nth-child(even) {
    background-color: var(--color-gray-light);
  }

  tbody tr:first-of-type, tbody tr:nth-child(odd) {
    background-color: var(--color-gray-light-xs);
  }

  tbody tr {
    cursor: pointer;
  }

  th,
  td {
    padding: var(--padding-element-s);
    text-align: left;
  }

  tr {
    font-size: 1.4rem;
    font-weight: 500;
  }
  
  td {
    font-size: 1.2rem;
  }

  .admin-more-data {
    text-align: right;
  }

  td.icon {
    text-align: right;
  }

  td.icon button {
    border: none;
    background-color: var(--color-gray-dark);
    color: var(--color-white);
    border-radius: 50%;
    width: 2.8rem;
    height: 2.8rem;
  }

</style>