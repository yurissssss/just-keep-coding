<template>
  <div>
    <h2>TodoList 테스트 (Options API)</h2>
    <hr />
    할 일 추가 :
    <input type="text" v-model="todo" />
    <button @click="addTodoHandler">추가</button>
    <hr />
    <ul>
      <li v-for="todoItem in todoList">
        <span style="cursor: pointer" @click="toggleDone(todoItem.id)">
          {{ todoItem.todo }} {{ todoItem.done ? '(완료)' : '' }}
        </span>
        <!-- &nbsp (non-braking-space) : 띄어쓰기 한 칸 (줄 바뀌어도 무조건 같이 다님)  -->
        &nbsp;&nbsp;&nbsp;
        <button @click="deleteTodo(todoItem.id)">삭제</button>
      </li>
    </ul>
    <div>완료된 할일 수 : {{ doneCount }}</div>
  </div>
</template>

<script>
import { useTodoListStore } from './stores/todoList';
import { mapState, mapActions } from 'pinia';

export default {
  name: 'App_Options',
  data: () => ({ todo: '' }),
  computed: {
    ...mapState(useTodoListStore, ['todoList', 'doneCount']),
  },
  methods: {
    ...mapActions(useTodoListStore, ['addTodo', 'deleteTodo', 'toggleDone']),
    addTodoHandler() {
      this.addTodo(this.todo);
      this.todo = '';
    },
  },
};
</script>
