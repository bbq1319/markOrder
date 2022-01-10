const state = {
    count: 0,

}

const getters = {
    time2(state) {
        return state.counter * 2;
    },
    time3(state) {
        return state.counter * 3;
    }
}

const mutations = {
    setCounter(state, value) {
        state.counter = value;
    }
}

const actions = {

}

export default {
    state, getters, mutations, actions
}