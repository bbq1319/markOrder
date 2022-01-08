<template>
    <div>
        <div>Hello World</div>
        <div v-for="menu in menus" :key="menu.id">
            <p>이름 : {{ menu.name }}</p>
            <p>가격 : {{ menu.price }}</p>
        </div>
        <img alt="Vue logo" src="../assets/logo.png">
    </div>
</template>

<script>
export default {
    name: 'App',
    data() {
        return {
            menus: [],
        }
    },
    mounted() {
        const baseUrl = location.protocol + '//' + location.hostname + ':9090';
        fetch(baseUrl + "/menu")
            .then(res => {
                return res.json();
            })
            .then(result => {
                this.menus = result;
            });
    }
}
</script>

<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}
</style>