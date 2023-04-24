<template>
  <div style="width: 80%">
    <div style="margin-bottom: 30px">新增管理员</div>
    <el-form :inline="true" :model="form" label-width="100px">
      <el-form-item label="用户名">
        <el-input v-model="form.username" placeholder="请输入用户名"></el-input>
      </el-form-item>
    </el-form>
    <div style="text-align: center; margin-top: 30px">
      <el-button type="primary" @click="save" size="medium">提交</el-button>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "AddAdmin",
  data(){
    return {
      form: {}
    }
  },
  methods:{
    save(){
      request.post('/admin/save', this.form).then(res => {
        if(res.code ==='200'){
          this.$notify.success('新增成功')
          this.form = {}
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