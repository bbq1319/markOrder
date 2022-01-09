const state = {
    count: 0,

}

const getter = {
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
    state, getter, mutations, actions
}