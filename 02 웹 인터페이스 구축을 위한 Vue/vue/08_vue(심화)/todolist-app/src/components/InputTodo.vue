<template>
  <div class="row mb-3">
    <div class="col">
      <div class="input-group">
        <input
          id="msg"
          type="text"
          class="form-control"
          name="msg"
          placeholder="할일을 여기에 입력!"
          v-model.trim="todo"
          @keyup.enter="addTodoHandler"
        />
        <span class="btn btn-primary input-group addon" @click="addTodoHandler"
          >추가
        </span>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

// 'add-todo' 이벤트 발신하기 위한 준비
// <script setup>에서는 'this.$emit'(X)
// defineEmits : 이벤트 정의
const emit = defineEmits(['add-todo']);
const todo = ref('');
const addTodoHandler = () => {
  if (todo.value.length >= 3) {
    emit('add-todo', todo.value);
    todo.value = '';
  }
};
</script>
