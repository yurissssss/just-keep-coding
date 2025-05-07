<template>
  <div class="row">
    <div class="col p-3">
      <h2>할 일 추가</h2>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <div class="form-group">
        <label for="todo">할 일 : </label>
        <input type="text" class="form-control" id="todo" v-model="todoItem.todo" />
      </div>
      <div class="form-group">
        <label for="desc">설명 : </label>
        <input type="text" class="form-control" id="desc" v-model="todoItem.desc" />
      </div>
      <div class="form-group">
        <button type="button" class="btn btn-primary m-1" @click="addTodoHandler">추 가</button>
      </div>
      <div class="form-group">
        <!-- 브라우저 주소가 '/todos'로 바뀜 -->
        <!-- 'App.vue'의 <router-view/>자리에 'TodoList.vue'가 들어감 -->
        <button type="button" class="btn btn-primary m-1" @click="router.push('/todos')">
          취 소
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { inject, reactive } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
// inject('actions').addTodo()
const { addTodo } = inject('actions')
const todoItem = reactive({ todo: '', desc: '' })

const addTodoHandler = () => {
  let { todo } = todoItem
  // 예외 처리
  if (!todo || todo.trim() === '') {
    alert('할일은 반드시 입력해야 합니다')
    return
  }
  addTodo({ ...todoItem, done: false }, () => {
    router.push('/todos')
  })
}
</script>
