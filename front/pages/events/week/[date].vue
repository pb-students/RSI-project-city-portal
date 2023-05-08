<script setup lang="ts">
const { params } = useRoute()
const { data: events } = await useFetch(`/api/events/by/week/${params.date}`)

const date = ref(params.date)
</script>

<template>
  <div class="flex items-center justify-between">
    <FormKit
      type="date"
      label="Wybierz tydzień"
      validation="required"
      v-model="date"
    />
    <NuxtLink :to="date" class="rounded bg-pink-600 hover:bg-pink-500 text-sm text-white px-4 py-2">
      Idź do tygodnia
    </NuxtLink>
  </div>
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
