<template>
  <div>
    X : <input type="text" v-model.number="x" /><br />
    Y : <input type="text" v-model.number="y" /><br />
  </div>
</template>

<script>
import { ref } from 'vue'

export default {
  name: 'Calc',
  setup() {
    // (기본) 반응성을 가질 수 있도록 'ref()'로 선언
    const x = ref(10) // 10으로 초기화
    const y = ref(20) // 20으로 초기화
    // setup()의 데이터 이용 -> "객체" 형태로 리턴
    return { x, y }
  },
}
</script>
