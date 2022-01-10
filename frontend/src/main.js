import { createApp } from 'vue';

import store from '@/store/store'
import router from '@/router/router'

import App from './App.vue'

const app = createApp(App);

app.use(router);
app.use(store);

app.mount('#app');