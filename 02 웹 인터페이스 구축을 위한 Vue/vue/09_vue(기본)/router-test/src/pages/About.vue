<template>
  <div class="card card-body">
    <h2>About</h2>
    <p>요청 경로 : {{ $route.fullPath }}</p>
    <!--요청 경로 : /about  -->
  </div>
</template>

<script>
import { useRoute } from 'vue-router'

export default {
  name: 'About',

  // 'Composition API'로 정의
  // -> 'setup()' 함수 안에 선언, 'return'으로 반환, this (X)
  setup() {
    const currentRoute = useRoute()
    console.log(currentRoute)
    return { currentRoute }
  },

  //   created() {
  //     console.log(this.$route)
  //   },
}
</script>
