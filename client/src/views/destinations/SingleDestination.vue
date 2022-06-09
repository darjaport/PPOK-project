<template>
  <div id="single-destination">
    <Loading v-if="loading" />
    <div v-else class="section">
      <div class="image-container">
        <div v-if="destination.imageList.length > 0" class="main-img">
          <img class="img" :src='getImg(mainImg)' />
        </div>
        <div class="sub-imgs" v-if="destination.imageList.length > 2">
          <span v-for="img in images" :key="img.imageId">
            <img @click="setMainImg(img.src)" class="img" :src='getImg(img.src)' />
          </span>
        </div>
      </div>
      <div class="description-container">
        <h3>{{ destination.name }}</h3>
        <p>City: <b>{{ destination.cityName }}</b></p>
        <p>Start date: <b>{{ destination.startDate }}</b></p>
        <p>End date: <b>{{ destination.endDate }}</b></p>
        <p>Guide: <b>{{ destination.guideName }} {{ destination.guideLastName }}</b></p>
        <p>Difficulty: <b>{{ destination.difficultyLevelName }}</b></p>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
import Loading from '../../components/Loading.vue';

export default {
  name: 'Single Destination',
  props: ['id'],
  components: { Loading },
  data() {
    return {
      loading: true,
      destination: null,
      images: [],
      mainImg: null
    }
  },
  mounted() {
    this.getDestinations();
  },
  methods: {
    getImg(img) {
      return require('../../assets/img/' + img);
    },
    setMainImg(id) {
      this.mainImg = id;
    },
    getDestinations() {
      axios
        .get(`http://localhost:8080/api/v1/destinations/${this.id}`)
        .then(response => {
          this.destination = response.data;
          if (response.data.imageList.length > 0) {
            this.images = response.data.imageList;
            this.mainImg = response.data.imageList[0].src;
          }
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
#single-destination .sub-imgs img {
  cursor:pointer;
}

#single-destination {
  display: flex;
  align-items: start;
  justify-content:center;
}

#single-destination .section {
  color: var(--color-white);
  max-width: 100vw;
  display: grid;
  grid-gap:1rem;
  grid-template-columns: repeat(auto-fill, minmax(40rem, calc(75vw/2)));
}

@media screen and (max-width: 1166px) {
  #single-destination .section {
    max-width: 80vw;
  }
}

@media screen and (max-width: 1046px) {
  #single-destination .section {
    max-width: 90vw;
  }
}

@media screen and (max-width: 905px) {
  #single-destination .section {
    display: block;
  }
  #single-destination .description-container {
    margin-top: 1rem;
  }
}

#single-destination .image-container {
  width: 100%;
  height: 100%;
}

#single-destination .main-img {
  margin-bottom: 1rem;
}

#single-destination .sub-imgs {
  display: flex;
  flex-direction: row;
  width: 100%;
  gap: .5rem;
}

#single-destination .sub-imgs img {
  cursor: pointer;
}

#single-destination .description-container {
  background-color: var(--color-gray-primary);
  padding: var(--padding-element);
}

#single-destination h3 {
  font-size: 2.2rem;
  margin-bottom: 1.4rem;
}

#single-destination p {
  width: 100%;
  border-bottom: 1px dotted var(--color-gray-medium);
}

</style>