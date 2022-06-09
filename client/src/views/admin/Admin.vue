<template>
  <div id="admin">
    <div class="admin-nav">
        <ul>
          <li><button @click="toggleDestination" :class="{active: showDestinations}">Destinations</button></li>
          <li><button @click="toggleGuides" :class="{active: !showDestinations}">Tour Guides</button></li>
        </ul>
    </div>

    <!-- Destinations -->
    <div v-if="showDestinations" class="admin-content">
      <div class="add-destination-container">
        <button class="btn secondary" @click="toggleModal">Add destination</button>
      </div>
      <AdminDestinations />
    </div>

    <!-- Guides -->
     <div v-else class="admin-content">
      <div class="add-destination-container">
        <button class="btn secondary" @click="toggleModalGuides">Add guide</button>
      </div>
      <AdminGuides />
    </div>

    <!-- Add Destination Form -->
    <div v-if="openModal" class="add-destination" @click.self="toggleModal">
      <FormDestinationAdd @close="toggleModal" />
    </div>

    <!-- Add Guide Form -->
    <div v-if="openModalGuides" class="add-destination" @click.self="toggleModalGuides">
      <FormGuideAdd @close="toggleModalGuides" />
    </div>

  </div>
</template>

<script>
import AdminDestinations from "../../components/AdminDestinations.vue";
import AdminGuides from "../../components/AdminGuides.vue";
import FormDestinationAdd from "../../components/FormDestinationAdd.vue";
import FormGuideAdd from "../../components/FormGuideAdd.vue";

export default {
  name: 'Admin',
  components: { AdminDestinations, FormDestinationAdd, AdminGuides, FormGuideAdd },
  data() {
    return {
      openModal: false,
      openModalGuides: false,
      showDestinations: true,
    }
  },
  methods: {
    toggleModal() {
      this.openModal = !this.openModal;
    },
    toggleModalGuides() {
      this.openModalGuides = !this.openModalGuides;
    },
    toggleDestination() {
      if (!this.showDestinations) {
        this.showDestinations = !this.showDestinations;
      }
    },
    toggleGuides() {
      if (this.showDestinations) {
        this.showDestinations = !this.showDestinations;
      }
    }
  }
}
</script>

<style>
  #admin .admin-nav {
    display: block;
    background-color: var(--color-gray-light);
  }

  #admin .admin-nav ul {
    display: flex;
  }

  #admin .admin-nav button {
    border: none;
    transition: var(--transition-basic);
    color: inherit;
    font-weight: bold;
    font-size: 1.6rem;
    padding: var(--padding-main-admin-nav-link);
    background-color: var(--color-gray-light);
  }

  #admin .admin-nav button:hover, #admin .admin-nav button.active {
    background-color: var(--color-primary);
    color: var(--color-white);
  }

  .admin-content {
    padding: var(--padding-main);
  }

  .add-destination-container {
    text-align: right;
    margin-bottom: 1.2rem;
  }

  .add-destination {
    position: absolute;
    top: 0;
    left: 0;
    z-index: 9999;
    width: 100vw;
    height: 100vh;
    background-color: rgba(0, 0, 0, 0.7);
    display: flex;
    justify-content: center;
    align-items: center;
  }
</style>