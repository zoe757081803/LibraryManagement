<template>
  <div>
<!--    <div class="item">用户名：{{admin.username}}</div>-->
    欢迎来到文献阅读交流系统！
  </div>
</template>

<script>
import Cookies from "js-cookie";
import request from "@/utils/request";

export default {
  name: "HomeView",
  data(){
    return{
      admin: Cookies.get('admin') ? JSON.parse(Cookies.get('admin')) : {}
    }
  },
  // created() {
  //   request.get('/admin/' + this.admin.id).then(res => {
  //     this.admin = res.data
  //   })
  // }
}
</script>

<style scoped>

</style>