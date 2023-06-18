export const useAuthStore = definePiniaStore('auth', () => {
  const router = useRouter()
  const token = ref('')

  const login = async (username: string, password: string) => {
    const basicAuth = btoa(`${username}:${password}`)

    await $fetch('/api/auth/verify', {
      method: 'POST',
      body: { username, password },
      baseURL: 'https://wsdl--main--project-rsi--siwykot41.code.wvffle.net/RSI',
      headers: {
        Authorization: `Basic ${basicAuth}`,
      },
    })

    token.value = basicAuth
  }

  const logout = async () => {
    token.value = ''
    router.push('/')
  }

  const isAuthenticated = computed(() => token.value !== '')

  return {
    token,
    login,
    logout,
    isAuthenticated,
  }
})
