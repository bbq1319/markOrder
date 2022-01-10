<template>
    <div>
        <SideMenu></SideMenu>

        <div>Hello World</div>
        <div v-for="menu in state.menus" :key="menu.id">
            <p>이름 : {{ menu.name }}</p>
            <p>가격 : {{ menu.price }}</p>
        </div>

        <p>{{ store.state.member.token }}</p>
        <img alt="Vue logo" src="../assets/logo.png">
    </div>
</template>

<script>
import { onMounted, computed, reactive } from "vue";
import { useStore } from 'vuex';
import SideMenu from "@/components/SideMenu";

export default {
    setup() {
        const store = useStore();
        const state = reactive({
            menus: [],
        });

        onMounted(() => {
            console.log(store);
            const token = computed(() => store.getters['member/getToken']);
            console.log(store.state.member.token);
            console.log(token)

            const baseUrl = location.protocol + '//' + location.hostname + ':9090';
            fetch(baseUrl + "/menu")
                .then(res => {
                    return res.json();
                })
                .then(result => {
                    state.menus = result;
                });
        });

        return {
            state, store
        }
    },
    components: {
        'SideMenu': SideMenu,
    }

    // name: 'App',
    // data() {
    //     return {
    //         menus: [],
    //     }
    // },
    // mounted() {
    //     console.log(this.$store);
    //     console.log(store.getters['getToken']);
    //     console.log(store.getters['member/getToken']);
    //
    //     const baseUrl = location.protocol + '//' + location.hostname + ':9090';
    //     fetch(baseUrl + "/menu")
    //         .then(res => {
    //             return res.json();
    //         })
    //         .then(result => {
    //             this.menus = result;
    //         });
    // }
}
</script>

<style>

</style>