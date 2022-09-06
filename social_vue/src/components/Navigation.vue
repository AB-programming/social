<template>
  <div>
    <el-row>
      <el-col :span="21">
        <div class="grid-content bg-purple">
          <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal">
            <el-menu-item index="1" @click="emitRouter('/home')">首页</el-menu-item>
            <el-menu-item index="2" @click="emitRouter('/latest')">最新</el-menu-item>
            <el-menu-item index="3">最热</el-menu-item>
            <el-submenu index="4">
              <template slot="title">更多</template>
              <el-menu-item index="4-1" @click="emitUser">个人信息</el-menu-item>
              <el-menu-item index="4-2">会员服务</el-menu-item>
              <el-menu-item index="4-3">反馈/建议</el-menu-item>
            </el-submenu>
          </el-menu>
        </div>
        <el-button type="primary" @click="emitPublish">上传帖子<i class="el-icon-upload el-icon--right"></i></el-button>
      </el-col>
      <el-col :span="3">
        <div class="grid-content bg-purple-light">
          <div v-show="!isLogin">
            <el-button type="primary" round @click="emitLogin">登录</el-button>
            <el-button type="success" round @click="emitRegister">注册</el-button>
          </div>
          <div v-show="isLogin">
            <el-button type="danger" round @click="emitUser">{{loginName}}</el-button>
          </div>
        </div>
      </el-col>
    </el-row>
  </div>
</template>

<script>
  import Qs from "qs"
  export default {
    name: "Navigation",
    data() {
      return {
        isLogin:false,
        loginName:'未命名用户',
        activeIndex: '1',
        activeIndex2: '1',
      };
    },
    props:['router'],
    methods: {
      selectUser(){
        let parse = JSON.parse(localStorage.getItem('user'));
        let user = {
          name:parse.name,
          password:parse.password
        }
        this.$axios.post('http://localhost:8080/user/selectUser',Qs.stringify(user)).then(
            response => {
              this.$bus.$emit('user',response.data)
            },
            error => {
              console.log("错误的原因是：",error)
            }
        )
      },
      emitRouter(router){
        this.$bus.$emit('router',router)
      },
      emitLogin(){
        this.$bus.$emit('router','/login')
      },
      emitRegister(){
        this.$bus.$emit('router','/register')
      },
      emitUser(){
        this.selectUser()
      },
      emitPublish(){
        if (localStorage.getItem('user') === null){
          this.failed()
        }else {
          let user = {
            name:JSON.parse(localStorage.getItem('user')).name,
            userName:this.loginName
          }
          this.$bus.$emit('publish',user)
        }
      },
      failed() {
        this.$notify.error({
          title: '失败',
          message: '请先登录',
        });
      },
    },
    mounted() {
      let user = JSON.parse(localStorage.getItem('user'));
      if (user !== null && user.name !== '' && user.password !== ''){
        this.isLogin = true

        this.$axios.post('http://localhost:8080/user/selectUser',Qs.stringify({
          name:user.name,
          pass:user.password
        })).then(
            response => {
              this.loginName = response.data.userName
              if (this.loginName === null){
                this.loginName = '未命名用户'
              }
            },
        )
      }
    },
  }
</script>

<style scoped>
  button{
    margin-top: 20px;
  }
</style>