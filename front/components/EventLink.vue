<script setup lang="ts">
import type { EventInfo } from "~/types";
import dateFormat from 'dateformat'
defineProps<{
  event: EventInfo;
}>();
</script>

<template>
  <NuxtLink :to="`/events/${event.id}`" class="block p-2 mb-2 text-3xl group">
    <div class="aspect-3/1 relative rounded-lg overflow-hidden group-hover:shadow-lg">
      <div class="absolute inset-0 w-full h-full z-2 text-shadow-lg">
        <h3 class="text-4xl absolute top-4 right-5 text-white">{{ dateFormat(event.date, 'dd') }}</h3>
        <h3 class="text-4xl absolute top-11 right-5 text-white">{{ dateFormat(event.date, 'mm') }}</h3>
        <h3 class="text-4xl absolute top-18 right-5 text-white">{{ dateFormat(event.date, 'yy') }}</h3>
      </div>
      <div class="bg-pink-800 opacity-40 absolute inset-0 z-1 duration-200 group-hover:opacity-0" />
      <img :src="useEventBg(event)" class="aspect-3/1 object-cover object-center mb-2 duration-200 group-hover:rotate-3 group-hover:scale-115" />
    </div>
    <h3 class="flex justify-between items-center pt-2 pb-2">
      {{event.type}}: {{ event.name }}
    </h3>
  </NuxtLink>
</template>
