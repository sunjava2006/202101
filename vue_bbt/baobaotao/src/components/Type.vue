<template>
    <div>
        商品分类管理页面
        
        <b-card
        header="添加商品分类"
        header-tag="header"
       
        footer-tag="footer">
            <b-input-group prepend="分类名" class="mt-3">
                <b-form-input v-model="newType"></b-form-input>
                <b-input-group-append>
                <b-button variant="info" v-on:click="addType">添加</b-button>
                </b-input-group-append>
            </b-input-group>
        </b-card>

       <table class="table">
           <thead>
               <tr>
                   <th>序号</th>
                   <th>类型名</th>
                   <th></th>
               </tr>
           </thead>
           <tbody>

               <tr v-for="(i,idx) in typeList" :key="idx">
                   <td scope="row">{{idx+1}}</td>
                   <td>{{i.name}}</td>
                   <td>
                       <button type="button" class="btn btn-danger" v-bind:id="idx" v-on:click="delType">删除</button>
                       <button type="button" class="btn btn-warning" v-bind:id="idx" v-on:click="modifyType">修改</button>
                   
                   </td>
               </tr>
               
           </tbody>
           <tfoot>
               <td colspan="2">
                   共{{totalCount}}个类型，共{{totalPage}}页，当前是第{{currPage}}页。
                </td>
                <td>
                    <div class="btn-group" role="group" aria-label="">
                       
                       <button type="button" class="btn btn-primary" v-on:click="previousList" v-bind:disabled="currPage==1">上一页</button>
                      
                       <button type="button" class="btn btn-primary" v-on:click="nextList" v-bind:disabled="currPage==totalPage">下一页</button>
                   </div>
                </td>
                   

               
           </tfoot>
       </table>
       



 

        <b-modal ref="modifyModal" hide-footer title="类型修改">
            <div class="d-block text-center">
                  <b-input-group size="lg" prepend="类型名" >
                    <b-form-input v-model="currmodifyType.name"></b-form-input>
                 </b-input-group>
            </div>
           <br>
            <b-button-group class="float-right">
                <b-button variant="success" @click="cancelModify">取消</b-button>
                <b-button variant="warning" @click="confirmModify">修改</b-button>
               
            </b-button-group>
        </b-modal>
    

      
      

    </div>
</template>

<script>
export default {
    data(){
        return{
            newType:'',
            currPage:1,
            size:10,
            typeList:[],
            totalPage:0,
            totalCount:0,
            currmodifyType:{}
        }
    },
    methods:{
       cancelModify(){
          this.$refs['modifyModal'].hide();
       },
       confirmModify(){
             this.$refs['modifyModal'].hide();  
             this.axios({
                 method:"Post",
                 data:this.currmodifyType,
                 Headers:[{"ContentType": "application/JSON"}],
                 url:'/api/updateType'
             })
             .then(res=>{
                 console.log(res);
                 if(res.data.status=='ok'){
                     this.list(this.currPage, this.size);
                 }
             })
             .catch(err=>{
                 console.log(err);
             }) 
       },
        addType(){
            this.axios.post("/api/addType","name="+this.newType)
            .then(res => {
               this.list(1, this.size);
            })
            .catch(err => {
                alert(err);
            })
        },
        list(page, size){
            this.axios.get("/api/listType",{params:{"currPage":page, "size":size}})
            .then(res => {
                console.log(res)
                this.typeList = res.data.list;
                this.totalPage = res.data.totalPage;
                this.totalCount = res.data.totalCount;
                this.currPage = res.data.currPage;
            })
            .catch(err => {
                console.error(err); 
            })
        },
        previousList(){
            this.list(this.currPage-1, this.size);
        },
        nextList(){
            
            this.list(this.currPage+1, this.size);
        },
        delType(e){
            console.log(e);
            this.$bvModal.msgBoxConfirm('确认删除"'+this.typeList[e.target.id].name+'"?')
          .then(value => {
             
            if(value){
                let typeID = this.typeList[e.target.id].typeID;

                this.axios.get("/api/delType/"+typeID)
                .then(res => {
                    if(res.data.status=='ok'){
                        this.list(this.currPage, this.size);
                    }else{
                        this.$bvToast.toast('删除失败', {
                        title: '信息：',
                        autoHideDelay: 5000,
                        
                        })
                    }
                    
                })
                .catch(err => {
                     this.$bvToast.toast(err, {
                        title: '信息：',
                        autoHideDelay: 5000,
                        
                        })
                })
            }
          })
          .catch(err => {
            // An error occurred
          })
        },
        modifyType(e){
            this.currmodifyType = {"typeID":this.typeList[e.target.id].typeID, "name":this.typeList[e.target.id].name}
                               
            this.$refs['modifyModal'].show();
        }
    },
    created(){
        this.list(this.currPage, this.size);
    }

}
</script>

<style>
   .modal{
       display: block im !important;
   }
</style>