import { getMenuList } from "@/api/menu";

const state = {
    menus: [{
        id: '',
        name: '',
        engName: '',
        price: '',
        menuGroupId: '',
    }],
}

const getters = {
    GET_MENUS(state) {
        return state.menus;
    },
}

const mutations = {
    SET_MENUS(state, data) {
        state.menus = data;
    },
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
}

export default {
    namespaced: true,
    state, getters, mutations, actions
}