<template>
    <div>
        <nav class="navbar navbar-expand-sm navbar-light bg-light">
            <a class="navbar-brand">商家管理页面</a>
            <button class="navbar-toggler d-lg-none" type="button" data-toggle="collapse" data-target="#collapsibleNavId" aria-controls="collapsibleNavId"
                aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="collapsibleNavId">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item active">
                       
                        <router-link to="/manager/type" class="nav-link">商品分类管理!</router-link>
                    </li>
                    <li class="nav-item">
                        <router-link to="/manager/goods" class="nav-link">商品管理</router-link>
                    </li>
                   
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
        
        <router-link to="/manager"></router-link>
        <router-view ></router-view>
    </div>
    
</template>