import {store} from '@/store/store'

export function setInterceptors(instance) {
    instance.interceptors.request.use(
        function(config) {
            config.headers["X-AUTH-TOKEN"] = store.getters["member/GET_TOKEN"];
            return config;
        },
        function(error) {
            return Promise.reject(error);
        },
    );

    // Add a response interceptor
    instance.interceptors.response.use(
        function(response) {
            return response;
        },
        function(error) {
            return Promise.reject(error);
        },
    );
    return instance;
}