import { createApp } from 'vue';
import router from '@/router/router'
import store from '@/store/store'

import App from './App.vue'
// import Login from "@/views/Login"

const app = createApp(App);

app.use(router);
app.use(store)

app.mount('#app');