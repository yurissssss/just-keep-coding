import { useAuthStore } from '@/stores/auth';
/**
 * 로그인 여부에 따라 인증을 할 수 있는 로그인 페이지를 호출하도록 함수 정의
 *  => 로그인 여부가 저장되어 있는 pinia 저장소 필요
 */
export const isAuthenticated = (to, from) => {
  const auth = useAuthStore();

  // 중앙 저장소에서 로그인 정보 가지고 와서
  //  아직 로그인 X -> 로그인 페이지 호출
  if (!auth.isLogin) {
    console.log('로그인 필요.....');

    /**
     * 로그인 페이지로 리디렉션 하면서,
     * 로그인 후 이동할 목적지의 이름을(to.name)을 queryString으로 함께 전달
     *
     * '/login'이라는 이름으로 저장되어 있는 router
     * query의 'next'는 로그인 성공 후 이동할 라우트의 이름
     */
    return { name: 'login', query: { next: to.name } };
  }

  console.log('인증가드 완료');
};
