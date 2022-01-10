const state = {
	token: '',
	memberId: '',
	name: '',
	roles: [],
}

const getter = {
	getToken(state) {
		return state.token;
	},
	getMemberId(state) {
		return state.memberId;
	},
	getName(state) {
		return state.name;
	},
	getRoles(state) {
		return state.roles;
	},
}

const mutations = {
	setToken(state, token) {
		state.token = token;
	},
	setMemberId(state, memberId) {
		state.memberId = memberId;
	},
	setName(state, name) {
		state.name = name;
	},
	setRoles(state, roles) {
		state.roles = roles;
	},

}

const actions = {}

export default {
	namespaced: true,
	state, getter, mutations, actions
}