<template>
  <div>
    <el-dialog
        title="提示"
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
        <el-form-item label="确认密码" prop="checkPass">
          <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
  </span>
    </el-dialog>
  </div>
</template>

<script>
import Qs from "qs"
export default {
  name: "Register",
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
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.ruleForm.pass) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    return {
      dialogVisible: false,
      ruleForm: {
        name:'',
        pass: '',
        checkPass: '',
      },
      rules: {
        name: [
          { validator: validateName, trigger: 'blur' }
        ],
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ],
      }
    };
  },
  methods: {
    succeed() {
      this.$notify({
        title: '成功',
        message: '注册成功',
        type: 'success'
      });
    },
    failed(message) {
      this.$notify.error({
        title: '失败',
        message: '注册失败，可能已存在该账号，错误原因：' + message,
      });
    },
    inputError() {
      this.$notify.error({
        title: '失败',
        message: '两次输入密码不一致',
      });
    },
    handleClose(done) {
      this.$refs['ruleForm'].resetFields();
      done();
      this.$bus.$emit('router','/home');

    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let user = {
            name:this.ruleForm.name,
            password:this.ruleForm.pass,
          }
          this.$axios.post('http://localhost:8080/user/createUser',Qs.stringify(user)).then(
              response => {
                  this.succeed()
              },
              error => {
                this.failed(error.message)
              }
          )
          this.$refs[formName].resetFields();
          this.dialogVisible = false
          this.$bus.$emit('router','/home');
        } else {
          this.inputError()
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  mounted(){
    this.dialogVisible = true
  },
}
</script>

<style scoped>

</style>