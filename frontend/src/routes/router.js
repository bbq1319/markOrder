import {createWebHistory, createRouter} from 'vue-router';
import {store} from "@/store/store";

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
	const token = store.getters["member/GET_TOKEN"];
	if (to.name !== "Login" && token == '')
		next('/login');
	else if (to.name == "Login" && token != '')
		next('/main')

	next();
})

export default router;