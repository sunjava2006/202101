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
                        <td>{{i.goodsName}}</td>
                        <td rowspan="2" style="width:100px">
                            <button class="btn btn-danger">删除</button>
                        </td>
                    </tr>
                    <tr>
                        <td>{{i.type.name}}</td>
                    </tr>
                    <tr>
                        <td>{{i.unit}}</td>
                        <td rowspan="2">
                            <button class="btn btn-warning">修改</button>
                        </td>
                    </tr>
                    <tr>
                        <td>{{i.price}}</td>
                    </tr>
                 </tbody>
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
      size:10,
      totalCount:0,
      totalPage:0
    }
  },
  methods: {
    query(){
        let data = "typeID="+this.queryTypeID+
                    "&goodsName="+this.queryGoodsName+
                    "&minPrice="+this.queryMinPrice+
                    "&maxPrice="+this.queryMaxPrice+
                    "&currPage="+1+
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