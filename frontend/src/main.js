import { createApp } from 'vue';

import App from '@/App'
import {store} from '@/store/store'
import router from '@/routes/router'
import VueCookies from 'vue3-cookies';

const app = createApp(App);
app.use(store);
app.use(router);
app.use(VueCookies);

app.mount('#app');