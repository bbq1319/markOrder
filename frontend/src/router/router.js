import { createWebHistory, createRouter } from 'vue-router';

const routes = [
    {
        path: '/',
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
    console.log(to, from);

    next();
})

export default router;