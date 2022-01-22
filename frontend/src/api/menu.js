import {tokenInstance} from "@/api/api";

function getMenuList() {
    console.log("===getMenuList===")
    return tokenInstance.get(`/api/v1/menu`);
}

export {
    getMenuList,
}