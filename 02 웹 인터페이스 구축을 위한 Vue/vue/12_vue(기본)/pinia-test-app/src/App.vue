<template>
  <div>
    <h2>TodoList 테스트 (Composition API)</h2>
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
        <!-- &nbsp (non-breaking-space) : 띄어쓰기 한 칸 (줄 바뀌어도 무조건 같이 다님)  -->
        &nbsp;&nbsp;&nbsp;
        <button @click="deleteTodo(todoItem.id)">삭제</button>
      </li>
    </ul>
    <div>완료된 할일 수 : {{ doneCount }}</div>
  </div>
</template>

<script>
import { useTodoListStore } from './stores/todoList';
import { ref, computed } from 'vue';

export default {
  name: 'App',
  setup() {
    const todo = ref('');

    const TodoListStore = useTodoListStore();
    const { todoList, addTodo, deleteTodo, toggleDone } = TodoListStore;
    const doneCount = computed(() => TodoListStore.doneCount);

    const addTodoHandler = () => {
      addTodo(todo.value);
      todo.value = '';
    };
    return {
      todo,
      todoList,
      addTodoHandler,
      deleteTodo,
      toggleDone,
      doneCount,
    };
  },
};
</script>
