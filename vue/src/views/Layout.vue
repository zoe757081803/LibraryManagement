<template>
  <div>
    <!--    头部-->
    <div style="height: 60px; line-height: 60px; background-color: white; margin-bottom: 2px; display: flex">
      <div style="width: 300px">
        <img src="@/assets/logo.png" alt="" style="width: 40px; position: relative; top: 10px; left: 20px">
        <span style="margin-left: 25px; font-size: 24px">文献阅读交流系统</span>
      </div>
      <div style="flex: 1; text-align: right; padding-right: 20px">
        <el-dropdown size="medium">
          <span class="el-dropdown-link" style="cursor: pointer">
            {{ admin.username }}<i class="el-icon-arrow-down el-icon--right"></i>
          </span>
          <el-dropdown-menu slot="dropdown" style="margin-top: -5px">
            <el-dropdown-item><div style="width: 50px; text-align: center;" @click="logout">退出</div></el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </div>
    </div>
    <!--    侧边栏和主题-->
    <div style="display: flex">
      <!--      侧边栏：减号左右有空格-->
      <div style="width: 200px;min-height:calc(100vh - 62px);overflow: hidden;margin-right:2px;background-color: white">
        <el-menu :default-active="$route.path" router class="el-menu-demo">
          <el-menu-item index="/">
            <i class="el-icon-eleme"></i>
            <span>首页</span>
          </el-menu-item>
          <el-submenu index="user">
            <template slot="title">用户管理</template>
            <el-menu-item index="/addUser">用户添加</el-menu-item>
            <el-menu-item index="/userList">用户列表</el-menu-item>
          </el-submenu>
<!--          <el-submenu index="admin">-->
<!--            <template slot="title">管理员管理</template>-->
<!--            <el-menu-item index="/addAdmin">管理员添加</el-menu-item>-->
<!--            <el-menu-item index="/adminList">管理员列表</el-menu-item>-->
<!--          </el-submenu>-->
          <el-submenu index="category">
            <template slot="title">文献分类管理</template>
            <el-menu-item index="/addCategory">文献分类添加</el-menu-item>
            <el-menu-item index="/categoryList">文献分类列表</el-menu-item>
          </el-submenu>
          <el-submenu index="article">
            <template slot="title">文献管理</template>
            <el-menu-item index="/addArticle">文献添加</el-menu-item>
            <el-menu-item index="/articleList">文献列表</el-menu-item>
          </el-submenu>
        </el-menu>

      </div>
      <!--      主体-->
      <div style="flex:1;background-color: white;padding:10px">
        <!--        主题 展示子路由-->
        <router-view/>
      </div>
    </div>
  </div>
</template>

<script>
import Cookies from 'js-cookie'

export default {
  name: "Layout.vue",
  data() {
    return {
      admin: Cookies.get('admin') ? JSON.parse(Cookies.get('admin')) : {}
    }
  },
  methods: {
    logout() {
      // 清除浏览器用户数据
      Cookies.remove('admin')
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>

</style>