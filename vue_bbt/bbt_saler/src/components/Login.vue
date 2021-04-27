<template>
    <div id="loginCard">
       <div class="card text-dark bg-light col-md-6 offset-md-3" >
        
         <div class="card-body">
           <h4 class="card-title">商家登录</h4>

             <div class="input-group ">
                <div class="input-group-prepend">
                  <span class="input-group-text">登录名</span>
                </div>
                <input type="text" class="form-control" placeholder="" v-model="regName" >
            </div>


           <div class="input-group">
               <div class="input-group-prepend">
                  <span class="input-group-text">密码</span>
                </div>
               <input type="text" class="form-control" name="name" id="name" v-model="pwd" placeholder="" >
                <span class="input-group-btn">
                   <button class="btn btn-secondary" type="button" v-on:click="toLogin">登录</button>
             </span>
           </div>
          
         </div>
       </div>
    </div>
</template>
<script>
export default {
  name: 'Login',
  data(){
      return{
          regName:'',
          pwd:''
      };
  },
  methods:{
      toLogin(){

          this.axios({url:'/api/login',
                     data:{"regName":this.regName,'pwd':this.pwd},
                     headers:{"Content-Type": "application/json"},
                     method:'post'})
          .then(res => {
              if(res.data.status=='ok'){
                  this.$router.replace({path:'/manager'})
              }
          })
          .catch(err => {
              console.error(err); 
          })
      }
  }

}
</script>
<style>
  #loginCard{
      margin-top:100px;
  }
 
</style>
