<script setup>
import Header from './Header.vue';
import NavBar from './NavBar.vue';
import Footer from './Footer.vue';
</script>
<template>
  <div class="container">
    <Header />
    <NavBar />
    <div class="content my-5 px-3">
      <!-- slot: 부모의 내용을 받아 넣는 자리
                어떤 component라도 다 삽입 가능 -> 결합도 낮춤 -->
      <slot></slot>
    </div>
    <Footer />
  </div>
</template>
