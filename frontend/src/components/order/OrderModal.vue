<template>
    <div class="modal-mask">
        <div class="modal-wrapper">
            <div class="modal-container">

                <div class="modal-header">
                    <slot name="header">
                        <p>{{menuInfo.name}}</p>
                        <span>{{menuInfo.engName}}</span>
                    </slot>
                </div>

                <div class="modal-body">
                    <slot name="body">
                        <p>{{menuInfo.price}}</p>

                        <div class="option-container" v-for="og in menuInfo.menuOptionGroups" :key="og.id">
                            <p>{{og.optionGroup.groupName}}</p>
                            <ul v-for="options in og.optionGroup.options" :key="options.id">
                                <li>
                                    <input type="radio" id="{{options.id}}" name="temp" value="1" />
                                    <label for="{{options.id}}"><span>{{options.name}}</span></label>
                                </li>
                            </ul>
                        </div>

                        <p>{{menuInfo.menuOptionGroups}}</p>
                    </slot>
                </div>

                <div class="modal-footer">
                    <slot name="footer">
                        <button class="modal-default-button" @click="$emit('closeModal')">
                            확인
                        </button>
                    </slot>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: ["menuInfo"],
    // computed: {
    //     ...mapGetters({
    //         menuInfo: 'menu/GET_INFO',
    //     })
    // },
    // methods: {
    //     ...mapActions({
    //         GET_MENU_INFO: 'menu/GET_MENU_INFO'
    //     })
    // },
    created() {
        // this.menuInfo = [];
        // const beverageId = this.beverage;
        // await this.GET_MENU_INFO(beverageId);
    },
    mounted() {
    }
}
</script>

<style scoped>
ul {
    list-style: none;
    padding-left: 0px;
}

.option-container {
    position: relative;
    padding: 5px 0;
}

.option-container + .option-container {
    border-top: 1px black solid;
}

.option-container p {
    margin: 10px 0 15px 30px;
    text-align: left;
    font-weight: bold;
}

.option-container ul {
    margin-top: 10px;
}

.option-container ul li {
    margin-bottom: 10px;
}

.option-container ul li:after {
    display: block;
    clear: both;
    content: "";
}

.option-container ul li input[type="radio"] {
    display: none;
}

.option-container ul li input[type="radio"] + label {
    width: 17px;
    height: 17px;
    /*float: right;*/
    margin-right: 30px;
    border-radius: 3px;
    cursor: pointer;
    background: #4caf50;
}

.option-container ul li input[type="radio"]:checked  + label {
    background: url("~@/assets/check_radio_sheet.png") #4caf50 -19px top no-repeat;
    /*float: right;*/
}

.option-container ul li input[type="radio"] + label span {
    position: absolute;
    left: 30px;
    display: block;
}



.modal-mask {
    overflow: scroll;
    position: fixed;
    z-index: 9998;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, .5);
    transition: opacity .3s ease;
}

.modal-wrapper {
    margin: 40px 0;
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

