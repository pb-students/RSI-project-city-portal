<script setup lang="ts">
onMounted(() => {
  console.log('Hello World!')
  window.client = useRestClient()
})
</script>

<template>
  <div>
    <NuxtWelcome />
  </div>
</template>
