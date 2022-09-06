<template>
  <div>
    <el-dialog
        title="修改信息"
        :visible.sync="dialogVisible"
        width="30%"
        :before-close="handleClose">
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="个人昵称" prop="userName">
          <el-input v-model="ruleForm.userName"></el-input>
        </el-form-item>
        <el-form-item label="用户性别" prop="sex">
          <el-radio-group v-model="ruleForm.sex">
            <el-radio label="男"></el-radio>
            <el-radio label="女"></el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="用户年龄" prop="age">
          <el-input v-model="ruleForm.age"></el-input>
        </el-form-item>
        <el-form-item label="用户职业" prop="occupation">
          <el-select v-model="ruleForm.occupation" placeholder="请选择职业">
            <el-option label="学生" value="学生"></el-option>
            <el-option label="教师" value="教师"></el-option>
            <el-option label="工人" value="工人"></el-option>
            <el-option label="工程师" value="工程师"></el-option>
            <el-option label="医生" value="医生"></el-option>
            <el-option label="厨师" value="厨师"></el-option>
            <el-option label="自由职业" value="自由职业"></el-option>
            <el-option label="其他" value="其他"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="个性签名" prop="signature">
          <el-input type="textarea" v-model="ruleForm.signature"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
  import Qs from "qs"
  export default {
    name: "Edit",
    data() {
      return {
        dialogVisible: true,
        ruleForm: {
          userName: this.$route.query.userName,
          age:this.$route.query.age,
          occupation: this.$route.query.occupation,
          sex: this.$route.query.sex,
          signature: this.$route.query.signature
        },
        rules: {
          userName: [
            { required: true, message: '请输入昵称', trigger: 'blur' },
            { min: 1, max: 8, message: '长度在 1 到 8 个字符', trigger: 'blur' }
          ],
          age: [
            { required: true, message: '请输入年龄', trigger: 'blur' },
            { min: 1, max: 5, message: '长度在 1 到 5 个字符', trigger: 'blur' }
          ],
          occupation: [
            { required: true, message: '请选择职业', trigger: 'change' }
          ],
          sex: [
            { required: true, message: '请选择性别', trigger: 'change' }
          ],
          signature: [
            { required: true, message: '请编辑个性签名', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
      handleClose(done) {
              done();
      },
      succeed() {
        this.$notify({
          title: '成功',
          message: '修改成功',
          type: 'success'
        });
      },
      failed(error) {
        this.$notify.error({
          title: '失败',
          message: '修改失败，失败原因：' + error,
        });
      },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            let newUser = {
              name:this.$route.query.name,
              userName:this.ruleForm.userName,
              age:this.ruleForm.age,
              sex:this.ruleForm.sex,
              occupation:this.ruleForm.occupation,
              signature:this.ruleForm.signature
            }
            this.$axios.post('http://localhost:8080/user/updateUser',Qs.stringify(newUser)).then(
                response => {
                  this.succeed()
                  setTimeout(() => {
                    location.reload()
                  },2000)
                },
                error => {
                  this.failed(error)
                }
            )

            this.dialogVisible = false
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    },
    watch:{
      dialogVisible:{
        immediate:true,
        handler(newValue, _){
          if (newValue === false){
            console.log(false)
            this.$bus.$emit('router',this.$route.query.router)
          }
        }
      }
    },
    mounted() {
      console.log(this.$route.query.router)
    }
  }
</script>

<style scoped>

</style>