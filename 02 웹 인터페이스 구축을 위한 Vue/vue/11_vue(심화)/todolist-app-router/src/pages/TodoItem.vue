<template>
  <li :class="todoItem.done ? 'list-group-item list-group-item-success' : 'list-group-item'">
    <span :class="todoItem.done ? 'todo-done pointer' : 'pointer'" @click="toggleDone(todoItem.id)">
      {{ todoItem.todo }}
      {{ todoItem.done ? '(완료)' : '' }}
    </span>
    <span
      class="float-end badge bg-secondary pointer m-1"
      @click="router.push(`/todos/edit/${todoItem.id}`)"
    >
      편집</span
    >
    <span class="float-end badge bg-secondary pointer m-1" @click="deleteTodo(todoItem.id)">
      삭제</span
    >
  </li>
</template>

<script setup>
import { useRouter } from 'vue-router'
import { inject } from 'vue'

defineProps({
  todoItem: {
    type: Object,
    required: true,
  },
})

const router = useRouter()
// inject('actions') : 상위 컴포넌트의 'actions' 값 가져옴
// App.vue -> provide('actions', { addTodo, deleteTodo, toggleDone, updateTodo })
// { deleteTodo, toggleDone } : 그 안의 메서드 두 개를 구조 분해 할당
const { deleteTodo, toggleDone } = inject('actions')
</script>
