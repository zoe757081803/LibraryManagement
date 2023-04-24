<template>
  <div style="width: 80%">
    <div style="margin-bottom: 30px">编辑管理员</div>
    <el-form :inline="true" :model="form" label-width="100px">
      <el-form-item label="名称" prop="name">
        <el-input v-model="form.name" placeholder="请输入名称"></el-input>
      </el-form-item>
      <el-form-item label="备注" prop="remark">
        <el-input v-model="form.remark" placeholder="请输入备注"></el-input>
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
  name: "EditCategory",
  data(){
    return {
      form: {}
    }
  },
  created(){
    // 获得查询的参数id
    const id = this.$route.query.id
    // 把后台查出来的user对象传给form
    request.get("/category/"+id).then(res => {
      this.form = res.data
    })
  },
  methods:{
    update(){
      request.put('/category/update', this.form).then(res => {
        if(res.code ==='200'){
          this.$notify.success('更新成功')
          this.$router.push("/categoryList")
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