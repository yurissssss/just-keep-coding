import { defineStore } from 'pinia'
import { reactive, computed } from 'vue'
import axios from 'axios'

const BASEURI = '/api/todos'

export const useTodoListStore = defineStore('todoList', () => {
  const state = reactive({
    todoList: [],
    isLoading: false,
  })

  // TodoList 목록 조회
  const fetchTodoList = async () => {
    state.isLoading = true
    try {
      const response = await axios.get(BASEURI)
      if (response.status === 200) {
        state.todoList = response.data
      } else {
        alert('데이터 조회 실패')
      }
      state.isLoading = false
    } catch (error) {
      alert('에러 발생 : ' + error)
      state.isLoading = false
    }
  }
  // 새로운 TodoItem 추가
  const addTodo = async ({ todo, desc }, successCallback) => {
    if (!todo || todo.trim() === '') {
      alert('할일은 반드시 입력해야 합니다')
      return
    }
    state.isLoading = true
    try {
      const payload = { todo, desc }
      const response = await axios.post(`${BASEURI}`, payload)
      if (response.status === 201) {
        state.todoList.push({ id: response.data.item.id, todo, desc, done: false })
        successCallback()
      } else {
        alert('Todo 추가 실패')
      }
      state.isLoading = false
    } catch (error) {
      alert('에러 발생 : ' + error)
      state.isLoading = false
    }
  }
  // 기존 TodoItem 변경
  const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
    if (!todo || todo.trim() === '') {
      alert('할일은 반드시 입력해야 합니다')
      return
    }
    state.isLoading = true
    try {
      const payload = { id, todo, desc, done }
      const response = await axios.put(`${BASEURI}/${id}`, payload)
      if (response.status === 200) {
        let index = state.todoList.findIndex((todo) => todo.id === id)
        state.todoList[index] = payload
        successCallback()
      } else {
        alert('Todo 변경 실패')
      }
      state.isLoading = false
    } catch (error) {
      alert('에러 발생 : ' + error)
      state.isLoading = true
    }
  }
  // 기존 TodoItem 삭제
  const deleteTodo = async (id) => {
    state.isLoading = true
    try {
      const response = await axios.delete(`${BASEURI}/${id}`)
      if (response.status === 200) {
        let index = state.todoList.findIndex((todo) => todo.id === id)
        state.todoList.splice(index, 1)
      } else {
        alert('Todo 삭제 실패')
      }
      state.isLoading = false
    } catch (error) {
      alert('에러 발생 : ' + error)
      state.isLoading = false
    }
  }
  // 기존 TodoItem 완료여부(done) 값 토글
  const toggleDone = async (id) => {
    state.isLoading = true
    try {
      let todo = state.todoList.find((todo) => todo.id === id)
      let payload = { ...todo, done: !todo.done }
      const response = await axios.put(`${BASEURI}/${id}`, payload)
      if (response.status === 200) {
        let index = state.todoList.findIndex((todo) => todo.id === id)
        state.todoList[index].done = payload.done
      } else {
        alert('Todo 완료 변경 실패')
      }
      state.isLoading = false
    } catch (error) {
      alert('에러 발생 : ' + error)
      state.isLoading = false
    }
  }

  const todoList = computed(() => state.todoList)
  const isLoading = computed(() => state.isLoading)
  const doneCount = computed(() => {
    const filtered = state.todoList.filter((todoItem) => todoItem.done === true)
    return filtered.length
  })
  return {
    todoList,
    isLoading,
    doneCount,
    fetchTodoList,
    addTodo,
    deleteTodo,
    updateTodo,
    toggleDone,
  }
})
