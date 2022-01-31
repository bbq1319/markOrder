import { getMenuList, getMenuInfo } from "@/api/menu";

const state = {
    menus: [{
        id: '',
        name: '',
        engName: '',
        price: '',
        menuGroupId: '',
    }],
    menuInfo: [],
}

const getters = {
    GET_MENUS(state) {
        return state.menus;
    },
    GET_INFO(state) {
        return state.menuInfo;
    }
}

const mutations = {
    SET_MENUS(state, data) {
        state.menus = data;
    },
    SET_MENU_INFO(state, data) {
        state.menuInfo = data;
    }
}

const actions = {
    GET_MENU_LIST(context) {
        getMenuList({

        }).then(res => {
            console.log(res);
            context.commit('SET_MENUS', res.data);
        }).catch(error => {
            console.log(error);
            console.log(error.response);
        });
    },
    GET_MENU_INFO(context, id) {
        getMenuInfo({
            id
        }).then(res => {
            console.log(res);
            context.commit("SET_MENU_INFO", res.data);
        }).catch(error => {
            console.log(error);
            console.log(error.response);
        })
    }
}

export default {
    namespaced: true,
    state, getters, mutations, actions
}