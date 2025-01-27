import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import axios from 'axios';
import mavonEditor from 'mavon-editor';
import 'mavon-editor/dist/css/index.css';
import 'highlight.js/styles/googlecode.css';
import './util/rem.js';
import {Tool} from "@/util/tool";


axios.defaults.baseURL = process.env.VUE_APP_API_HOST;


/**
 * axios interceptor
 */
axios.interceptors.request.use(function (config) {
    const token = store.state.user.token;
    if (Tool.isNotEmpty(token)) {
        config.headers.token = token;
    }
    return config;
}, error => {
    return Promise.reject(error);
});
axios.interceptors.response.use(function (response) {
    return response;
}, error => {
    return Promise.reject(error);
});

createApp(App).use(store).use(router).use(Antd).use(mavonEditor).mount('#app');
