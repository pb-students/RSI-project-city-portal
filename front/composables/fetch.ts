import type { UseFetchOptions } from '#app'
import { useFetch as useNuxtFetch } from '#app'

export const useFetch = <T>(url: string, options: UseFetchOptions = {}) => {
  const { token } = useAuthStore()

  return useNuxtFetch<T>(url, {
    ...options,
    baseURL: options.baseURL ?? 'https://wsdl--main--project-rsi--siwykot41.code.wvffle.net/RSI',
    headers: {
      ...options.headers,
      Authorization: `Basic ${token}`,
    }
  })
}
