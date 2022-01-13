import Vuex from 'vuex';
// import createPersistedState from 'vuex-persistedstate';
import response from "@/store/modules/response";
import member from "@/store/modules/member";
import menu from "@/store/modules/menu";

export const store = new Vuex.Store({
    modules: {
        response, member, menu
    },
	plugins: [
		// createPersistedState()
	]
});