<template>
  <div class="bg-gray-50 min-h-screen">
    <Nav class="sticky top-0 z-1000" />

    <div class="mx-auto lg:flex w-full max-w-7xl items-start gap-x-8 px-4 py-10 sm:px-6 lg:px-8">
      <main class="flex-1">
        <NuxtPage />
      </main>

      <aside class="lg:sticky top-20 lg:w-96 shrink-0">
        <Sidebar />
      </aside>
    </div>
  </div>
</template>
