import Vuex from 'vuex';
import authenticated from "@/store/modules/authenticated";
import member from "@/store/modules/member";
import menu from "@/store/modules/menu";

export const store = new Vuex.Store({
    modules: {
        authenticated, member, menu
    }
});