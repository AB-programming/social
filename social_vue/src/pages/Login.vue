<template>
  <div>
    <el-dialog
        title="登录"
        :visible.sync="dialogVisible"
        width="30%"
        :before-close="handleClose">
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="账号" prop="name">
          <el-input type="text" v-model="ruleForm.name" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="pass">
          <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer"></span>
    </el-dialog>
  </div>
</template>

<script>
  import Qs from "qs"
  export default {
    name: "Login",
    data() {
      var validateName = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入账号'));
        } else {
          callback();
        }
      };
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          callback();
        }
      };
      return {
        dialogVisible: false,
        ruleForm: {
          name:'',
          pass: '',
        },
        rules: {
          name: [
            { validator: validateName, trigger: 'blur' }
          ],
          pass: [
            { validator: validatePass, trigger: 'blur' }
          ],
        }
      };
    },

    methods: {
      succeed() {
        this.$notify({
          title: '成功',
          message: '登录成功',
          type: 'success'
        });
      },
      failed() {
        this.$notify.error({
          title: '失败',
          message: '登录失败，用户名或密码错误',
        });
      },
      error(message) {
        this.$notify.error({
          title: '错误',
          message: '服务器端错误,错误原因：' + message,
        });
      },
      submitForm() {
            let user = {
              name:this.ruleForm.name,
              password:this.ruleForm.pass
            }
            this.$axios.post('http://localhost:8080/user/login',Qs.stringify(user)).then(
                response => {
                  if (response.data === 1){
                    this.succeed()
                    localStorage.setItem('user',JSON.stringify(user))
                    setTimeout(() => {
                      location.reload()
                    },2000)
                  }else {
                    this.failed()
                  }
                },
                error => {
                  this.error(error)
                }
            )

            this.$refs["ruleForm"].resetFields();
            this.dialogVisible = false
            this.$bus.$emit('router','/home')
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      handleClose(done) {
        this.$refs['ruleForm'].resetFields();
        done();
        this.$bus.$emit('router','/home')
      }
    },
    mounted(){
        this.dialogVisible = true
    },
  }
</script>

<style scoped>

</style>