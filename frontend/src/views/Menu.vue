<template>
    <div>
        <SideMenu></SideMenu>

        <div class="content">
            <div style="display: flex">
                <div class="menu-body">
                    <div>
                        <p>ESPRESSO BEVERAGE</p>
                        <p>Regular</p>
                        <p>Large</p>
                    </div>
                    <template v-for="beverage in menus" :key="beverage.id">
                        <div v-if="beverage.menuGroupId === 1" @click="openModal(beverage.id)">
                            <div class="menu-name">
                                <p>{{ beverage.name }}</p>
                                <span>{{ beverage.engName }}</span>
                            </div>
                            <p>{{ beverage.price }}</p>
                        </div>
                    </template>
                </div>

                <div>
                    <div class="menu-body">
                        <div>
                            <p>ESPRESSO BEVERAGE</p>
                            <p>Regular</p>
                            <p>Large</p>
                        </div>
                        <div v-for="beverage in menus" :key="beverage">
                            <template v-if="beverage.menuGroupId === 2">
                                <div class="menu-name">
                                    <p>{{ beverage.name }}</p>
                                    <span>{{ beverage.engName }}</span>
                                </div>
                                <p>{{ beverage.price }}</p>
                            </template>
                        </div>
                    </div>

                    <div class="menu-body">
                        <div>
                            <p>ESPRESSO BEVERAGE</p>
                            <p>Regular</p>
                            <p>Large</p>
                        </div>
                        <div v-for="beverage in menus" :key="beverage">
                            <template v-if="beverage.menuGroupId === 3">
                                <div class="menu-name">
                                    <p>{{ beverage.name }}</p>
                                    <span>{{ beverage.engName }}</span>
                                </div>
                                <p>{{ beverage.price }}</p>
                            </template>
                        </div>
                    </div>
                </div>

                <div class="menu-body">
                    <div>
                        <p>ESPRESSO BEVERAGE</p>
                        <p>Regular</p>
                        <p>Large</p>
                    </div>
                    <template v-for="beverage in menus" :key="beverage.id">
                        <div v-if="beverage.menuGroupId === 4" @click="openModal">
                            <div class="menu-name">
                                <p>{{ beverage.name }}</p>
                                <span>{{ beverage.engName }}</span>
                            </div>
                            <p>{{ beverage.price }}</p>
                        </div>
                    </template>
                </div>
            </div>
        </div>

        <OrderModal v-if="showModal" :beverage="beverageId" @closeModal="closeModal">
        </OrderModal>
    </div>
</template>

<script>
import SideMenu from '@/components/common/SideMenu';
import OrderModal from '@/components/order/OrderModal';
import {mapGetters, mapActions} from "vuex";

export default {
    data() {
        return {
            showModal: false,
            headerMsg: '헤더입니다.',
            msg: '내용입니다.',
            beverageId: ''
        }
    },
    computed: {
        ...mapGetters({
            menus: 'menu/GET_MENUS',
        }),
    },
    methods: {
        ...mapActions({
            GET_MENU_LIST: 'menu/GET_MENU_LIST'
        }),
        openModal(id) {
            this.beverageId = id;
            this.showModal = !this.showModal;
        },
        closeModal() {
            this.showModal = !this.showModal;
        }
    },
    components: {
        'SideMenu': SideMenu,
        'OrderModal': OrderModal,
    },
    created() {
        this.GET_MENU_LIST();
        console.log(this);
    }
}
</script>

<style>
.menu-body div {
    display: flex;
}

.menu-body div p:first-child {
    width: 200px;
}

.menu-body div p:nth-child(n+2) {
    width: 100px;
    text-align: center;
}

.menu-name {
    width: 200px;
    flex-direction: column;
    justify-content: center;
}

.menu-name p {
    margin: 0;
}

.menu-name span {
    font-size: 12px;
}
</style>