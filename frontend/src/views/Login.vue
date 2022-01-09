<template>
    <div>
        <form @submit.prevent="login">
            <div>
                <label for="id">id: </label>
                <input id="id" type="text" v-model="id" />
            </div>
            <div>
                <label for="pw">pw: </label>
                <input id="pw" type="password" v-model="pw" />
            </div>

            <button type="submit">로그인</button>
        </form>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            id: '',
            pw: ''
        }
    },
    methods: {
        login: function () {
            console.log(this.id);
            console.log(this.pw);

            axios.post('http://localhost:9090/api/v1/login', {
                id: this.id,
                password: this.pw
            }).then(function (res) {
                console.log(res);
            }).catch(function (error) {
                console.log(error);

                console.log(error.response);
                console.log(error.message);
                console.log(error.request);
            });
        }
    }
}
</script>

<style>

</style>