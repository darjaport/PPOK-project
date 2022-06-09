<template>
  <div id="nav" :class="{ nav_add_style: this.$route.name == 'Home' }">
    <div>
      <router-link class="logo" to="/"><img class="logo_svg" src="./assets/img/logo.svg" />ravel.</router-link>
    </div>
    <div>
      <router-link to="/">Home</router-link>
      <router-link :to="{ name: 'Destinations' }">Destinations</router-link>
      <router-link :to="{ name: 'Admin' }">Admin</router-link>
    </div>
  </div>
  <router-view/>
 <Footer />
</template>

<script>
import Footer from './components/Footer.vue';

export default {
  components: { Footer },
}
</script>

<style>
#nav {
  padding: var(--padding-main);
  font-size: var(--font-size-nav);
  text-align: right;
  display: flex;
  justify-content: space-between;
  z-index: 999 !important;
  color: var(--color-gray-primary);
  border-bottom: 1px solid var(--color-gray-light);
}

.nav_add_style {
  color: var(--color-white) !important;
  border-bottom: none !important;
}

#nav a:not(:last-of-type) {
  margin-right: var(--margin-nav-link);
}

#nav a:hover {
  color: var(--color-primary);
}

#footer a:hover {
  color: var(--color-white);
}

#nav a.router-link-exact-active {
  color: var(--color-primary);
}

.logo_svg {
  width: 3rem;
  margin-right: 0.4rem;
}
.logo {
  font-size: 1.6rem;
  color: var(--color-primary);
}
#footer .logo {
  color: var(--color-white);
}
</style>
