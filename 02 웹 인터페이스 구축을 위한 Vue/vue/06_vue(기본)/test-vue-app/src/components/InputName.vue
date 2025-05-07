<template>
  <div style="border: 1px solid gray; padding: 5px">
    이름: <input type="text" v-model="name" />
    <!-- button 클릭 시 'nameChanged' 이벤트 전송 ('name' 값을 데이터로 전달)-->
    <button @click="$emit('nameChanged', { name })">이벤트 발신</button>
  </div>
</template>

<script>
export default {
  // 파일명과 동일하게
  name: 'InputName',
  // 이벤트 유효성 검사
  emits: {
    nameChanged: (e) => {
      // name 값 있어야 함 & 문자열 타입 & 길이가 3이상
      return e.name && typeof e.name === 'string' && e.name.trim().length >= 3 ? true : false
    },
  },
  data() {
    return {
      name: '',
    }
  },
}
</script>
