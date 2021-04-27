import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import Manager from '@/components/Manager'
import Type from '@/components/Type'
import Goods from '@/components/Goods'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/manager',
      name: 'Manager',
      component: Manager,
      children:[
        {
          path: '/manager/type',
          name: 'Type',
          component: Type
        },
        {
          path: '/manager/goods',
          name: 'Goods',
          component: Goods
        }

      ]
    }
  ]
})
