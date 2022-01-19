import axios from "axios";
import {store} from "@/store/store"

function setInterceptors(instance) {
    instance.interceptors.request.use (
        function (config) {
            config.headers["X-AUTH-TOKEN"] = store.getters["member/GET_TOKEN"]
            return config;
        },
        function (error) {
            return Promise.reject(error);
        }
    );

    instance.interceptors.response.use (
        function (response) {
            return response;
        },
        function (error) {
            return Promise.reject(error);
        }
    );

    return instance;
}

function createInstance() {
    const instance = axios.create({
        baseUrl: 'http://localhost:9090',
    });

    return setInterceptors(instance);
}

const ins = createInstance();
const config = {
    // local
    baseUrl: 'http://localhost:9090',
}

function doLogin(data) {
    return ins.post(`${config.baseUrl}/api/v1/login`, data);
    // return axios.post(`${config.baseUrl}/api/v1/login`, data);
}

function getMenuList() {
    return axios.get(`${config.baseUrl}/menu`);
}

function getOptionList() {
	return ins.get(`${config.baseUrl}/api/v1/option`);
}

export {
    doLogin,
    getMenuList,
	getOptionList
}