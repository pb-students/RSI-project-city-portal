export default defineNuxtRouteMiddleware((to, from) => {
  const { token } = useAuthStore()

  if (!token && to.path !== '/login') {
    return navigateTo({
      path: '/login',
      query: {
        next: to.fullPath,
      }
    })
  }

  if (token && to.path === '/login') {
    return navigateTo('/')
  }
})
