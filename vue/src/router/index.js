import Vue from 'vue'
import VueRouter from 'vue-router'
import User from "@/views/user/User";
import Layout from "@/views/Layout";
import Cookies from 'js-cookie'

Vue.use(VueRouter)

const routes = [
    //登录，主页放在主路由这样登录界面才能脱离三栏
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/login/Login.vue'),
  },
    //主页
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    // layout重定向
    redirect:'/home',
    children:[
        //子路由
      {
        path: 'home',
        name: 'Home',
        component: () => import('@/views/home/HomeView.vue'),
      },
      // User
      {
        path: 'userList',
        name: 'UserList',
        component: () => import('@/views/user/User.vue'),
      },
      {
        path: 'addUser',
        name: 'AddUser',
        component: () => import('@/views/user/AddUser.vue'),
      },
      {
        path: 'editUser',
        name: 'EditUser',
        component: () => import('@/views/user/EditUser.vue'),
      },
      // Admin
      {
        path: 'adminList',
        name: 'AdminList',
        component: () => import('@/views/admin/List.vue'),
      },
      {
        path: 'addAdmin',
        name: 'AddAdmin',
        component: () => import('@/views/admin/Add.vue'),
      },
      {
        path: 'editAdmin',
        name: 'EditAdmin',
        component: () => import('@/views/admin/Edit.vue'),
      },
      //  ====  Category  ====
      { path: 'categoryList', name: 'CategoryList', component: () => import('@/views/category/List.vue') },
      { path: 'addCategory', name: 'AddCategory', component: () => import('@/views/category/Add.vue') },
      { path: 'editCategory', name: 'EditCategory', component: () => import('@/views/category/Edit.vue') },
      //  ====  Article  ====
      { path: 'articleList', name: 'ArticleList', component: () => import('@/views/article/List.vue') },
      { path: 'addArticle', name: 'AddArticle', component: () => import('@/views/article/Add.vue') },
      { path: 'editArticle', name: 'EditArticle', component: () => import('@/views/article/Edit.vue') },
      { path: 'lookArticle', name: 'LookArticle', component: () => import('@/views/article/Look.vue') },
    ]
  },
  {
    path: "*",
    component:() => import('@/views/404.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})
router.beforeEach((to, from, next) => {
  if (to.path === '/login') next()
  const admin = Cookies.get("admin")
  if (!admin && to.path !== '/login') return next("/login")  // 强制退回到登录页面
  // 访问 /home 的时候，并且cookie里面存在数据，这个时候我就直接放行
  next()
})

export default router
