import {doLogin} from "@/api/api";
import router from "@/routes/router";

const state = {
	token: '',
	memberId: '',
	name: '',
	roles: [],
}

const getters = {
	GET_TOKEN(state) {
		return state.token;
	},
	GET_MEMBER_ID(state) {
		return state.memberId;
	},
	GET_NAME(state) {
		return state.name;
	},
	GET_ROLES(state) {
		return state.roles;
	},
}

const mutations = {
	SET_TOKEN(state, token) {
		state.token = token;
	},
	SET_MEMBER_ID(state, memberId) {
		state.memberId = memberId;
	},
	SET_NAME(state, name) {
		state.name = name;
	},
	SET_ROLES(state, roles) {
		state.roles = roles;
	},
}

const actions = {
	DO_LOGIN(context, data) {
		doLogin(
			data
		).then(function (res) {
			const data = res.data.data;
			context.commit('SET_TOKEN', data.token);
			context.commit('SET_MEMBER_ID', data.memberId);
			context.commit('SET_NAME', data.name);
			context.commit('SET_ROLES', data.roles);

			router.push('/main');
		}).catch(error => {
			console.log(error);
			context.dispatch('response/ERROR_LOGIN', error.response, {root: true});
		});
	}
}

export default {
	namespaced: true,
	state, getters, mutations, actions
}