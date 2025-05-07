<template>
  <input
    type="text"
    :value="name"
    @input="$emit('update:name', $event.target.value)"
  />
</template>

<script>
export default {
  name: 'InputName',
  // name 프로퍼티 추가
  props: ['name'],
};
</script>
