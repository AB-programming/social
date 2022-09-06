<template>
<!--  导航区-->
  <el-container>
    <el-header>
      <Navigation :router="router"/>
    </el-header>
<!--    内容区-->
    <el-main>
      <router-view></router-view>
    </el-main>
  </el-container>
</template>

<script>
  import Navigation from "./components/Navigation";
  export default {
    name: 'App',
    data(){
      return {
          router:'/home'
      }
    },
    components:{
      Navigation,
    },
    mounted() {
      this.$router.replace(this.router)
      this.$bus.$on('router', (router) => {
        if (this.router !== router){
          this.router = router
          this.$router.replace(this.router)
        }
      })
      this.$bus.$on('user', (user) => {
        let beforeRouter_user = this.router
        if (this.router !== '/user'){
          this.router = '/user'
          this.$router.replace({
            path:'/user',
            query:{
              router:beforeRouter_user,
              name:user.name,
              userName:user.userName,
              age:user.age,
              sex:user.sex,
              occupation:user.occupation,
              signature:user.signature
            }
          })
        }
      })
      this.$bus.$on('publish',(user) => {
        let beforeRouter_publish = this.router
        if (this.router !== '/publish'){
          this.router = '/publish'
          this.$router.replace({
            path:'/publish',
            query:{
              router:beforeRouter_publish,
              name:user.name,
              userName:user.userName,
            }
          })
        }
      })

      this.$bus.$on('comment',(comment_target) => {
        let beforeRouter_comment = this.router
        if(this.router !== '/comment'){
          this.router = '/comment'
          this.$router.replace({
            path:'/comment',
            query:{
              router:beforeRouter_comment,
              comment_target:comment_target
            }
          })
        }
      })
    },
    beforeDestroy() {
      this.$bus.$off('router')
      this.$bus.$off('user')
      this.$bus.$off('publish')
      this.$bus.$off('comment')
    }
  }
</script>

<style>
</style>
