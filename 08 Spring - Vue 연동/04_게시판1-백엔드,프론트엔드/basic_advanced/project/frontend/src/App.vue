<script setup>
import { RouterView } from 'vue-router';
import DefaultLayout from './components/layouts/DefaultLayout.vue';
</script>

<template>
  <!-- DefaultLayout: header / main / footer 항상 보이도록 설정 -->
  <DefaultLayout>
    <RouterView />
  </DefaultLayout>
</template>

<style scoped></style>
