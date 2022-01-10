<template>
    <div class="login">
        <form @submit.prevent="login">
            <img class="login-logo" src="../assets/innologo.png">
            <div>
                <input class="login-id" id="memberId" type="text" v-model="this.memberId" autocomplete="false"/>
                <i class="fas fa-user"></i>
            </div>
            <div>
                <input class="login-pw" id="password" type="password" v-model="this.password"/>
                <i class="fas fa-unlock-alt"></i>
            </div>
            <button class="login-btn" type="submit">Log in</button>
        </form>
    </div>
</template>

<script>
import {mapActions} from 'vuex'

export default {
    data() {
        return {
            memberId: '',
            password: '',
        }
    },
    methods: {
        ...mapActions({
            DO_LOGIN: 'member/DO_LOGIN'
        }),
        login() {
            this.DO_LOGIN({
                memberId: this.memberId,
                password: this.password,
            });
        }
    },

    // setup() {
    //     const store = useStore();
    //     const state = reactive({
    //         id: '',
    //         pw: '',
    //     });
    //
    //     const login = () => {
    //         console.log(state.id, state.pw);
    //         doLogin({
    //             id: state.id,
    //             password: state.pw
    //         }).then(function (res) {
    //             const data = res.data.data;
    //             store.commit('member/setToken', data.token);
    //             store.commit('member/setMemberId', data.memberId);
    //             store.commit('member/setName', data.name);
    //             store.commit('member/setRoles', data.roles);
    //
    //             router.push('/main');
    //         }).catch(function (error) {
    //             console.log(error);
    //         });
    //     };
    //
    //     return {
    //         state, login
    //     }
    // }
}
</script>

<style>
.login {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100vw;
    height: 100vh;
    margin-left: -240px;
    background-image: url("~@/assets/bg.jpeg");
}

.login::before {
    content: '';
    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    opacity: 0.4;
    background-color: black;
}

.login form {
    position: relative;
    text-align: center;
    margin-bottom: 30px;
}

.login form div {
    position: relative;
    padding: 10px;
}

.login form i {
    position: absolute;
    left: 30px;
    top: 27px;
    color: white;
    opacity: 0.6;
}

.login form input {
    width: 200px;
    height: 50px;
    border-radius: 25px;
    padding: 0 20px 0 45px;
    border: 0px;
    color: white;
    background-color: #5A515E;
}

.login form input:focus {
    outline: 2px solid #2A2A3A;
}

.login form input:-webkit-autofill,
.login form input:-webkit-autofill:hover,
.login form input:-webkit-autofill:focus,
.login form input:-webkit-autofill:active {
    transition: background-color 5000s ease-in-out 0s;
    -webkit-transition: background-color 9999s ease-out;
    -webkit-box-shadow: 0 0 0px 1000px #5A515E inset !important;
    -webkit-text-fill-color: white !important;
}

.login-btn {
    width: 265px;
    height: 50px;
    margin: 10px 0 0 0;
    border-radius: 25px;
    border: 0px;
    font-size: 14px;
    font-weight: bold;
    color: white;
    background-color: #FB3566;
}

.login-logo {
    width: 180px;
    margin-bottom: 30px;
}

</style>