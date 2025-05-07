<template>
  <div class="card card-body">
    <h2>Member Info</h2>
    <div className="mt-5">
      <img :src="member.photo" class="img" alt="member img" />
      <h4 class="mt-2">{{ member.name }}({{ member.role }})</h4>
      <p>{{ member.desc }}</p>
      <a
        v-if="member.insta && member.insta !== ''"
        class="fa fa-instagram m-1"
        :href="member.insta"
      ></a>
      <a
        v-if="member.facebook && member.facebook !== ''"
        class="fa fa-facebook m-1"
        :href="member.facebook"
      ></a>
      <a
        v-if="member.youtube && member.youtube !== ''"
        class="fa fa-youtube m-1"
        :href="member.youtube"
      ></a>
      <br /><br />
      <router-link to="/members">멤버 목록으로</router-link>
    </div>

    <div>
      경로 패턴 : /members/:id <br />
      요청 경로 : {{ currentRoute.path }} <br />
      <!-- params : URL 안의 ':변수명'부분에 들어온 값 (라우터 객체 안에 있는 속성) -->
      <!-- params : /user/:id -> { id: '123' } -->
      <!-- query : /search?q=vue -> { q: 'vue' } -->
      <!-- fullPath : 전체경로/user/123 -->
      <!-- path : 현재경로/user/123 -->
      id 값 : {{ currentRoute.params.id }} <br />
    </div>
  </div>
</template>

<script>
import { useRoute } from 'vue-router'
import members from '@/members.json'

export default {
  name: 'MemberInfo',
  setup() {
    // 현재 라우트 정보 저장
    // 'useRoute()'는 'Composition API의 setup()' / '<script setup>' 안에서만 사용 가능
    // -> 외부에서 사용하려면 'inject()'방식 / 전역 접근
    const currentRoute = useRoute()

    // 10 : 10진수
    const id = parseInt(currentRoute.params.id, 10)
    const member = members.find((m) => m.id === id)
    return { member, currentRoute }
  },
}
</script>
