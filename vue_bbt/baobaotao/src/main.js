// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import axios from 'axios'
import vueAxios from 'vue-axios'
Vue.use(vueAxios, axios)

import {BootstrapVue, IconsPlugin} from 'bootstrap-vue'
import {NavbarPlugin} from 'bootstrap-vue'
import {DropdownPlugin} from 'bootstrap-vue'
import {CollapsePlugin} from 'bootstrap-vue'
Vue.use(NavbarPlugin)
Vue.use(DropdownPlugin)
Vue.use(CollapsePlugin)
import { ToastPlugin } from 'bootstrap-vue'
Vue.use(ToastPlugin)


// axios.defaults.baseURL='http://localhost:8088'

import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
Vue.config.productionTip = false
Vue.use(BootstrapVue)
Vue.use(IconsPlugin)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
