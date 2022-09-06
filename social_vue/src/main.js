import Vue from 'vue'

//引入ElmentUI
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

//引入blumaUI
import "bulma/css/bulma.css"
import "@fortawesome/fontawesome-free/css/all.css"

//引入VueRouter
import VueRouter from 'vue-router'
//引入路由器
import router from './router'
//引入axios
import axios from "axios"

import App from './App.vue'

Vue.config.productionTip = false
//应用路由插件
Vue.use(ElementUI)
Vue.use(VueRouter)

Vue.prototype.$axios = axios

new Vue({
  render: h => h(App),
  router:router,
  beforeCreate(){
    Vue.prototype.$bus=this//安装全局事件总线
  }

}).$mount('#app')
