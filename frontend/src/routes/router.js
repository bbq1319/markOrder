import {createWebHistory, createRouter} from 'vue-router';
import {useCookies} from "vue3-cookies";

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
	const { cookies } = useCookies();
	if (cookies.isKey('token'))
		console.log("token hi");
	else if (to.name !== "Login")
		next('/login');

	next();
})

export default router;