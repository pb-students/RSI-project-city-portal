<script setup lang="ts">
definePageMeta({
  layout: 'full',
})

const username = ref('')
const password = ref('')
const router = useRouter()

const auth = useAuthStore()

const next = useRouteQuery('next', '/')

const error = ref('')
const login = async () => {
  try {
    await auth.login(username.value, password.value)
    router.push(next.value)
  } catch (e) {
    console.log(e)
    error.value = e.message
  }
}
</script>

<template>
  <div class="flex flex-col items-center justify-center w-full h-full">
    <div class="flex flex-col items-center justify-center w-full max-w-sm p-4 space-y-4 bg-white rounded-md shadow">
      <h1 class="text-3xl font-bold">Login</h1>
      <form class="flex flex-col items-center justify-center w-full space-y-4" @submit.prevent="login">
        <input v-model="username" type="text" placeholder="Username" class="w-full p-2 border border-gray-300 outline-none focus:ring ring-pink-500 rounded" />
        <input v-model="password" type="password" placeholder="Password" class="w-full p-2 border border-gray-300 outline-none focus:ring ring-pink-500 rounded" />
        <p v-if="error" class="text-red-500 text-xs">Błędny login lub hasło</p>
        <p v-else class="text-red-500 text-xs">&nbsp;</p>
        <button type="submit" class="w-full p-2 text-white bg-pink-500 hover:bg-pink-400 rounded">Login</button>
      </form>
    </div>
  </div>
</template>
