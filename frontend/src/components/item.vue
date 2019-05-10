<template>
  <div id="item">
    <el-card shadow="hover" style="border-style: none none dashed none">
      <el-container direction="horizontal">
        <el-aside width="150px" style="position: relative;">
          <img :src="film.poster" alt="图片弄丢了" onerror="src='../../film/static/poster.jpg'">
        </el-aside>
        <el-main style="color: #666666;">
          <router-link :to="{path:'/detail',query:{id:film._id}}">名字：{{title}}</router-link>
          <p>类别：{{film.genres.join(' / ')}}</p>
          <p>上映时间：{{film.pubdate.join(' / ')}}</p>
          <el-rate v-model="(parseFloat(film.rating.average)/2).toFixed(1)" disabled allow-half show-score
                   style="width: 300px;display: inline"></el-rate>
          <span>({{film.rating.rating_people}}人评价)</span>
        </el-main>
      </el-container>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: "item",
    props: {film: {type:Object,require:true,default:{"_id":"","directors":[],"genres":[],"season_count":"","rating":{"average":"0","rating_people":"","stars":[]},"pubdate":[],"countries":[],"lens_id":0,"casts":[],"title":"","site":"","poster":"","summary":"","languages":[],"episodes":"","writers":[],"imdb":"","year":"","duration":"","douban_site":"","aka":[""]}}},
    data() {
      return {
        title: "",
      }
    },
    mounted() {
      this.title = this.film.title;
      if (this.film.aka[0] !== "") {
        this.title = this.title + ' / ' + this.film.aka.join(' / ')
      }
      if (this.title.length > 30) this.title = this.title.substring(0, 30) + '...';
    }
  }
</script>

<style scoped>
  #item {
    /*font-family: 'Avenir', Helvetica, Arial, sans-serif;*/
    font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color:#2c3e50;
    margin-top: 60px;
    text-align: left;
  }

  img {
    width: 100px;
    height: 150px;
    left: 50%;
    top: 50%;
    margin-top: -75px;
    margin-left: -50px;
    position: absolute;
  }

  a:link{
    text-decoration: none;
    color: green;
    font-size: 14px;
  }
  a:active{
    text-decoration: underline;
    color: red;
    font-size: 14px;
  }
</style>
