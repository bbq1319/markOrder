import { getMenuList, getOptionList } from "@/api/api";

const state = {
    menus: [],
	options: [],
}

const getters = {
    GET_MENUS(state) {
        return state.menus;
    },
	GET_OPTIONS(state) {
		return state.options;
	}
}

const mutations = {
    SET_MENUS(state, data) {
        state.menus = data;
    },
	SET_OPTIONS(state, data) {
        state.options = data;
    }
}

const actions = {
    GET_MENU_LIST(context) {
        getMenuList({

        }).then(res => {
            context.commit('SET_MENUS', res.data);
        }).catch(error => {
            console.log(error);
            console.log(error.response);
        });
    },
	// 추후 옵션으로 이동
	GET_OPTION_LIST(context) {
        getOptionList({

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