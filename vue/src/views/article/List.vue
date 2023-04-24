<template>
  <div>
    <!--    搜索表单-->
    <div style="margin-bottom: 20px">
      <el-input style="width: 240px" placeholder="请输入文章标题" v-model="params.name"></el-input>
      <el-button style="margin-left: 5px" type="primary" @click="load"><i class="el-icon-search"></i>搜索</el-button>
      <el-button style="margin-left: 5px" type="warning" @click="reset"><i class="el-icon-refresh"></i>重置</el-button>
    </div>

    <el-table :data="tableData" stripe>
      <el-table-column prop="id" label="编号" width="80px"></el-table-column>
      <el-table-column prop="name" label="标题"></el-table-column>
      <el-table-column prop="author" label="作者"></el-table-column>
      <el-table-column prop="publishdate" label="发表日期"></el-table-column>
      <el-table-column prop="source" label="出处"></el-table-column>
      <el-table-column prop="grade" label="等级"></el-table-column>
      <el-table-column prop="category" label="分类"></el-table-column>
<!--      <el-table-column prop="provider" label="提交者"></el-table-column>-->
<!--      <el-table-column prop="digest" label="摘要" width="200"></el-table-column>-->
<!--      <el-table-column prop="text" label="内容"></el-table-column>-->
      <el-table-column prop="text" label="原文">
        <template v-slot="scope">
          <el-button type="success" index="" @click="goPage(scope.row.text)">下载</el-button>
        </template>
      </el-table-column>

      <!--    操作-->
      <el-table-column prop="text" label="操作"  width="240px">
        <template v-slot="scope">
<!--          scope.row是当前行-->
          <el-button type="warning" @click="$router.push('/lookArticle?id=' + scope.row.id)">查看</el-button>
          <el-button type="primary" @click="$router.push('/editArticle?id=' + scope.row.id)">编辑</el-button>
          <el-popconfirm
              style="margin-left: 5px"
              title="您确定删除这行数据吗？"
              @confirm="del(scope.row.id)"
          >
            <el-button type="danger" slot="reference">删除</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <!--    分页-->
    <div style="margin-top: 20px">
      <el-pagination
          background
          :current-page="params.pageNum"
          :page-size="params.pageSize"
          layout="prev, pager, next"
          @current-change="handleCurrentChange"
          :total="total">
      </el-pagination>
    </div>
  </div>
</template>

<script>

import request from "@/utils/request";

export default {
  name: 'articleList',
  data(){
    return{
      tableData:[],
      total:0,
      params:{
        pageNum:1,
        pageSize:10,
        name:''
      }
    }
  },
  created() {
    this.load()//页面加载后调用load方法
  },
  methods:{
    goPage(url){
      window.location.href=url
    },
    load(){
      // 引入axios插件
      request.get('/article/page',{
        params:this.params
      }).then(res => {
        if(res.code === '200'){
          this.tableData = res.data.list
          this.total = res.data.total
        }
      })
    },
    reset(){
      this.params={
        pageNum:1,
        pageSize:10,
        name:''
      }
      this.load()
    },
    handleCurrentChange(pageNum){
      //点击分页按钮触发分页
      this.params.pageNum = pageNum
      this.load()
    },
    del(id) {
      request.delete("/article/delete/" + id).then(res => {
        if (res.code === '200') {
          this.$notify.success('删除成功')
          this.load()
        } else {
          this.$notify.error(res.msg)
        }
      })
    },
  }
}
</script>

<style scoped>

</style>