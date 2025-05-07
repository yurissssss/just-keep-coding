<template>
  X : <input type="text" v-model.number="state.x" /><br />
  Y : <input type="text" v-model.number="state.y" /><br />
  <div>결과 : {{ result }}</div>
</template>

<script>
import { reactive, computed } from 'vue'

export default {
  name: 'Calc4',
  setup() {
    const state = reactive({ x: 10, y: 20 })
    // 'computed()'메서드 이용 -> 계산된 값 저장
    const result = computed(() => {
      return state.x + state.y
    })
    return { result, state }
  },
}
</script>
