<template>
  <div class="container">
    <Header></Header>
    <router-view />
  </div>
</template>

<script setup>
import { reactive, computed, provide, onMounted } from 'vue'
import Header from '@/components/Header.vue'
import axios from 'axios'

const BASEURI = '/api/todos'
const states = reactive({ todoList: [] })

// TodoList 목록 조회
const fetchTodoList = async () => {
  try {
    // GET 요청 전송
    // API에서 데이터 받아오기
    const response = await axios.get(BASEURI)
    // 200 -> 정답 응답 확인
    if (response.status === 200) {
      // 받아온 데이터를 상태에 반영 (vue 업데이트)
      states.todoList = response.data
    } else {
      alert('데이터 조회 실패')
    }
  } catch (error) {
    alert('에러 발생 : ' + error)
  }
}

// 새로운 TodoItem 추가
const addTodo = async ({ todo, desc }, successCallback) => {
  try {
    // 보낼 데이터
    const payload = { todo, desc, done: false }
    // POST 요청 전송
    const response = await axios.post(BASEURI, payload)
    // 생성 성공 확인
    if (response.status === 201) {
      // 로컬 상태도 함께 업데이트
      states.todoList.push({ ...response.data, done: false })
      // 성공 후 실행할 함수
      successCallback()
    } else {
      alert('Todo 추가 실패')
    }
  } catch (error) {
    alert('에러 발생 : ' + error)
  }
}

// 기존 TodoItem 변경
const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
  try {
    const payload = { id, todo, desc, done }
    // PUT 요청 전송
    const response = await axios.put(`${BASEURI}/${id}`, payload)
    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id)
      // 데이터 변경
      states.todoList[index] = payload
      successCallback()
    } else {
      alert('Todo 변경 실패')
    }
  } catch (error) {
    alert('에러 발생 : ' + error)
  }
}

// 기존 TodoItem 삭제
const deleteTodo = async (id) => {
  try {
    // DELETE 요청 전송
    const response = await axios.delete(`${BASEURI}/${id}`)
    console.log(response.status, response.data)
    if (response.status === 200) {
      let index = states.todoList.findIndex((todo) => todo.id === id)
      // 데이터 삭제
      states.todoList.splice(index, 1)
    } else {
      alert('Todo 삭제 실패')
    }
  } catch (error) {
    alert('에러 발생 : ' + error)
  }
}
// 기존 TodoItem의 완료여부(done) 값 토글
const toggleDone = async (id) => {
  try {
    let todo = states.todoList.find((todo) => todo.id === id)
    let payload = { ...todo, done: !todo.done }
    // PUT 요청 전송
    const response = await axios.put(`${BASEURI}/${id}`, payload)
    if (response.status === 200) {
      // payload.done: !todo.done -> 반대로 바꿔줌
      todo.done = payload.done
    } else {
      alert('Todo 완료 변경 실패')
    }
  } catch (error) {
    alert('에러 발생 : ' + error)
  }
}

onMounted(() => {
  fetchTodoList()
})

provide(
  'todoList',
  computed(() => states.todoList),
)
provide('actions', { addTodo, deleteTodo, toggleDone, updateTodo, fetchTodoList })
</script>
