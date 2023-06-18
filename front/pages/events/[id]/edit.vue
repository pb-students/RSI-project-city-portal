<script setup lang="ts">
const { params } = useRoute()
const { data: event } = await useFetch(() => `/api/events/${params.id}`, {
  baseURL: 'https://wsdl--main--project-rsi--siwykot41.code.wvffle.net/RSI'
})
</script>

<template>
  <EventEditor :event="event" />
</template>
