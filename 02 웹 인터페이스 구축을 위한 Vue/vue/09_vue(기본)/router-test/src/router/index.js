import { createRouter, createWebHistory } from 'vue-router'

import Home from '@/pages/Home.vue'
import About from '@/pages/About.vue'
import Members from '@/pages/Members.vue'
import Videos from '@/pages/Videos.vue'
import Memberinfo from '@/pages/Memberinfo.vue'

// 'createRouter'함수 -> vue-router 객체 생성
const router = createRouter({
  // 라우팅 모드 지정 : 'HTML5 History API' 사용
  // 주소 : /about (HTML5 기반) -> 깔끔
  // createWebHashHistory() : #/about (해시 기반)
  history: createWebHistory(),
  // 라우트 경로마다 보여울 컴포넌트 -> 배열
  routes: [
    // Home.vue
    {
      path: '/',
      name: 'home',
      component: Home,
    },

    // About.vue
    {
      path: '/about',
      name: 'about',
      component: About,
    },

    // Members.vue
    {
      path: '/members',
      name: 'members',
      component: Members,

      // MemberInfo.vue
      // children: [
      //   {
      //     path: ':id',
      //     name: 'members/id',
      //     component: Memberinfo,
      //   },
      // ],
    },

    // MemberInfo.vue
    {
      path: '/members/:id',
      name: 'members/id',
      component: Memberinfo,
    },

    // Videos.vue
    {
      path: '/videos',
      name: 'videos',
      component: Videos,
    },
  ],
})

// 생성한 vue-router 객체 export
export default router
