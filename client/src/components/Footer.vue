<template>
   <footer id="footer">
    <router-link class="logo" to="/"><img class="logo_svg" src="../assets/img/logo_grey.svg" />ravel.</router-link>
    <!-- <div class="box">social icons</div> -->
  </footer>
</template>

<script>
</script>

<style>
#footer {
  padding: var(--padding-footer);
  background-color: var(--color-gray-primary);
  color: var(--color-white);
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>