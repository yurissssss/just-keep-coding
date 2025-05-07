<template>
  <div class="row">
    <div class="col p-3">
      <!-- 클릭 -> 'AddTodo.vue'가 <router-view/>에 렌더링 -->
      <router-link class="btn btn-primary" to="/todos/add">할 일 추가</router-link>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoItem v-for="todoItem in todoList" :key="todoItem.id" :todoItem="todoItem" />
      </ul>
    </div>
  </div>
</template>

<script setup>
import { inject } from 'vue'
import TodoItem from './TodoItem.vue'

const todoList = inject('todoList')
</script>
