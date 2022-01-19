import axios from "axios";
import {setInterceptors} from "@/api/common/interceptors";

function createInstance() {
    const instance = axios.create();
    return instance;
}

export const instance = createInstance();

function createTokenInstance() {
    const instance = axios.create();
    return setInterceptors(instance);
}

export const tokenInstance = createTokenInstance();

function doLogin(data) {
    return instance.post(`/api/v1/login`, data);
    // return axios.post(`${config.baseUrl}/api/v1/login`, data);
}

function getOptionList() {
    return instance.get(`/api/v1/option`);
}

export {
    doLogin,
    getOptionList
}