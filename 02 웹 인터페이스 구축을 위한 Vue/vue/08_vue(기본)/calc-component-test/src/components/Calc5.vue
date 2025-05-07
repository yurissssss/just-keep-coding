<template>
  <div>
    X : <input type="text" v-model.number="x" /><br />
    결과 : {{ result }}
  </div>
</template>

<script>
import { watch, ref } from 'vue'

export default {
  name: 'Calc5',
  setup() {
    const x = ref(0) // 0으로 초기화
    const result = ref(0) // 0으로 초기화
    // 'watch' 이용 -> 반응성 데이터 객체(ref()) 감사
    // watch(데이터, (변경된 값, 변경되기 전 값))
    watch(x, (current, old) => {
      // 값 바뀔때마다 콘솔에 출력
      console.log(`${old} ==> ${current}`)
      result.value = current * 2
    })
    return { x, result }
  },
}
</script>
