<template>
  <!-- 'navbar' 스타일 지정 -->
  <!-- navbar-expand-md : 브라우저의 가로폭이 md이상이면 펼쳐짐 -->
  <!-- md : medium desktop - 768 이상 -->
  <!-- mt-2 : 위 바깥쪽 여백 2 -->
  <nav class="navbar navbar-expand-md bg-dark navbar-dark mt-2">
    <spa class="navbar-brand">이날치</spa>
    <button class="navbar-toggler" type="button" @click="changeIsNavShow">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div :class="navClass">
      <ul class="navbar-nav">
        <li class="nav-item">
          <!-- router-link 컴포넌트 : 클릭 이동 -->
          <router-link class="nav-link" to="/">홈</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/about">소개</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/members">멤버</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/videos">영상</router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
import { reactive, computed } from 'vue'

export default {
  setup() {
    const state = reactive({
      isNavShow: false,
    })
    // isNavShow = true -> collapse navbar-collapse show (내비게이션 바 나타남)
    // isNavShow = false -> collapse navbar-collapse (내비게이션 바 접어둠 - 햄버거 버튼)
    const navClass = computed(() =>
      state.isNavShow ? 'collapse navbar-collapse show' : 'collapse navbar-collapse',
    )
    const changeIsNavShow = () => {
      state.isNavShow = !state.isNavShow
    }
  },
}
</script>
