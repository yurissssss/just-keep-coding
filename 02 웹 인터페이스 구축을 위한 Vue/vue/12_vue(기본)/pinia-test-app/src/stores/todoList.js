import { defineStore } from 'pinia';
import { reactive, computed } from 'vue';

// Options API 방식
// export const useTodoListStore = defineStore('todoList', {
//   반응형 상태
//   state: () => ({
//     todoList: [
//       { id: 1, todo: 'ES6학습', done: false },
//       { id: 2, todo: 'React학습', done: false },
//       { id: 3, todo: 'ContextAPI 학습', done: true },
//       { id: 4, todo: '야구경기 관람', done: false },
//     ],
//   }),
//   getters: {
//     doneCount: (state) => {
//       // 'state,todoList'에서 'todoItem.done === true'인 것들만 .filter()로 추출
//       // .length (개수) 리턴
//       return state.todoList.filter((todoItem) => todoItem.done === true).length;
//     },
//   },

//   actions: {
//     addTodo(todo) {
//       this.todoList.push({ id: new Date().getTime(), todo, done: false });
//     },
//     deleteTodo(id) {
//       let index = this.todoList.findIndex((todo) => todo.id === id);
//       this.todoList.splice(index, 1);
//     },
//     toggleDone(id) {
//       let index = this.todoList.findIndex((todo) => todo.id === id);
//       this.todoList[index].done = !this.todoList[index].done;
//     },
//   },
// });

// Compostion API 방식
export const useTodoListStore = defineStore('todoList', () => {
  const state = reactive({
    todoList: [
      { id: 1, todo: 'ES6학습', done: false },
      { id: 2, todo: 'React학습', done: false },
      { id: 3, todo: 'ContextAPI 학습', done: true },
      { id: 4, todo: '야구경기 관람', done: false },
    ],
  });

  // action
  const addTodo = (todo) => {
    state.todoList.push({ id: new Date().getTime(), todo, done: false });
  };
  const deleteTodo = (id) => {
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList.splice(index, 1);
  };
  const toggleDone = (id) => {
    let index = state.todoList.findIndex((todo) => todo.id === id);
    state.todoList[index].done = !state.todoList[index].done;
  };
  const doneCount = computed(() => {
    return state.todoList.filter((todoItem) => todoItem.done === true).length;
  });
  const todoList = computed(() => state.todoList);

  return { todoList, doneCount, addTodo, deleteTodo, toggleDone };
});
