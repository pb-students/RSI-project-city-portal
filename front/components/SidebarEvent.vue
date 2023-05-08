<script setup lang="ts">
import type { EventInfo } from "~/types";
import dateFormat from 'dateformat'
defineProps<{
  event: EventInfo;
}>();
</script>

<template>
  <NuxtLink :to="`/events/${event.id}`" class="block p-2 mb-2 text-lg rounded-xl hover:bg-white hover:shadow">
    {{ event.name }}
    <div class="text-sm text-gray-500 truncate">{{ dateFormat(event.date, 'dddd, dd mmmm yyyy') }}</div>
  </NuxtLink>
</template>
