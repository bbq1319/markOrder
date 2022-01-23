import {store} from '@/store/store'
import router from "@/routes/router";

export function setInterceptors(instance) {
    instance.interceptors.request.use(
        function(config) {
            config.headers["X-AUTH-TOKEN"] = store.getters["member/GET_TOKEN"];
            console.log(config);
            return config;
        },
        function(error) {
            console.log(error);
            return Promise.reject(error);
        },
    );

    // Add a response interceptor
    instance.interceptors.response.use(
        function(response) {
            return response;
        },
        function(error) {
            const status = error.response.status;
            if (status === 403) {
                alert("연결이 끊겼습니다.");
                store.commit('member/DELETE_ALL_STATE');
                router.push({name: "Login"})
            }
            return Promise.reject(error);
        },
    );
    return instance;
}