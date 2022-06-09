
<template>
  <main class="home-page">
    <div id="home">
      <div class="bg-video">
        <video class="video" autoplay muted loop>
          <source src="../assets/img/video.mp4" type="video/mp4" />
          Your browser does not support the video tag.
        </video>
      </div>
      <div class="content">
        <h1>Your next favorite destination.</h1>
        <a class="btn primary" href="#home-featured">Show more</a>
      </div>
    </div>

    <Loading v-if="loading" />
    <section v-if="destinations.length > 1 && !loading" id="home-featured">
      <h1>Top Destinations</h1>
      <div class="content">
        <span v-for="destination in destinations.slice(0, 2)" :key="destination.destinationId">
          <DestinationWidget :destination="destination" />
        </span>
      </div>
      <router-link class="btn secondary" :to="{ name: 'Destinations' }">Show More Destinations</router-link>
    </section>

  </main>
</template>

<script>
import DestinationWidget from '../components/DestinationWidget.vue';
import axios from 'axios';
import Loading from '../components/Loading.vue';

export default {
  name: 'Home',
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
#home {
  width: 100%;
  height: calc(100vh - 8.4rem);
  display: flex;
  justify-content: center;
  align-items: center;
}

#home .bg-video {
  /* position: absolute; */
  position: fixed;
  top: 0;
  left: 0;
  height: 100%;
  width: 100%;
  z-index: -1;
  overflow: hidden;
}

#home .content {
 width: 50vw;
 margin-top: -11rem;
 text-align: center;
}

#home h1 {
  color: var(--color-white);
  font-size: var(--font-size-home-h1);
}

/* --------------------------------------- */
#home-featured {
  padding: var(--padding-main);
  text-align: center;
  background-color: var(--color-white);
}

#home-featured .content {
    display: flex;
    flex-direction: row;
    justify-content: center;
    gap: 5rem;
}

#home-featured .destination-widget {
  width: 30rem;
}

#home-featured .secondary {
  margin-top: 3rem;
}

@media screen and (max-width: 718px) {
  #home-featured .content {
    flex-direction: column;
    align-items: center;
    margin-top: -2rem;
  }
}
</style>