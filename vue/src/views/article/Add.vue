<template>
  <div style="width: 80%">
    <div style="margin-bottom: 30px">新增文章</div>
    <el-form :model="form" label-width="100px">
      <el-form-item label="标题" prop="name">
        <el-input v-model="form.name" placeholder="请输入标题" maxlength="50"
                  show-word-limit></el-input>
      </el-form-item>
    </el-form>
    <el-form :inline="true" :model="form" label-width="100px">
      <el-form-item label="作者" prop="author">
        <el-input v-model="form.author" placeholder="请输入作者"></el-input>
      </el-form-item>
      <el-form-item label="出处" prop="source">
        <el-input v-model="form.source" placeholder="请输入出处"></el-input>
      </el-form-item>
      <el-form-item label="发表日期" prop="publishdate">
        <el-date-picker
            style="width: 86%"
            v-model="form.publishdate"
            type="date"
            value-format="yyyy-MM-dd"
            format="yyyy-MM-dd"
            placeholder="选择日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="等级" prop="grade">
        <el-input v-model="form.grade" placeholder="请输入等级"></el-input>
      </el-form-item>
      <el-form-item label="分类" prop="category">
        <el-cascader
            v-model="form.categories"
            :options="categories"
            :props="{ value: 'name', label: 'name'}"
            style="width: 92%"></el-cascader>
      </el-form-item>
      <el-form-item label="提交者" prop="provider">
        <el-input v-model="form.provider" placeholder="请输入提交者"></el-input>
      </el-form-item>
    </el-form>
    <el-form :model="form" label-width="100px">
      <el-form-item label="摘要" prop="digest">
        <el-input
            type="textarea"
            :autosize="{ minRows: 5, maxRows: 10}"
            placeholder="请输入摘要"
            v-model="form.digest"
            maxlength="200"
            show-word-limit>
        </el-input>
      </el-form-item>
      <el-form-item label="内容" prop="text">
        <el-upload
            class="upload-demo"
            action="http://localhost:9090/article/file/upload"
            :on-success="handleTextSuccess"
        >
          <el-button size="small" type="primary">点击上传</el-button>
          <div slot="tip" class="el-upload__tip">只能上传docx文件，且不超过10MB</div>
        </el-upload>
      </el-form-item>
    </el-form>
    <div style="text-align: center; margin-top: 30px">
      <el-button type="primary" @click="save" size="medium">提交</el-button>
    </div>
  </div>
</template>

<script>
import request from "@/utils/request";
import Cookies from "js-cookie";

export default {
  name: "AddArticle",
  data(){
    return {
      form: {},
      categories: [],
    }
  },
  created(){
    request.get("/category/list").then(res => {
      this.categories = res.data
    })
  },
  methods:{
    handleTextSuccess(res) {
      if (res.code === '200') {
        console.log(res.data)
        this.form.text = res.data
      }
    },
    save(){
      request.post('/article/save', this.form).then(res => {
        if(res.code ==='200'){
          this.$notify.success('新增成功')
          this.form = {}
          this.$router.push("/articleList")
          console.log(res.data)
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