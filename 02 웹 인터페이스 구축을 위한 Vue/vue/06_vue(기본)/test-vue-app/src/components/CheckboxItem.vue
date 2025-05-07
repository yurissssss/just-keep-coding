<template>
  <li><input type="checkbox" :checked="checked" /> {{ id }} - {{ name }}</li>
</template>

<script>
export default {
  name: 'CheckboxItem',
  props: {
    // id는 Number / String 타입만 가능
    id: [Number, String],
    name: String,
    checked: {
      type: Boolean,
      // 필수 X
      required: false,
      // 기본값 false
      default: false,
    },
  },
};
</script>
