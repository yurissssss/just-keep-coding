<template>
  <div>
    X : <input type="text" v-model.number="state.x" /><br />
    Y : <input type="text" v-model.number="state.y" />br
    <button @click="calcAdd">계산</button>
    <div>결과 : {{ state.result }}</div>
  </div>
</template>

<script>
import { reactive } from 'vue'

export default {
  name: 'Calc3',
  setup() {
    // (객체) 반응성을 가질 수 있도록 'reactive()'로 선언
    const state = reactive({ x: 10, y: 20, result: 30 })
    const calcAdd = () => {
      state.result = state.x + state.y
    }
    return { state, calcAdd }
  },
}
</script>
