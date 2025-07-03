// 게시글 관련 라우팅

import { isAuthenticated } from '@/util/guards';

export default [
  {
    path: '/board/list',
    name: 'board/list',
    component: () => import('../pages/board/BoardListPage.vue'),
  },
  {
    path: '/board/detail/:no',
    name: 'board/detail',
    component: () => import('../pages/board/BoardDetailPage.vue'),
  },
  {
    path: '/board/create',
    name: 'board/create',
    component: () => import('../pages/board/BoardCreatePage.vue'),
    // 들어가기 전에 'isAuthenticated' 함수 실행
    beforeEnter: isAuthenticated,
  },
  {
    path: '/board/update/:no',
    name: 'board/update',
    component: () => import('../pages/board/BoardUpdatePage.vue'),
    // 들어가기 전에 'isAuthenticated' 함수 실행
    beforeEnter: isAuthenticated,
  },
];
