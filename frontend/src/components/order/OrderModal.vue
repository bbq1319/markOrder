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
                        <form @submit.prevent="orderMenu">
                            <p>{{price}}</p>
                            <div class="option-container" v-for="og in menuInfo.menuOptionGroups" :key="og.id">
                                <p>{{og.optionGroup.groupName}}</p>
                                <ul>
                                    <li v-for="options in og.optionGroup.options" :key="options.id">
                                        <input type="radio" :id="options.id" :name="og.optionGroup.id" :value="options.id" :price="options.price" v-model="og.optionGroup.id" @click="changeOption" />
                                        <label :for="options.id"><span>{{options.name}}</span></label>
                                    </li>
                                </ul>
                            </div>

                            <div class="btn-group">
                                <button class="modal-default-button" type="submit">
                                    확인
                                </button>
                                <button class="modal-error-button" @click="$emit('closeModal')">
                                    취소
                                </button>
                            </div>
                        </form>
                    </slot>
                </div>

                <div class="modal-footer">
                    <slot name="footer">
                    </slot>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    props: ["menuInfo"],
    data() {
        return {
            price: this.menuInfo.price,
            menuOptionGroups: this.menuInfo.menuOptionGroups,
            optionPrice: []
        }
    },
    methods: {
        changeOption: function () {
            // console.log("==changeOption==");
            // const optPrice = event.target.getAttribute('price')
            // console.log(optPrice);
            // console.log(event);
            // this.price = Number(this.price) + Number(optPrice);
        },
        orderMenu() {
            console.log(this.menuOptionGroups);
            console.log(this.menuInfo);
            console.log(this.price);


        }
    },
    created() {
        this.menuOptionGroups.filter(
            mog => {
                const key = mog.optionGroup.id;

                console.log(key);

                let object = {};
                object[key] = mog.optionGroup;
                Object.assign(this.$data, object);
                this.$watch(key, function (val) {
                    console.log(val);
                }, {deep: true});
            }
        )
    },
    // watch: {
    //     $data: {
    //         handler: function (val, oldVal) {
    //             console.log(val, oldVal);
    //         },
    //         deep: true,
    //     }
    // }
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
    float: left;
    cursor: pointer;
}

.option-container ul li input[type="radio"] + label {
    float: left;
    margin-left: 15px;
    cursor: pointer;
}



.btn-group {
    display: flex;
    justify-content: center;
}

.btn-group button {
    width: 100%;
    height: 50px;
    margin: 0 10px;
    border: none;
    border-radius: 5px;
    color: white;
    font-weight: bold;
    cursor: pointer;
}

.modal-default-button {
    background-color: #4caf50;
}

.modal-error-button {
    background-color: #f44336;
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

