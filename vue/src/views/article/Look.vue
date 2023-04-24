<template>
  <div style="width: 80%">
    <div style="margin-bottom: 30px">查看文章</div>
    <el-form :model="form" label-width="100px">
      <el-form-item label="标题" prop="name">
        {{ form.name }}
      </el-form-item>
    </el-form>
    <el-form :inline="true" :model="form" label-width="100px">
      <el-form-item label="作者" prop="author" style="width: 300px">
        {{ form.author }}
      </el-form-item>
      <el-form-item label="出处" prop="source">
        {{ form.source }}
      </el-form-item>
      <br>
      <el-form-item label="发表日期" prop="publishdate" style="width: 300px">
        {{ form.publishdate }}
      </el-form-item>
      <el-form-item label="等级" prop="grade">
        {{ form.grade }}
      </el-form-item>
      <br>
      <el-form-item label="分类" prop="category" style="width: 300px">
        {{ form.category }}
      </el-form-item>
      <el-form-item label="提交者" prop="provider">
        {{ form.provider }}
      </el-form-item>
    </el-form>
    <el-form :model="form" label-width="100px">
      <el-form-item label="摘要" prop="digest">
        {{ form.digest }}
      </el-form-item>
      <el-form-item label="内容" prop="text">
          <el-button size="small" type="primary" @click="goPage(form.text)">点击下载</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "LookArticle",
  data(){
    return {
      form: {},
      categories: [],
    }
  },
  created(){
    // 获得查询的参数id
    const id = this.$route.query.id
    // 把后台查出来的user对象传给form
    request.get("/article/"+id).then(res => {
      this.form = res.data
    })
  },
  methods:{
    goPage(url){
      window.location.href=url
    }
  }
}
</script>

<style scoped>

</style>