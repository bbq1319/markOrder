import {tokenInstance} from "@/api/api";

function getMenuList() {
    console.log("===getMenuList===");
    return tokenInstance.get(`/api/v1/menu`);
}

function getMenuInfo(data) {
    console.log("===getMenuList===");
    const id = data.id;
    return tokenInstance.get(`/api/v1/menu/${id}`);
}

export {
    getMenuList,
    getMenuInfo,
}