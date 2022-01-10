<template>
    <div>
        <form @submit.prevent="login">
            <div>
                <label for="id">id: </label>
                <input id="id" type="text" v-model="state.id" />
            </div>
            <div>
                <label for="pw">pw: </label>
                <input id="pw" type="password" v-model="state.pw" />
            </div>

            <button type="submit">로그인</button>
        </form>
    </div>
</template>

<script>
import axios from 'axios';
import router from '@/router/router';
import { reactive } from 'vue';
import { useStore } from 'vuex';

export default {
    setup() {
        const store = useStore();
        const state = reactive({
            id: '',
            pw: '',
        });

        const login = () => {
            console.log(state.id, state.pw);
            axios.post('http://localhost:9090/api/v1/login', {
                id: state.id,
                password: state.pw
            }).then(function (res) {
                const data = res.data.data;
                store.commit('member/setToken', data.token);
                store.commit('member/setMemberId', data.memberId);
                store.commit('member/setName', data.name);
                store.commit('member/setRoles', data.roles);

                router.push('/main');
            }).catch(function (error) {
                console.log(error);
            });
        };

        return {
            state, login
        }
    }
}
</script>

<style>

</style>