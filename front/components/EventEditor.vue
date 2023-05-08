<script setup lang="ts">
import type { EventInfo } from "~/types";
import dateFormat from 'dateformat'
const props = defineProps<{
  event: EventInfo | undefined;
}>();

const data = ref({
  name: '',
  type: '',
  date: new Date().toISOString().split('T')[0],
  description: ''
})

watchEffect(() => {
  if (!props.event) return
  data.value = {
    ...props.event,
    date: props.event.date.split('T')[0],
  }
})

const save = async () => {
  const { id } = await $fetch(props.event
    ? `/api/events/${props.event.id}`
    : '/api/events',
    {
      method: 'post',
      body: data.value
    }
  )

  return useRouter().push(`/events/${id}`)
}
</script>

<template>
  <FormKit 
    type="form" 
    v-model="data"
    :actions="false"
    #default="{ disabled }"
    @submit="save"
  >
    <FormKit
      type="text"
      name="name"
      label="Nazwa wydarzenia"
      validation="required"
    />
    <div class="flex gap-3">
      <FormKit
        type="date"
        name="date"
        label="Data wydarzenia"
        validation="required"
      />
      <FormKit
        type="text"
        name="type"
        label="Typ wydarzenia"
        validation="required"
      />
    </div>
    <FormKit
      type="textarea"
      name="description"
      label="Opis wydarzenia"
      validation="required"
    />
    <FormKit type="submit" label="Zapisz" />
  </FormKit>
</template>
