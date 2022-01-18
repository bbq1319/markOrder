import axios from "axios";

const config = {
    // local
    baseUrl: 'http://localhost:9090'
}

function doLogin(data) {
    return axios.post(`${config.baseUrl}/api/v1/login`, data);
}

function getMenuList() {
    return axios.get(`${config.baseUrl}/menu`);
}

function getOptionList() {
	return axios.get(`${config.baseUrl}/api/v1/option`)
}

export {
    doLogin,
    getMenuList,
	getOptionList
}