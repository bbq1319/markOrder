const state = {
	showModal: false,
	success: false,
	status: 0,
	msg: '',
	headerMsg: '',
}

const getters = {
	GET_SHOW_MODAL(state) {
		return state.showModal;
	},
	GET_SUCCESS(state) {
		return state.success;
	},
	GET_STATUS(state) {
		return state.status;
	},
	GET_MSG(state) {
		return state.msg;
	},
	GET_HEADER_MSG(state) {
		return state.headerMsg;
	},
}

const mutations = {
	CHANGE_MODAL(state) {
		state.showModal = !state.showModal;
	},
	SET_SUCCESS(state, success) {
		state.success = success;
	},
	SET_STATUS(state, status) {
		state.status = status;
	},
	SET_MSG(state, msg) {
		state.msg = msg;
	},
	SET_HEADER_MSG(state, headerMsg) {
		state.headerMsg = headerMsg;
	},
}

const actions = {
	ERROR_LOGIN(context, data) {
		context.commit('CHANGE_MODAL');
		context.commit('SET_SUCCESS', data.data.success);
		context.commit('SET_STATUS', data.status);
		context.commit('SET_MSG', data.data.error);
		context.commit('SET_HEADER_MSG', '에러가 발생했습니다.');
	}
}

export default {
	namespaced: true,
	state, getters, mutations, actions
}