<template>
    <div>
         商品管理页面
            <b-card>
                <template #header>
                   <h4 class="mb-0">添加商品</h4>
                </template>
             <b-card-body>
               <b-input-group size="lg" >
                   <b-input-group-prepend is-text>商品类型</b-input-group-prepend>
                   <b-form-select value-field="typeID" text-field="name" v-model="selectedType" :options="typeList"></b-form-select>
                   <b-input-group-prepend is-text>商品名</b-input-group-prepend>
                   <b-form-input v-model="goodsName"></b-form-input>
                </b-input-group>   
                <b-input-group size="lg" >
                    <b-input-group-prepend is-text>单位</b-input-group-prepend>
                    <b-form-input v-model="unit"></b-form-input>
                    <b-input-group-prepend is-text>单价</b-input-group-prepend>
                    <b-form-input v-model="price"></b-form-input>
                    <b-input-group-prepend is-text>图片</b-input-group-prepend>
                    <b-form-file ref="photo" v-on:change="selectPhoto"></b-form-file>
                </b-input-group>   
             </b-card-body>
             <template #footer>
                   <b-button class="float-right" @click="addGoods">添加</b-button>
                </template>
            
            </b-card>

            <b-card>
                <template #header>
                   <h4 class="mb-0">查询</h4>
                </template>
             <b-card-body>
               <b-input-group size="lg" >
                   <b-input-group-prepend is-text>商品类型</b-input-group-prepend>
                   <b-form-select value-field="typeID" text-field="name" v-model="queryTypeID" :options="typeList"></b-form-select>
                   <b-input-group-prepend is-text>商品名</b-input-group-prepend>
                   <b-form-input v-model="queryGoodsName"></b-form-input>
                </b-input-group>   
                <b-input-group size="lg" >
                    <b-input-group-prepend is-text>价格从</b-input-group-prepend></b-input-group-prepend>
                    <b-form-input v-model="queryMinPrice"></b-form-input>
                    <b-input-group-prepend is-text>价格到</b-input-group-prepend>
                    <b-form-input v-model="queryMaxPrice"></b-form-input>
                     <b-input-group-append>                        
                           <b-button variant="info" @click="query">查询</b-button>
                    </b-input-group-append>
                </b-input-group>   
             </b-card-body>
            </b-card>
            <table class="table  table-bordered" v-for="(i, idx) in goodsList" :key="idx">
                <tbody>
                    <tr>
                        <td rowspan="4" style="width:200px;">
                            <img v-bind:src="'/api/'+i.photo" alt="" style="width:180px;">
                        </td>
                        <td class="name">商品名</td>
                        <td>{{i.goodsName}}</td>
                        <td rowspan="4" style="width:100px">
                            <button class="btn btn-danger" v-bind:id="idx" @click="delGoods">删除</button>
                            <br>
                            <br>
                            <button class="btn btn-warning" v-bind:id="idx">修改</button>
                        </td>
                    </tr>
                    <tr>
                        <td class="name">商品类型</td>
                        <td>{{i.type.name}}</td>
                    </tr>
                    <tr>
                        <td class="name">单位</td>
                        <td>{{i.unit}}</td>
                        
                            
                        
                    </tr>
                    <tr>
                        <td class="name">单价</td></td>
                        <td>{{i.price}}</td>
                    </tr>
                 </tbody>
                 
            </table>                   
            <table class="tab">
              <tfoot>
                      <td >
                        共{{totalCount}}个商品，共{{totalPage}}页，当前是{{currPage}}页。
                      </td>
                      <td >
                          <div class="btn-group float-right" role="group" >
                            <button type="button" class="btn btn-primary" @click="prePage" v-bind:disabled="currPage==1">上一页</button>
                            <button type="button" class="btn btn-primary" @click="nextPage" v-bind:disabled="currPage==totalPage">下一页</button>
                            
                          </div>
                      </td>
                 </tfoot>
            </table>
    </div>
</template>

<script>
export default {
  data() {
    return {
      selectedType: null,
      goodsName: "",
      unit: "",
      price: "",
      photo: null,
      typeList: [
        { typeID: 1, name: "js" },
        { typeID: 2, name: "jsd" },
      ],
      queryTypeID:'',
      queryGoodsName:'',
      queryMinPrice:'',
      queryMaxPrice:'',
      goodsList:[],
      currPage:0,
      size:3,
      totalCount:0,
      totalPage:0
    }
  },
  methods: {
    delGoods(e){
        let idx = e.target.id;
        let goods = this.goodsList[idx];
        this.$bvModal.msgBoxConfirm('删除"'+goods.goodsName+'"吗？')
        .then(value=>{
          if(value){
            this.axios.get('/api/delGoods',{params:{goodsID:goods.goodsID}})
            .then(res => {
                this.list(this.currPage);
            })
            .catch(err => {
              console.error(err); 
            })
          }
        })

    },
    prePage(){
      this.list(this.currPage-1);
    },
    nextPage(){
      this.list(this.currPage+1);
    },
    list(page){
          let data = "typeID="+this.queryTypeID+
                    "&goodsName="+this.queryGoodsName+
                    "&minPrice="+this.queryMinPrice+
                    "&maxPrice="+this.queryMaxPrice+
                    "&currPage="+page+
                    "&size="+this.size;
        

        this.axios.post('/api/queryGoods',data, {"ContentType": "application/JSON"})
        .then(res => {
            console.log(res);
            this.goodsList = res.data.goodsList;
            this.currPage = res.data.currPage;
            this.totalCount = res.data.totalCount;
            this.totalPage = res.data.totalPage;
        })
        .catch(err => {
            console.error(err); 
        })
    },
    query(){
        this.list(1);
    },
    selectPhoto(e) {
      this.photo = e.target.files[0];
    },
    addGoods() {
      let formData = new FormData();
      formData.append("typeID", this.selectedType);
      formData.append("goodsName", this.goodsName);
      formData.append("unit", this.unit);
      formData.append("price", this.price);
      formData.append("photo", this.photo);

      this.axios
        .post("/api/addGoods", formData, {
          "Content-Type": "multipart/form-data",
        })
        .then((res) => {
          this.$bvModal.msgBoxConfirm("添加商品功能");
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
  created() {
    this.axios
      .get("/api/listAllType")
      .then((res) => {
        console.log(res);
        this.typeList = res.data;
        this.typeList.unshift({typeID:'',name:''});
      })
      .catch((err) => {
        console.error(err);
      });
  },
};
</script>

<style>
 .name{
   width: 100px;
   font-weight: bold;
 }
</style>