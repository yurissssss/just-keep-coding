import { createApp } from 'vue'
import 'bootstrap/dist/css/bootstrap.css'
import App from './App.vue'
import router from './router'

const app = createApp(App)
// 'main.js'에 등록 -> 전역 컴포넌트로 등록 => 앱 내부의 모든 컴포넌트에서 사용 가능
app.use(router)
app.mount('#app')
