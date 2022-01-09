import { createStore } from 'vuex';
import authenticated from "@/store/modules/authenticated";

export default createStore({
    modules: {
        authenticated
    }
});