<script setup lang="ts">
const { params } = useRoute()
const { data: event } = await useFetch(() => `/api/events/${params.id}`)
if (!event.value) {
  throw createError({ statusCode: 404 })
}
</script>

<template>
  <div class="aspect-3/1 relative rounded-lg overflow-hidden group-hover:shadow-lg"> 
    <div class="absolute inset-0 w-full h-full z-2 text-shadow-lg">
      <h3 class="text-4xl absolute top-4 right-5 text-white">{{ dateFormat(event.date, 'dd') }}</h3>
      <h3 class="text-4xl absolute top-11 right-5 text-white">{{ dateFormat(event.date, 'mm') }}</h3>
      <h3 class="text-4xl absolute top-18 right-5 text-white">{{ dateFormat(event.date, 'yy') }}</h3>
    </div>
    <div class="bg-pink-800 opacity-40 absolute inset-0 z-1 duration-200 group-hover:opacity-0" />
    <img :src="useEventBg(event)" class="aspect-3/1 object-cover object-center mb-2 duration-200 group-hover:rotate-3 group-hover:scale-115" />
  </div>
  <div class="pt-2 text-sm text-gray-500">Rodzaj wydarzenia: {{ event.type }}</div>
  <h3 class="pt-4 pb-2 text-3xl w-full flex items-center justify-between">
    {{ event.name }}

    <NuxtLink :to="`/events/${event.id}/edit`" class="rounded bg-pink-600 hover:bg-pink-500 text-sm text-white px-4 py-2">
      Edytuj
    </NuxtLink>
  </h3>
  <div class="text-sm text-gray-800 text-xl">{{ event.description }}</div>
</template>
