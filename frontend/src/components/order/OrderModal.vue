<template>
    <div class="modal-mask">
        <div class="modal-wrapper">
            <div class="modal-container">

                <div class="modal-header">
                    <slot name="header">
                        {{ beverage.name }}
                        {{ beverage.engName }}
                    </slot>
                </div>

                <div class="modal-body">
                    <slot name="body">
                        {{ beverage.price }}
                    </slot>
                </div>

                <div class="modal-footer">
                    <slot name="footer">
                        <button class="modal-default-button" v-bind:click="$emit('close')">
                            확인
                        </button>
                    </slot>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import {mapActions} from "vuex";

export default {
    props: ["beverage"],
    setup(props) {
        console.log("setup");
        const beverage = {...props}.beverage;
        return beverage;
    },
    methods: {
        ...mapActions({
            GET_MENU_INFO: 'menu/GET_MENU_INFO'
        })
    },
    created() {
        console.log("created");
        const beverage = this.beverage;
        console.log(beverage.id);
        this.GET_MENU_INFO(beverage.id);
    }
}
</script>

<style>
.modal-mask {
    position: fixed;
    z-index: 9998;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, .5);
    display: table;
    transition: opacity .3s ease;
}

.modal-wrapper {
    display: table-cell;
    vertical-align: middle;
}

.modal-container {
    width: 300px;
    margin: 0px auto;
    padding: 40px 30px;
    background-color: #fff;
    border-radius: 10px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, .33);
    transition: all .3s ease;
    text-align: center;
    font-family: Helvetica, Arial, sans-serif;
}

.modal-header {
    font-size: 24px;
    font-weight: bold;
}

.modal-body {
    margin: 30px 0 40px 0;
}

.modal-body .desc {
    font-size: 14px;
}

.modal-default-button {
    width: 100%;
    height: 50px;
    border: none;
    color: white;
    background-color: #4caf50;
}

.error {
    color: #f44336;
}

.success {
    color: #4caf50;
}

/*
 * The following styles are auto-applied to elements with
 * transition="modal" when their visibility is toggled
 * by Vue.js.
 *
 * You can easily play with the modal transition by editing
 * these styles.
 */

.modal-enter {
    opacity: 0;
}

.modal-leave-active {
    opacity: 0;
}

.modal-enter .modal-container,
.modal-leave-active .modal-container {
    -webkit-transform: scale(1.1);
    transform: scale(1.1);
}
</style>

