<template>
  <div class="container">
    <div class="card card-body bg-light">
      <div class="title">:: Todolist App</div>
    </div>
    <div class="card card-default card-borderless">
      <div class="card-body">
        <!-- 자식 컴포넌트(InputTodo)가 이벤트(add-todo) 전달 -->
        <!-- 받은 이벤트를 'addTodo()'메서드로 처리 -->
        <InputTodo @add-todo="addTodo"></InputTodo>
        <!-- 수신한 이벤트로 실행할 메서드 -> this(X), 'state(반응성 데이터)'이용 -->
        <TodoList
          :todoList="state.todoList"
          @delete-todo="deleteTodo"
          @toggle-completed="toggleCompleted"
        ></TodoList>
      </div>
    </div>
  </div>
</template>

<!-- <script setup>의 최상위 범위에 작성한 변수/함수 -> 템플릿에서 이용 가능 -->
<!-- -> 'setup()'함수(X), 'return'(X) -->
<script setup>
import { onMounted, reactive } from 'vue';
import InputTodo from './components/InputTodo.vue';
import TodoList from './components/TodoList.vue';

const ts = new Date().getTime();
const state = reactive({ todoList: [] });

onMounted(() => {
  state.todoList.push({ id: ts, todo: '자전거 타기', completed: false });
  state.todoList.push({
    id: ts + 1,
    todo: '딸과 공원 산책',
    completed: true,
  });
  state.todoList.push({
    id: ts + 2,
    todo: '일요일 애견 카페',
    completed: false,
  });
  state.todoList.push({
    id: ts + 3,
    todo: 'Vue 원고 집필',
    completed: false,
  });
});

const addTodo = (todo) => {
  if (todo.length >= 2) {
    state.todoList.push({
      id: new Date().getTime(),
      todo: todo,
      completed: false,
    });
  }
};
const deleteTodo = (id) => {
  let index = state.todoList.findIndex((item) => id === item.id);
  state.todoList.splice(index, 1);
};
const toggleCompleted = (id) => {
  let index = state.todoList.findIndex((item) => id === item.id);
  state.todoList[index].completed = !state.todoList[index].completed;
};
</script>
