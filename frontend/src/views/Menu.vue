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
                    <div v-for="beverage in menus" :key="beverage">
                        <template v-if="beverage.menuGroupId === 1">
                            <div class="menu-name">
                                <p>{{ beverage.name }}</p>
                                <span>{{ beverage.engName }}</span>
                            </div>
                            <p>{{ beverage.price }}</p>
                        </template>
                    </div>
                </div>


<!--                <div class="menu-body">-->
<!--                    <div>-->
<!--                        <p>ESPRESSO BEVERAGE</p>-->
<!--                        <p>Regular</p>-->
<!--                        <p>Large</p>-->
<!--                    </div>-->
<!--                    <div>-->
<!--                        <div class="menu-name">-->
<!--                            <p>에스프레소</p>-->
<!--                            <span>Espresso</span>-->
<!--                        </div>-->
<!--                        <p>4.0</p>-->
<!--                    </div>-->
<!--                    <div>-->
<!--                        <div class="menu-name">-->
<!--                            <p>에스프레소</p>-->
<!--                            <span>Espresso</span>-->
<!--                        </div>-->
<!--                        <p>4.0</p>-->
<!--                    </div>-->
<!--                    <div>-->
<!--                        <div class="menu-name">-->
<!--                            <p>에스프레소</p>-->
<!--                            <span>Espresso</span>-->
<!--                        </div>-->
<!--                        <p>4.0</p>-->
<!--                        <p>5.0</p>-->
<!--                    </div>-->
<!--                    <div>-->
<!--                        <div class="menu-name">-->
<!--                            <p>에스프레소</p>-->
<!--                            <span>Espresso</span>-->
<!--                        </div>-->
<!--                        <p>4.0</p>-->
<!--                        <p>5.0</p>-->
<!--                    </div>-->
<!--                    <div>-->
<!--                        <div class="menu-name">-->
<!--                            <p>에스프레소</p>-->
<!--                            <span>Espresso</span>-->
<!--                        </div>-->
<!--                        <p>4.0</p>-->
<!--                        <p>5.0</p>-->
<!--                    </div>-->
<!--                    <div>-->
<!--                        <div class="menu-name">-->
<!--                            <p>에스프레소</p>-->
<!--                            <span>Espresso</span>-->
<!--                        </div>-->
<!--                        <p>4.0</p>-->
<!--                    </div>-->
<!--                    <div>-->
<!--                        <div class="menu-name">-->
<!--                            <p>에스프레소</p>-->
<!--                            <span>Espresso</span>-->
<!--                        </div>-->
<!--                        <p>4.0</p>-->
<!--                        <p>5.0</p>-->
<!--                    </div>-->
<!--                    <div>-->
<!--                        <div class="menu-name">-->
<!--                            <p>에스프레소</p>-->
<!--                            <span>Espresso</span>-->
<!--                        </div>-->
<!--                        <p>4.0</p>-->
<!--                        <p>5.0</p>-->
<!--                    </div>-->
<!--                    <div>-->
<!--                        <div class="menu-name">-->
<!--                            <p>에스프레소</p>-->
<!--                            <span>Espresso</span>-->
<!--                        </div>-->
<!--                        <p>4.0</p>-->
<!--                    </div>-->
<!--                </div>-->


                <div>
                    <div class="menu-body">
                        <div>
                            <p>ESPRESSO BEVERAGE</p>
                            <p>Regular</p>
                            <p>Large</p>
                        </div>
                        <div>
                            <div class="menu-name">
                                <p>에스프레소</p>
                                <span>Espresso</span>
                            </div>
                            <p>4.0</p>
                            <p>5.0</p>
                        </div>
                        <div>
                            <div class="menu-name">
                                <p>에스프레소</p>
                                <span>Espresso</span>
                            </div>
                            <p>4.0</p>
                            <p>5.0</p>
                        </div>
                        <div>
                            <div class="menu-name">
                                <p>에스프레소</p>
                                <span>Espresso</span>
                            </div>
                            <p>4.0</p>
                            <p>5.0</p>
                        </div>
                        <div>
                            <div class="menu-name">
                                <p>에스프레소</p>
                                <span>Espresso</span>
                            </div>
                            <p>4.0</p>
                            <p>5.0</p>
                        </div>
                    </div>



                    <div class="menu-body">
                        <div>
                            <p>ESPRESSO BEVERAGE</p>
                            <p>Regular</p>
                            <p>Large</p>
                        </div>
                        <div>
                            <div class="menu-name">
                                <p>에스프레소</p>
                                <span>Espresso</span>
                            </div>
                            <p>4.0</p>
                        </div>
                        <div>
                            <div class="menu-name">
                                <p>에스프레소</p>
                                <span>Espresso</span>
                            </div>
                            <p>4.0</p>
                        </div>
                        <div>
                            <div class="menu-name">
                                <p>에스프레소</p>
                                <span>Espresso</span>
                            </div>
                            <p>4.0</p>
                        </div>
                        <div>
                            <div class="menu-name">
                                <p>에스프레소</p>
                                <span>Espresso</span>
                            </div>
                            <p>4.0</p>
                        </div>
                    </div>
                </div>


                <div class="menu-body">
                    <div>
                        <p>ESPRESSO BEVERAGE</p>
                        <p>Regular</p>
                        <p>Large</p>
                    </div>
                    <div>
                        <div class="menu-name">
                            <p>에스프레소</p>
                            <span>Espresso</span>
                        </div>
                        <p>4.0</p>
                    </div>
                    <div>
                        <div class="menu-name">
                            <p>에스프레소</p>
                            <span>Espresso</span>
                        </div>
                        <p>4.0</p>
                    </div>
                    <div>
                        <div class="menu-name">
                            <p>에스프레소</p>
                            <span>Espresso</span>
                        </div>
                        <p>4.0</p>
                        <p>5.0</p>
                    </div>
                    <div>
                        <div class="menu-name">
                            <p>에스프레소</p>
                            <span>Espresso</span>
                        </div>
                        <p>4.0</p>
                        <p>5.0</p>
                    </div>
                    <div>
                        <div class="menu-name">
                            <p>에스프레소</p>
                            <span>Espresso</span>
                        </div>
                        <p>4.0</p>
                        <p>5.0</p>
                    </div>
                    <div>
                        <div class="menu-name">
                            <p>에스프레소</p>
                            <span>Espresso</span>
                        </div>
                        <p>4.0</p>
                    </div>
                    <div>
                        <div class="menu-name">
                            <p>에스프레소</p>
                            <span>Espresso</span>
                        </div>
                        <p>4.0</p>
                        <p>5.0</p>
                    </div>
                    <div>
                        <div class="menu-name">
                            <p>에스프레소</p>
                            <span>Espresso</span>
                        </div>
                        <p>4.0</p>
                        <p>5.0</p>
                    </div>
                    <div>
                        <div class="menu-name">
                            <p>에스프레소</p>
                            <span>Espresso</span>
                        </div>
                        <p>4.0</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import SideMenu from '@/components/common/SideMenu';
import {mapGetters, mapActions} from "vuex";

export default {
    computed: {
        ...mapGetters({
            menus: 'menu/GET_MENUS',
        })
    },
    methods: {
        ...mapActions({
            GET_MENU_LIST: 'menu/GET_MENU_LIST'
        })
    },
    components: {
        'SideMenu': SideMenu,
    },
    created() {
        this.GET_MENU_LIST();
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