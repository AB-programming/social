<template>
  <div>
    <div>
      <el-drawer
          title="我是标题"
          :visible.sync="drawer"
          :with-header="false">
        <el-row class="demo-avatar demo-basic">
          <div class="demo-basic--circle">
            <div class="block">
              <el-avatar :size="100" :src="circleUrl"></el-avatar>
            </div>
          </div>
        </el-row>
        <el-divider><i class="el-icon-mobile-phone"></i></el-divider>
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>用户个人信息</span>
          </div>
          <div class="text item">
            用户昵称————{{this.$route.query.userName}}
          </div>
          <div class="text item">
            用户账号————{{this.$route.query.name}}
          </div>
          <div class="text item">
            用户年龄————{{this.$route.query.age}}
          </div>
          <div class="text item">
            用户性别————{{this.$route.query.sex}}
          </div>
          <div class="text item">
            用户职业————{{this.$route.query.occupation}}
          </div>
          <el-collapse v-model="activeNames" @change="handleChange">
            <el-collapse-item title="用户个性签名" name="4">
              <div>{{this.$route.query.signature}}</div>
            </el-collapse-item>
          </el-collapse>
        </el-card>
        <el-button type="success" round @click="emitEdit">编辑信息</el-button>
        <el-button type="info" round @click="quitUser">退出登录</el-button>
        <el-button type="danger" round @click="deleteUser">注销账户</el-button>
      </el-drawer>
    </div>
    <div>
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
  import Qs from "qs"
  export default {
    name: "User",
    data() {
      return {
        drawer: true,
        circleUrl: "http://localhost:8080/assets/users/logo.png",
        activeNames: ['1']
      };
    },
    methods: {
      handleChange(val) {
        console.log(val);
      },
      quitUser(){
        localStorage.removeItem('user')
        this.succeed('退出')
        setTimeout(() => {
          location.reload()
        },1000)
      },
      emitEdit() {
        this.$router.replace({
          path:'/user/edit',
          query:{
            router:this.$route.query.router,
            name:this.$route.query.name,
            userName: this.$route.query.userName,
            age: this.$route.query.age,
            sex: this.$route.query.sex,
            occupation: this.$route.query.occupation,
            signature: this.$route.query.signature
          }
        })
      },
      deleteUser(){
        this.$axios.post('http://localhost:8080/user/deleteUser',
            Qs.stringify({name:this.$route.query.name})).then(
            response => {
              if (response.data === 1){
                this.succeed('注销')
                localStorage.removeItem('user')
                setTimeout(() => {
                  location.reload()
                },2000)
              }else {
                this.failed('500')
              }
            },
            error => {
              this.failed(error)
            }
        )
      },
      succeed(data) {
        this.$notify({
          title: '成功',
          message: data + '成功',
          type: 'success'
        });
      },
      failed(error) {
        this.$notify.error({
          title: '失败',
          message: '修改失败，失败原因：' + error,
        });
      },
    },
    watch:{
      drawer:{
        immediate:true,
        handler(newValue, _){
          if (newValue === false){
            this.$bus.$emit('router',this.$route.query.router)
          }
        }
      }
    },
  }
</script>

<style scoped>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 480px;
  }
  button{
    margin-top: 50px;
    margin-left: 20px;
  }
</style>