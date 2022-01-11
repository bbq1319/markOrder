import {createWebHistory, createRouter} from 'vue-router';
import VueCookie from 'vue-cookies';

const routes = [
	{
		path: '/',
		redirect: '/login'
	},
	{
		path: '/login',
		name: 'Login',
		component: () => import('@/views/Login'),
	},
	{
		path: '/main',
		name: 'Main',
		component: () => import('@/views/Main'),
	},
	{
		// path: url 주소
		// component: url에 표시하는 component
		path: '/menu',
		name: 'Menu',
		component: () => import('@/views/Menu'),
	},
]

const router = createRouter({
	history: createWebHistory(),
	routes,
});

router.beforeEach((to, from, next) => {
	if (VueCookie.isKey('token')) {
		VueCookie.get('token');
	} else if (to.name !== "Login") {
		router.push("/login");
	}

	next();
})

export default router;