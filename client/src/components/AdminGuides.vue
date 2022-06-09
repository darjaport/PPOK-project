<template>
  <Loading v-if="loading" />
  <table class="guides-table" v-else>
    <thead>
      <tr>
        <th>Name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Date of birth</th>
        <th class="admin-more-data"></th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="guide in guides" :key="guide.guideId">
        <td>{{ guide.name}} {{ guide.lastName }}</td>
        <td>{{ guide.address }}</td>
        <td>{{ guide.phone }}</td>
        <td>{{ guide.email }}</td>
        <td>{{ guide.dateOfBirth }}</td>
        <td className="buttons">
          <button @click="deleteGuide(guide.guideId)" type="button">Delete</button>
          <button @click="updateGuide(guide)" type="button">Update</button>
        </td>
      </tr>
    </tbody>
  </table>
  <div v-if="openModalGuidesUpdate" class="add-destination" @click.self="openModalGUpdate">
    <FormGuideUpdate :getUpdatedGuides="getGuides" :oldGuide="editGuide" @close="openModalGUpdate" />
  </div>
</template>

<script>
import axios from 'axios';
import Loading from './Loading.vue';
import FormGuideUpdate from './FormGuideUpdate.vue';

export default {
  name: 'Admin Destinations',
  components: { Loading, FormGuideUpdate },
  data() {
    return {
      loading: true,
      guides: [],
      openModalGuidesUpdate: false,
      editGuide: null
    }
  },
  mounted() {
    this.getGuides();
  },
  methods: {
    getGuides() {
      axios
        .get("http://localhost:8080/api/v1/guides")
        .then(response => {
          this.guides = response.data;
          this.loading = false;
        })
        .catch(function (error) {
          console.log(error)
          this.loading = false;
        })
    },
    deleteGuide(id) {
      this.loading = true;
      axios
        .delete(`http://localhost:8080/api/v1/guides/delete/${id}`)
        .then(response => {
          this.getGuides();
        })
        .catch(function (error) {
          console.log(error);
          this.loading = false;
        })
    },
    openModalGUpdate() {
      this.openModalGuidesUpdate = !this.openModalGuidesUpdate;
    },
    updateGuide(guide) {
      this.editGuide = guide;
      this.openModalGUpdate();
    }
  }
}
</script>

<style>
  .guides-table .buttons {
    text-align: right;
  }

  .guides-table button {
    border: none;
    background-color: transparent;
    font-weight: bold;
    font-size: 1em;
    color: var(--color-grey-medium);
    transition: all .2s;
  }

  .guides-table button:last-of-type {
    color: var(--color-primary);
    margin-left: 1.2rem;
  }

  .guides-table button:hover {
    color: var(--color-primary-dark);
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