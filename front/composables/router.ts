export const useRouteQuery = (field: string, defaultValue?: string) => {
  const route = useRoute()
  return computed(() => route.query[field] ?? defaultValue)
}
