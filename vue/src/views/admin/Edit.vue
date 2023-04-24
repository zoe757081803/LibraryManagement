<template>
  <div style="width: 80%">
    <div style="margin-bottom: 30px">编辑管理员</div>
    <el-form :inline="true" :model="form" label-width="100px">
      <el-form-item label="用户名">
        <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
      </el-form-item>
    </el-form>
    <div style="text-align: center; margin-top: 30px">
      <el-button type="primary" @click="update" size="medium">更新</el-button>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "EditAdmin",
  data(){
    return {
      form: {}
    }
  },
  created(){
    // 获得查询的参数id
    const id = this.$route.query.id
    // 把后台查出来的user对象传给form
    request.get("/admin/"+id).then(res => {
      this.form = res.data
    })
  },
  methods:{
    update(){
      request.put('/admin/update', this.form).then(res => {
        if(res.code ==='200'){
          this.$notify.success('更新成功')
          this.$router.push("/adminList")
        }else{
          this.$notify.error(res.msg)
        }
      })
    }
  }
}
</script>

<style scoped>

</style>