import { createStore } from 'vuex';
import authenticated from "@/store/modules/authenticated";
import member from "@/store/modules/member";

export default createStore({
    modules: {
        authenticated, member
    }
});