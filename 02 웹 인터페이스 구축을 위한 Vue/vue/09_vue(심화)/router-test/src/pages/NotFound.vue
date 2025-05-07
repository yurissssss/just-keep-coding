<!-- 잘못된 요청이 온 경우 -->

<template>
  <div class="card card-body">
    <h2>404 Not Found</h2>
    <p>존재하지 않는 요청 경로 : {{ $route.fullPath }}</p>
  </div>
</template>

<script>
export default {
  name: 'Not Found',
  created() {
    console.log(this.$route.params)
  },
}
</script>
