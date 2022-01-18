<template>
    <div>
        <SideMenu></SideMenu>

        <div>Hello World</div>
        <div v-for="menu in menus" :key="menu">
            <p>이름 : {{ menu.name }}</p>
            <p>가격 : {{ menu.price }}</p>
        </div>

        <p>{{ token }}</p>
        <img alt="Vue logo" src="../assets/logo.png">
    </div>
</template>

<script>
import SideMenu from '@/components/common/SideMenu';
import {mapGetters, mapActions} from 'vuex'

export default {
    computed: {
        ...mapGetters({
            menus: 'menu/GET_MENUS',
            token: 'member/GET_TOKEN'
        })
    },
    methods: {
        ...mapActions({
            GET_MENU_LIST: 'menu/GET_MENU_LIST'
        }),
        ...mapActions({
            GET_OPTION_LIST: 'menu/GET_OPTION_LIST'
        })
    },
    components: {
        'SideMenu': SideMenu,
    },
    created() {
        this.GET_MENU_LIST();
        this.GET_OPTION_LIST();
    },
}
</script>

<style>

</style>