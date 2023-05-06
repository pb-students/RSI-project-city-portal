<script setup lang="ts">
</script>

<template>
  <div class="bg-gray-50 min-h-screen">
    <Nav class="sticky top-0" />
    <div class="mx-auto flex w-full max-w-7xl items-start gap-x-8 px-4 py-10 sm:px-6 lg:px-8">
      <main class="flex-1">
        <NuxtPage />
      </main>

      <aside class="sticky top-8 hidden w-96 shrink-0 xl:block">
        <Sidebar />
      </aside>
    </div>
  </div>
</template>

<style>
* {
  font-family: 'Inter', sans-serif;
}

h1, h2, h3, h4, h5, h6 {
  font-family: 'Lato', sans-serif;
}
</style>
