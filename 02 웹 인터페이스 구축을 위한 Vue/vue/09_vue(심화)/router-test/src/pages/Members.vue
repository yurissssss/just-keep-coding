<template>
  <div>
    <h2 class="m-4">이날치 멤버</h2>
    <div class="container">
      <div class="row">
        <div v-for="m in members" :key="m.id" class="col-6 col-xs-6 col-sm-4 col-md-3 col-lg-2">
          <!-- m = { id: 5, name: '이날치' } -> <a href="/members/5">이날치</a> -->
          <router-link :to="'/members/' + m.id">
            <img
              class="img-thumbnail"
              style="width: 90px; height: 110px"
              :src="m.photo"
              :title="m.name"
            />
            <br />
            <h6 class="display-7">{{ m.name }}</h6>
          </router-link>
        </div>
      </div>
    </div>

    <!-- 'index.js'에서 'children'에 'MemberInfo.vue' 등록할 경우 -->
    <!-- <router-view /> -->
  </div>
</template>

<script>
// '@' : 'src/' 디렉토리
// '@/members.json' -> 'src/members.json'
import members from '@/members.json'

export default {
  name: 'Members',
  setup() {
    return { members }
  },
}
</script>
