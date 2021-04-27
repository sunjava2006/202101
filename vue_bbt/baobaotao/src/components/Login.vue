<template>
    <div class="container line col-md-6">
        登录页面
        <a href="/#/manager">管理员页面</a>
        <router-link to="/manager" tag="button">管理员页面!</router-link>

        <div class="card ">
            <div class="card-header bg-dark text-light" >商家登录</div>
            <div class="card-body">
                
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                    <span class="input-group-text">用户名</span>
                    </div>
                    <input type="text" class="form-control" v-model="regName">
                </div>

                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                    <span class="input-group-text">密码</span>
                    </div>
                    <input type="text" class="form-control" v-model="pwd" >
                </div>

            </div> 
            <div class="card-footer">
                {{msg}}
                <button type="button" class="btn btn-dark float-right" v-on:click="tologin">登录</button>
            </div>
        </div>
    </div>
</template>
<script>
export default {
     data(){
         return{
            regName:'',
            pwd:'',
            msg:''
         }
     },
     methods:{
         tologin(){
            this.axios.post("/api/login","regName="+this.regName+"&pwd="+this.pwd)
            .then(res => {
                console.log(res)
                if(res.data.status=='ok'){
                    this.$router.replace({'path':'/manager/type'});
                }else{
                    this.msg='登录失败';
                }
            })
            .catch(err => {
                console.error(err); 
            })
          }
     }
          
    
}
</script>