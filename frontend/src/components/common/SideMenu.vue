<template>
    <div class="side-menu">
        <div class="side-menu-profile">
            <img class="member-img" src="src/assets/logo.png">
            <div>
                <p style="font-size: 16px">김민섭 님</p>
                <p style="font-size: 12px">환영합니다!</p>
            </div>
        </div>

        <div class="side-menu-list">
            <router-link to="/main" :class="{ 'active': curMenu === 'Main' }">
                <span>메인</span>
            </router-link>
            <router-link to="/menu" :class="{ 'active': curMenu === 'Menu' }">
                <span>커피주문</span>
            </router-link>
            <router-link to="/menu" :class="{ 'active': curMenu === 'AddMenu' }">
                <span>커피추가</span>
            </router-link>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            curMenu: this.$route.name
        }
    },
    mounted() {
        console.log(this.$route.name);
    }
}
</script>

<style>
.side-menu {
    width: 220px;
    height: 100%;
    position: fixed;
    top: 0;
    left: 0;
    overflow-x: hidden;
    padding-top: 0;
    color: white;
    background-color: #323635;
}

.side-menu a:link,
.side-menu a:visited,
.side-menu a:hover,
.side-menu a:active {
    color: white;
    text-decoration: none;
}

.side-menu-profile {
    display: flex;
    margin-top: 30px;
    padding-left: 20px;
}

.side-menu-profile div {
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding-left: 15px;
}

.side-menu-profile p {
    margin: 0;
}

.member-img {
    width: 70px;
    height: 70px;
    border-radius: 70%;
    overflow: hidden;
    background-color: white;
}

.side-menu-list {
    margin-top: 50px;
}

.side-menu-list a {
    display: block;
    margin: 0;
    padding: 10px 0 10px 40px;
    border-radius: 3px;
    font-size: 16px;
    text-transform: capitalize;
    color: white;
}

.side-menu-list .active {
    font-weight: bold;
    color: #4caf50 !important;
}
</style>