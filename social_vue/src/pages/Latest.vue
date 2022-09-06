<template>
  <div>
    <br><br><br>
    <article class="media" v-for="topic in topics" :key="topic.topicId">
      <figure class="media-left">
          <p class="image is-64x64">
            <img src="../assets/logo.png">
          </p>
      </figure>
      <div class="media-content">
        <div class="content">
          <p>
            <strong>{{ topic.topicUserName }}({{ topic.topicName }})</strong> <el-tag>{{ topic.topicType }}</el-tag> <small>{{ topic.topicTime }}</small>
            <br>
           {{ topic.topicContent }}
          </p>
        </div>
      </div>
      <el-button
          type="danger" plain
          v-if="isShowDelete(topic.topicName)"
          class="myDelete"
          @click="emitDeleteTopic(topic.topicId)">删除帖子</el-button>
      <el-badge :value="getFavorite(topic.topicId)" class="item">
        <el-button size="small" @click="emitFavorite(topic.topicId)">点赞</el-button>
      </el-badge>
      <el-badge :value="getCommentCount(topic.topicId)" class="item" type="primary">
        <el-button size="small" @click="emitComment(topic.topicId)">评论</el-button>
      </el-badge>
    </article>
  </div>
</template>

<script>
  import Qs from "qs"
  export default {
      name: "Latest",
      data(){
        return {
          topics:[],
          favorites:[],
          comments:[]
        }
      },
      computed:{
        getFavorite(){
          return topicId => this.getFavoriteCount(topicId)
        },
        getComment(){
          return topicId => this.getCommentCount(topicId)
        },
        isShowDelete(){
          return topicName => this.showDelete(topicName)
        }
      },
      mounted() {
        this.$axios.post('http://localhost:8080/topic/latestTopic').then(
            response => {
              this.topics = response.data
            },
        )

        this.$axios.post('http://localhost:8080/favorite/selectFavorite').then(
            response => {
              this.favorites = response.data
            },
            error => {
              console.log(error)
            }
        )

        this.$axios.post('http://localhost:8080/comment/selectComment').then(
            response => {
              this.comments = response.data
              console.log(this.comments)
            },
            error => {
              console.log(error)
            }
        )
      },
      methods:{
        emitDeleteTopic(topicId){
          this.$axios.post('http://localhost:8080/topic/deleteTopic',Qs.stringify({topicId:topicId})).then(
              response => {
                if (response.data === 1){
                  this.succeed2()
                  this.$axios.post('http://localhost:8080/topic/latestTopic').then(
                      response => {
                        this.topics = response.data
                      },
                  )
                }else {
                  this.failed2()
                }
              },
              error => {
                this.error(error)
              }
          )
        },
        showDelete(topicName){
          let user = JSON.parse(localStorage.getItem('user'));
          if (user !== null && user.name !== '' && user.password !== ''){
            return user.name === topicName
          }else {
            return false
          }
        },
        succeed() {
          this.$notify({
            title: '成功',
            message: '点赞成功',
            type: 'success'
          });
        },
        succeed2() {
          this.$notify({
            title: '成功',
            message: '删除成功',
            type: 'success'
          });
        },
        failed() {
          this.$notify.error({
            title: '失败',
            message: '您已经点赞过该帖子',
          });
        },
        failed2() {
          this.$notify.error({
            title: '失败',
            message: '删除失败，服务端故障',
          });
        },
        error(message) {
          this.$notify.error({
            title: '错误',
            message: '服务器端错误,错误原因：' + message,
          });
        },
        notLogged(){
          this.$notify.error({
            title: '失败',
            message: '请先登录',
          });
        },
        getFavoriteCount(target){
          let count = 0
          let favorite
          for (favorite in this.favorites){
            if (this.favorites[favorite].favoriteTarget === target){
              count++
            }
          }
          return count
        },
        getCommentCount(target){
          let count = 0;
          let comment
          for (comment in this.comments){
            if (this.comments[comment].commentTarget === target){
              count++
            }
          }
          return count
        },
        emitFavorite(favoriteTarget){
          let user = JSON.parse(localStorage.getItem('user'));
          if (user !== null && user.name !== '' && user.password !== ''){
            let favorite = {
              favoriteName:user.name,
              favoriteTarget:favoriteTarget
            }
            this.$axios.post('http://localhost:8080/favorite/createFavorite',Qs.stringify(favorite)).then(
                response => {
                  if (response.data === 1){
                    this.succeed()
                    this.$axios.post('http://localhost:8080/favorite/selectFavorite').then(
                        response => {
                          this.favorites = response.data
                        },
                        error => {
                          console.log(error)
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
        },
        emitComment(topicId){
          this.$bus.$emit('comment',topicId)
        }
      }
    }
</script>

<style scoped>
  .item {
    margin-top: 10px;
    margin-right: 40px;
  }
  .myDelete{
    margin-right: 40px;
  }
</style>