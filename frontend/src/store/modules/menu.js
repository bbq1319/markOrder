import { getMenuList } from "@/api/api";

const state = {
    menus: []
}

const getters = {
    GET_MENUS(state) {
        return state.menus;
    }
}

const mutations = {
    SET_MENUS(state, data) {
        state.menus = data;
    }
}

const actions = {
    GET_MENU_LIST(context) {
        getMenuList({

        }).then(res => {
            context.commit('SET_MENUS', res.data);
        }).catch(error => {
            console.log(error);
        });
    }
}

export default {
    namespaced: true,
    state, getters, mutations, actions
}