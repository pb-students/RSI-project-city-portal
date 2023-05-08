<script setup lang="ts">
const { data: events } = await useFetch('/api/events')
</script>

<template>
  <div class="event-list grid md:grid-cols-2 gap-y-6 gap-x-4">
    <EventLink v-for="event of events" :key="event.id" :event="event" />
    <div v-if="!events.length">Brak wydarzeń</div>
  </div>
</template>

<style scoped>
.event-list > :nth-child(3n-2) {
  grid-area: span 2 / span 2;
}
</style>
