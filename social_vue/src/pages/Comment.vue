<template>
  <div>
    <br><br><br><br>
    <article class="media">
      <figure class="media-left">
        <p class="image is-64x64">
          <img src="../assets/logo.png">
        </p>
      </figure>
      <div class="media-content">
        <div class="content">
          <p>
            <strong>{{ topic.topicUserName }}({{ topic.topicName }})</strong> <small>{{ topic.topicTime }}</small>
            <br>
            {{ topic.topicContent }}
          </p>
        </div>
      </div>
      <el-button type="danger" @click="emitReturn">返回</el-button>
    </article>

    <!--进行评论-->
    <article class="media">
      <figure class="media-left">
        <p class="image is-64x64">
          <img src="../assets/logo.png">
        </p>
      </figure>
      <div class="media-content">
        <div class="field">
          <p class="control">
            <textarea class="textarea" placeholder="请输入评论内容" v-model="content"></textarea>
          </p>
        </div>
        <nav class="level">
          <div class="level-left">
            <div class="level-item">
              <a class="button is-info" @click="emitSubmit">发送</a>
            </div>
          </div>
        </nav>
      </div>
    </article>
    <el-divider></el-divider>

    <!--评论区-->
    <article class="media" v-for="comment in comments" :key="comment.commentId">
      <figure class="media-left">
        <p class="image is-64x64">
          <img src="../assets/logo.png">
        </p>
      </figure>
      <div class="media-content">
        <div class="content">
          <p>
            <strong>{{ comment.commentUserName }}({{ comment.commentName }})</strong> <small>{{ comment.commentTime }}</small>
            <br>
            {{ comment.commentContent }}
          </p>
          <el-button
              type="danger" plain
              v-if="isShowDelete(comment.commentName)"
              @click="emitDeleteComment(comment.commentId)">删除评论</el-button>
        </div>
      </div>
    </article>
  </div>
</template>

<script>
  import Qs from "qs"
  import Moment from "moment";
  export default {
    name: "Comment",
    data(){
      return {
        content:'',
        topic:{},
        comments:[],
        commentUserName:'',
      }
    },
    computed:{
      isShowDelete(){
        return commentName => this.showDelete(commentName)
      }
    },
    mounted() {
      this.$axios.post('http://localhost:8080/topic/selectTopicById',
        Qs.stringify({topicId:this.$route.query.comment_target})).then(
            response => {
              this.topic = response.data
            },
            error => {
              console.log(error)
            }
      )

      this.$axios.post('http://localhost:8080/comment/selectCommentByTarget',
          Qs.stringify({commentTarget:this.$route.query.comment_target})).then(
              response => {
                this.comments = response.data
              },
              error => {
                this.error(error)
              }
      )
    },
    methods:{
      showDelete(commentName){
        let user = JSON.parse(localStorage.getItem('user'));
        if (user !== null && user.name !== '' && user.password !== ''){
          return user.name === commentName
        }else {
          return false
        }
      },
      succeed() {
        this.$notify({
          title: '成功',
          message: '评论成功',
          type: 'success'
        });
      },
      deleteSucceed() {
        this.$notify({
          title: '成功',
          message: '删除成功',
          type: 'success'
        });
      },
      notLogged() {
        this.$notify.error({
          title: '失败',
          message: '请先登录',
        });
      },
      failed() {
        this.$notify.error({
          title: '失败',
          message: '评论失败，服务端错误',
        });
      },
      deleteFailed() {
        this.$notify.error({
          title: '失败',
          message: '评论失败，服务端错误',
        });
      },
      error(message) {
        this.$notify.error({
          title: '错误',
          message: '服务器端错误,错误原因：' + message,
        });
      },
      emitReturn(){
        this.$bus.$emit('router',this.$route.query.router)
      },
      emitSubmit(){
        if (this.content === ''){
          this.$notify.error({
            title: '失败',
            message: '请输入评论内容',
          });
        }else {
          let user = JSON.parse(localStorage.getItem('user'));
          if (user !== null && user.name !== '' && user.password !== ''){
            let comment = {
              commentTarget:this.$route.query.comment_target,
              commentName:user.name,
              commentUserName:'张三',
              commentContent:this.content,
              commentTime:Moment().format("YYYY-MM-DD HH:mm:ss")
            }
            this.$axios.post('http://localhost:8080/comment/createComment',Qs.stringify(comment)).then(
                response => {
                  if (response.data === 1){
                    this.succeed()
                    this.content = ''
                    this.$axios.post('http://localhost:8080/comment/selectCommentByTarget',
                        Qs.stringify({commentTarget:this.$route.query.comment_target})).then(
                        response => {
                          this.comments = response.data
                        },
                        error => {
                          this.error(error)
                        }
                    )
                  }else {
                    this.failed()
                  }
                },
                error => {
                  this.error(error)
                }
            )
          }else {
            this.notLogged()
          }
        }
      },
      emitDeleteComment(commentId){
        this.$axios.post('http://localhost:8080/comment/deleteCommentById',Qs.stringify({commentId:commentId})).then(
            response => {
              if (response.data === 1){
                this.deleteSucceed()
                this.$axios.post('http://localhost:8080/comment/selectCommentByTarget',
                    Qs.stringify({commentTarget:this.$route.query.comment_target})).then(
                    response => {
                      this.comments = response.data
                    },
                    error => {
                      this.error(error)
                    }
                )
              }else {
                this.deleteFailed()
              }
            },
            error => {
              this.error(error)
            }
        )
      }
    }
  }
</script>

<style scoped>

</style>