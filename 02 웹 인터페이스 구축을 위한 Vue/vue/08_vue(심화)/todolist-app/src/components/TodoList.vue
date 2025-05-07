<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <!-- 'emit()'함수를 이용해 이벤트 발신 -->
        <TodoListItem
          v-for="todoItem in todoList"
          :key="todoItem.id"
          :todoItem="todoItem"
          @delete-todo="emit('delete-todo', todoItem.id)"
          @toggle-completed="emit('toggle-completed', todoItem.id)"
        />
      </ul>
    </div>
  </div>
</template>

<script setup>
import TodoListItem from './TodoListItem.vue';

const props = defineProps({
  todoList: {
    type: Array,
    required: true,
  },
});
// 'defineEmits' 함수 이용해 정의 -> 'emit()' 함수 리턴
const emit = defineEmits(['delete-todo', 'toggle-completed']);
</script>
