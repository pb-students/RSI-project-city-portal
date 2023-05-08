<script setup lang="ts">
const { params } = useRoute()
const { data: event } = await useFetch(() => `/api/events/${params.id}`)
</script>

<template>
  <EventEditor :event="event" />
</template>
