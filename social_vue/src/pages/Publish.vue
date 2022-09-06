<template>
  <div>
    <el-dialog
        title="帖子发布"
        :visible.sync="dialogVisible"
        width="30%"
        :before-close="handleClose">
      <el-form :inline="true" :model="formInline" class="demo-form-inline">
        <el-form-item label="话题分类">
          <el-select v-model="formInline.type" placeholder="话题分类">
            <el-option label="生活篇" value="生活篇"></el-option>
            <el-option label="学校生活篇" value="学校生活篇"></el-option>
            <el-option label="娱乐新闻篇" value="娱乐新闻篇"></el-option>
            <el-option label="兴趣爱好篇" value="兴趣爱好篇"></el-option>
            <el-option label="交友篇" value="交友篇"></el-option>
          </el-select>
        </el-form-item>
        <el-input
            type="textarea"
            :rows="2"
            placeholder="请输入话题内容"
            v-model="formInline.content">
        </el-input>
        <br><br><br>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">发布</el-button>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
  </span>
    </el-dialog>
  </div>
</template>

<script>
  import Moment from "moment"
  import Qs from "qs"
  export default {
    name: "Publish",
    data() {
      return {
        dialogVisible: true,
        formInline: {
          content: '',
          type: ''
        }
      }
    },
    methods: {
      onSubmit() {
        let topic = {
          topicName:this.$route.query.name,
          topicUserName:this.$route.query.userName,
          topicType:this.formInline.type,
          topicTime:Moment().format("YYYY-MM-DD HH:mm:ss"),
          topicContent:this.formInline.content
        }
        this.$axios.post('http://localhost:8080/topic/createTopic',Qs.stringify(topic)).then(
            response => {
              if (response.data === 1){
                this.succeed()
                setTimeout(() => {
                  this.dialogVisible = false
                },2000)
              }else {
                this.failed()
              }
            },
            error => {
              this.error(error)
            }
        )
      },
      succeed() {
        this.$notify({
          title: '成功',
          message: '发布成功',
          type: 'success'
        });
      },
      failed() {
        this.$notify.error({
          title: '失败',
          message: '发布失败，请检查输入',
        });
      },
      error(message) {
        this.$notify.error({
          title: '错误',
          message: '服务器端错误,错误原因：' + message,
        });
      },
      handleClose(done) {
        done();
      }
    },
    watch:{
      dialogVisible:{
        immediate:true,
        handler(newValue,_){
          if (newValue === false){
            this.$bus.$emit('router',this.$route.query.router)
          }
        }
      }
    }
  }
</script>

<style scoped>

</style>