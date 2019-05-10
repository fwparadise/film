import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/views/Home.vue'
import Detail from '../views/Detail'
import Charts from '../views/Charts'
Vue.use(Router);

export default new Router({
  base:"/film/",
  mode:'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path:'/detail',
      name:'Detail',
      component:Detail
    },
    {
      path:'/statistics',
      name:'Statistics',
      component:Charts
    },
    {
      path:'*'
    }
  ]
})
