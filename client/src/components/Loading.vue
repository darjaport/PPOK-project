<template>
  <div class="loading">
    <div className="spinner"></div>
  </div>
</template>

<script>
export default {

}
</script>

<style>
.loading {
  display: flex;
  justify-content: center;
  align-items: center;
}

.spinner {
  width: 8rem;
  height: 8rem;
  border-radius: 50%;
  border-top: 0.5rem solid var(--color-primary);
  border-right: 0.5rem solid transparent;
  border-left: 0.5rem solid var(--color-primary);
  animation: spinner 1.1s linear infinite;
}

@keyframes spinner {
  to {
    transform: rotate(360deg);
  }
}
</style>