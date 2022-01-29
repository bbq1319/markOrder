<template>
    <div>
        <SideMenu></SideMenu>

        <div>Hello World</div>

        <p>{{ token }}</p>
    </div>
</template>

<script>
import SideMenu from '@/components/common/SideMenu';
import {mapGetters, mapActions} from 'vuex'

export default {
    computed: {
        ...mapGetters({
            menus: 'menu/GET_MENUS',
            token: 'member/GET_TOKEN',
        })
    },
    methods: {
        ...mapActions({
            GET_MENU_LIST: 'menu/GET_MENU_LIST'
        }),
    },
    components: {
        'SideMenu': SideMenu,
    },
    created() {
        this.GET_MENU_LIST();
    },
}
</script>

<style>

</style>