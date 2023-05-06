// https://nuxt.com/docs/api/configuration/nuxt-config
export default defineNuxtConfig({
  modules: [
    '@unocss/nuxt',
  ],

  css: [
    '@unocss/reset/tailwind.css',
    '@fontsource/inter/200.css',
    '@fontsource/inter/400.css',
    '@fontsource/inter/600.css',
    '@fontsource/inter/800.css',
    '@fontsource/lato/900.css',
  ]
})
