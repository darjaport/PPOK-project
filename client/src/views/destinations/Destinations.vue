<template>
  <div id="destinations">
    <h1>Destinations</h1>
    <Loading v-if="loading" />
    <div v-else class="content">
      <span v-for="destination in destinations" :key="destination.destinationId">
        <DestinationWidget :destination="destination" />
      </span>
    </div>
  </div>
</template>

<script>
import DestinationWidget from "../../components/DestinationWidget.vue";
import axios from 'axios';
import Loading from '../../components/Loading.vue';

export default {
  name: 'Destinations',
  components: {
    DestinationWidget, Loading
  },
  data() {
    return {
      destinations: [],
      loading: true
    }
  },
  mounted() {
    this.getDestinations();
  },
  methods: {
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
  }
}
</script>

<style>
#destinations .content {
  display: grid;
  grid-gap: 4rem;
  grid-template-columns: repeat(auto-fill, minmax(30rem, 1fr));
  grid-auto-rows: 1fr;
}
</style>