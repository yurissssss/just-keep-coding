<script setup>
import api from '@/api/boardApi';
import { ref, reactive, computed, watch } from 'vue';
import moment from 'moment';
import { useRoute, useRouter } from 'vue-router';

// 현재 라우트 정보를 가져오기 위한 훅 (query, params 등 접근 가능)
const cr = useRoute();
// 컴포넌트를 호출할 때 입력값을 줄 수 있음
const router = useRouter();
// 서버에서 받아올 게시글 페이지 데이터를 저장하는 반응형 변수
// page변수(페이지) 변하는지 자동 체크 설정
// -> 변하면 자동으로 pages의 값을 꺼내와서 articles에 넣어줌
const page = ref({});

// page 객체 내의 list 속성(게시글 목록)을 계산된 속성으로 반환함
// page.value가 변경되면 자동으로 articles도 반응적으로 갱신됨
const articles = computed(() => page.value.list);

// Composition API의 reactive 함수를 사용해 반응형 객체 pageRequest를 생성
const pageRequest = reactive({
  // 현재 페이지 번호를 설정: URL 쿼리 파라미터에서 page 값을 가져와 정수로 변환, 없으면 기본값 1
  page: parseInt(cr.query.page) || 1,
  // 한 페이지에 보여줄 항목 수를 설정: URL 쿼리 파라미터에서 amount 값을 가져와 정수로 변환, 없으면 기본값 10
  amount: parseInt(cr.query.amount) || 10,
});

// 페이지네이션에서 페이지 번호를 클릭했을 때 실행되는 함수
const handlePageChange = async (pageNum) => {
  // URL의 query 문자열을 변경함 (예: ?page=2&amount=10)
  // 이때 컴포넌트가 다시 마운트되지는 않으므로 별도의 데이터 재로딩이 필요함
  // → 이후 watch()를 통해 라우트 정보 변경 감지하여 데이터 다시 불러옴
  router.push({
    // 현재 페이지와 한 페이지당 항목 수 전달
    query: { page: pageNum, amount: pageRequest.amount },
  });
};

// 라우트 정보(cr.query)가 변경될 때마다 실행됨
//  -> 사용자가 URL에서 page, amount를 변경하거나, router.push 등으로 이동 시 감지됨
watch(cr, async (newValue) => {
  // 변경된 페이지 번호 확인용 로그 출력
  console.log('WATCH', cr.query.page);

  // query에서 page와 amount 값을 읽어와 정수로 변환 후 pageRequest에 반영
  pageRequest.page = parseInt(cr.query.page);
  pageRequest.amount = parseInt(cr.query.amount);

  // 변경된 pageRequest 정보를 기반으로 게시글 데이터를 다시 불러옴
  await load(pageRequest);
});

// 이 컴포넌트가 마운트되었을 때
// 자동으로 axios를 불러서 list를 가지고 와야함
// 'load()' 함수 정의 후 --> 시작하자마자 호출

/**
 * 게시글 목록 데이터를 서버(API)에서 비동기로 불러오는 함수 정의
 *
 * 아래에 page 번호를 클릭했을 때 함수를 호출하게 함.
 * 함수는 나를 다시 호출함. (페이지 번호와 한 페이지 당 -> amount)
 *
 * 주소가 바뀌고, 주소 쿼리스트링이 바뀌면 cr의 쿼리를 pageRequest가 변하는지 설정했으므로
 * 자동으로 주소 뒤에 쿼리스트링이 바뀌었을 때 자동으로 처리해 줄 것 을 설정
 *  ==> watch 사용
 * load(pageRequest)를 불러줌.
 */
const load = async (query) => {
  try {
    // API 호출: 전달받은 query 객체(page, amount)를 기반으로 게시글 목록 요청
    // 결과를 page.value에 할당하여 반응형 상태로 저장
    page.value = await api.getList(query);

    // 디버깅을 위한 콘솔 출력 (불러온 페이지 데이터 확인용)
    console.log(page.value);
  } catch {}
  // 에러 발생 시 특별한 처리는 없고 조용히 무시함 (필요 시 catch 블록 확장 가능)
};

// 해당 컴포넌트가 load되면 바로 'load()'함수를 호출하여 백엔드 서버로부터 json(api 실행결과)을 받아옴
//  -> page변수에 넣어줌 -> page 값 변경 --> 자동으로 page값을 꺼내서 articles에 넣어줌
// load();

// 컴포넌트가 마운트될 때 게시글 목록을 처음 한 번 불러옴
// 이후 페이지 번호 변경 시에는 watch(cr)에 의해 자동 호출됨
load(pageRequest);
</script>

<template>
  <div>
    <h1 class="mb-3"><i class="fa-solid fa-paste"></i> 게시글 목록</h1>

    <div class="mt-5 text-end">(총 {{ page.totalCount }}건)</div>

    <table class="table table-striped">
      <thead>
        <tr>
          <th style="width: 60px">No</th>
          <th>제목</th>
          <th style="width: 100px">작성자</th>
          <th style="width: 120px">작성일</th>
        </tr>
      </thead>

      <tbody>
        <tr v-for="article in articles" :key="article.no">
          <td>{{ article.no }}</td>
          <td>
            <!-- 목록에서 제목 클릭 시, 현재 페이지 쿼리 정보도 함께 전달하여
                  상세페이지 -> 목록 돌아올 때 어떤 페이지였는지 유지할 수 있게 함 -->
            <router-link
              :to="{
                name: 'board/detail',
                params: { no: article.no },
                query: cr.query,
              }"
            >
              {{ article.title }}
            </router-link>
          </td>
          <td>{{ article.writer }}</td>
          <td>{{ moment(article.regDate).format('YYYY-MM-DD') }}</td>
        </tr>
      </tbody>
    </table>

    <div class="my-5 d-flex">
      <div class="flex-grow-1 text-center">
        <!-- 페이지 네이션 -->
        <vue-awesome-paginate
          :total-items="page.totalCount"
          :items-per-page="pageRequest.amount"
          :max-pages-shown="5"
          :show-ending-buttons="true"
          v-model="pageRequest.page"
          @click="handlePageChange"
        >
          <template #first-page-button
            ><i class="fa-solid fa-backward-fast"></i
          ></template>
          <template #prev-button
            ><i class="fa-solid fa-caret-left"></i
          ></template>
          <template #next-button
            ><i class="fa-solid fa-caret-right"></i
          ></template>
          <template #last-page-button
            ><i class="fa-solid fa-forward-fast"></i
          ></template>
        </vue-awesome-paginate>
      </div>
      <div>
        <router-link
          :to="{ name: 'board/create', query: cr.query }"
          class="btn btn-primary"
        >
          <i class="fa-solid fa-pen-to-square"></i> 글 작성
        </router-link>
      </div>
    </div>
  </div>
</template>
