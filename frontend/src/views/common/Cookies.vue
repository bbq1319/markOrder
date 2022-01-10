<template>
    <div>

    </div>
</template>

<script>
import { useCookies } from 'vue3-cookies';

export default {
    setup() {
        const { cookies } = useCookies();
        return { cookies };
    },
    mounted() {
        let cookieValue = this.cookies.get("name");
        console.log(cookieValue);
    }
}
</script>

<style>

</style>