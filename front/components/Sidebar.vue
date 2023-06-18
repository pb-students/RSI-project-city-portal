<script setup lang="ts">
const { data: events } = await useFetch("/api/events/by/page/1", {
  baseURL: 'https://wsdl--main--project-rsi--siwykot41.code.wvffle.net/RSI'
});
</script>

<template>
  <h2 class="text-2xl font-semibold text-pink-700 mb-4 px-2">Aktualności</h2>
  <SidebarEvent v-for="event in events" :key="event.id" :event="event" />
</template>
