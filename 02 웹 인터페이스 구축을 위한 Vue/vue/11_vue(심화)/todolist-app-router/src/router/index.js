import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/pages/Home.vue'
import About from '@/pages/About.vue'
import TodoList from '@/pages/TodoList.vue'
import AddTodo from '@/pages/AddTodo.vue'
import EditTodo from '@/pages/EditTodo.vue'
import NotFound from '@/pages/NotFound.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/about',
      name: 'about',
      component: About,
    },
    {
      path: '/todos',
      name: 'todolist',
      component: TodoList,
    },
    {
      path: '/todos/add',
      name: 'todos/add',
      component: AddTodo,
    },
    {
      path: '/todos/edit/:id',
      name: 'todos/edit/id',
      component: EditTodo,
    },
    {
      // '/:paths(.*)*' : 모든 경로(*)에 매치하는 라우트
      path: '/:paths(.*)*',
      name: 'notfound',
      component: NotFound,
    },
  ],
})

export default router
