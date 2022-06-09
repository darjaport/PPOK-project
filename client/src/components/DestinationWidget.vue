<template>
  <div class="destination-widget">
    <div class="image-container">
      <span v-if="destination.imageList.length > 0">
        <img :src="getImg(destination.imageList[0].src)" :alt="destination.imageList[0].name" />
      </span>
    </div>
    <div class="title-container">
      <h3>{{ destination.name }}</h3>
      <h6>{{ destination.continent }}</h6>
    </div>
    <div class="price-container">
      <h2>{{ destination.price }}<span>€</span></h2>
    </div>
    <div class="description-container">
      <p>{{ destination.description }}</p>
      <router-link class="btn btn-xs primary"
        :to="{ name: 'SingleDestination', params: { id: destination.destinationId } }">Details</router-link>
    </div>
  </div>
</template>

<script>
export default {
  props: ['destination'],
  methods: {
    getImg(img) {
      return require('../assets/img/' + img);
    }
  }
}
</script>

<style>
    #destinations .destination-widget, #home-featured .destination-widget {
      margin-top: 0rem;
      border-radius: 2px;
      overflow: hidden;
      text-align: left;
      border: 0.1rem solid var(--color-gray-light);
      display: flex;
      flex-direction: column;
      height: 100%;
      flex-grow: 1;
    }
  
    #destinations .image-container, #home-featured .image-container {
      overflow: hidden;
      min-height: 20rem;
      height: 22.5rem;
      width: 100%;
      background-color: var(--color-gray-primary);
    }

    #home-featured .image-container {
      height: 18rem;
    }
  
    @media screen and (max-width: 1038px) {
      #destinations .image-container {
        height: 30rem;
      }
    }
  
    .title-container,
    .price-container,
    .description-container {
      padding: var(--padding-element-xs);
    }
  
    .title-container h3 {
      font-size: 2.6rem;
    }
  
    .price-container {
      border-color: var(--color-gray-light);
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
  
    .price-container h2 {
      font-size: 3rem;
      color: var(--color-secondary);
    }
  
    .price-container h2,
    .price-container h5 {
      margin-bottom: -0.2rem;
    }
  
    .price-container h5 {
      font-weight: bold;
    }
  
    .price-container h2 span {
      font-size: 1.8rem;
      padding-left: 0.5rem;
    }
  
    #destinations .description-container,
    #home-featured .description-container {
      flex-grow: 1;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
    }

    #destinations .description-container .btn, #home-featured .description-container .btn  {
      width: max-content;
    }

    .description-container p {
      margin-bottom: 1.5rem;
    }
</style>