<template>
  <div id="Home">
    <el-container>
      <el-header style="width: 60%;left:20%;position: relative;" height="100px">
        <div style="width: 200px;float: right">
          <el-autocomplete v-model="name" size="mini" style="width: 200px" placeholder="请输入电影名" class="inline-input"
                           :fetch-suggestions="querySearch" :trigger-on-focus="false" @keyup.enter.native="search" clearable @select="search">
            <i slot="prefix" class="el-icon-search el-input__icon"></i>
          </el-autocomplete>
        </div>
        <div style="margin-top: 30px"><h1>电影列表</h1></div>
        <router-link style="float: right" to="/statistics">查看统计数据</router-link>
      </el-header>
      <el-main>
        <el-card style="width: 60%;left:20%;position: relative;">
          <item v-for="film in films" :film="film" :key="film._id" style="margin-top: 0"></item>
          <el-pagination :total="totalItems" layout="prev,pager,next,jumper" :current-page.sync="currentpage"
                         :page-size="pagesize"></el-pagination>
        </el-card>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  import item from '../components/item'

  export default {
    name: "Home",
    components: {item},
    data() {
      return {
        films: [],
        matchedFilm: [],
        currentpage: 1,
        pagesize: 10,
        name: "",
        totalItems: 1
      }
    },
    watch: {
      currentpage: {
        handler() {
          let _self = this;
          this.axios.get("/getPage?size=" + _self.pagesize + "&current=" + (_self.currentpage - 1)).then(function (res) {
            if (res.data.success) {
              _self.films = res.data.data.content;
              _self.totalItems = res.data.data.totalElements;
            } else {
              _self.films = [];
              _self.totalItems = 0
            }
          }).catch(function () {
            _self.$message({type: "info", text: "网络出错"})
          })
        },
        immediate: true
      }
    },
    methods: {
      querySearch(queryString, cb) {
        let _self = this;
        _self.axios.get("/match?name=" + queryString).then(function (res) {
          if (res.data.success) {
            _self.matchedFilm = res.data.data;
          }
          cb(_self.matchedFilm);
        });
      },
      search() {
        let _self = this;
        _self.matchedFilm.forEach(function (item) {
          if (item.value === _self.name) {
            _self.$router.push({path: '/detail', query: {id: item.id}})
          }
        })
      }
    }
  }
</script>

<style scoped>
  #Home {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }

  a:link {
    text-decoration: none;
    color: green;
    font-size: 14px;
  }

  a:active {
    text-decoration: underline;
    color: red;
    font-size: 14px;
  }
</style>
