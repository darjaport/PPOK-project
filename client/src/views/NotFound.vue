<template>
  <section id="not-found">
    <div class="not-found-svg">
      <img src="../assets/img/not-found.svg" alt="not-found" />
    </div>
    <router-link class="btn primary" to="/">Back home</router-link>
  </section>
</template>

<script>
export default {
    name: 'Not Found',
}
</script>
    
<style>

#not-found {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center
}

.not-found-svg {
  width: 30vw;
  margin-top: -3rem;
  margin-bottom: 3rem;
}

</style>