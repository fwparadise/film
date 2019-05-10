<template>
  <div id="Detail">
    <el-card style="width: 60%;left: 20%;position: relative;" shadow="hover">
      <div slot="header" style="text-align: center">
        <router-link to="/" style="float: left">返回首页</router-link>
        <a :href="'https://movie.douban.com/subject/'+film._id" target="_blank" style="float: right">去豆瓣</a>
        {{film.title}}
      </div>
      <el-card style="position:relative;border: none" shadow="never">
        <el-container>
          <el-aside style="position: relative" width="200px">
            <img :src="film.poster" alt="图片弄丢了" onerror="src='../../film/static/poster.jpg'"/>
          </el-aside>
          <el-main style="text-align: left;color: #666666">
            <p v-if="film.directors.length!==0">导演：<a v-for="director in film.directors" :key="director.id"
                     :href="'https://movie.douban.com/celebrity/'+director.id" target="_blank">{{director.name}}</a></p>
            <p v-if="film.writers.length!==0">编剧：<a v-for="writer in film.writers" :key="writer.id"
                     :href="'https://movie.douban.com/celebrity/'+writer.id" target="_blank">{{writer.name}}</a></p>
            <p v-if="film.casts.length!==0">主演：<a v-for="cast in film.casts" :key="cast.id" :href="'https://movie.douban.com/celebrity/'+cast.id"
                     target="_blank">{{cast.name}}</a></p>
            <p v-if="film.genres[0]!==''">类型：{{film.genres.join(' / ')}}</p>
            <p v-if="film.languages[0]!==''">语言：{{film.languages.join(' / ')}}</p>
            <p v-if="film.countries[0]!==''">制作国家/地区：{{film.countries.join(' / ')}}</p>
            <p v-if="film.pubdate[0]!==''">上映时间：{{film.pubdate.join(' / ')}}</p>
            <p v-if="film.duration!==''">片长：{{film.duration}}分钟</p>
            <p v-if="film.aka[0]!==''">又名：{{film.aka.join(' / ')}}</p>
            <p v-if="film.season_count!==''">总季数：{{film.season_count}}</p>
            <p v-if="film.site!==''">site：<a :href="'https:'+film.site" target="_blank">{{film.site}}</a> </p>
            <p v-if="film.imdb!==''">imdb链接：<a :href="'https://www.imdb.com/title/'+film.imdb" target="_blank">{{film.imdb}}</a>
            </p>
          </el-main>
        </el-container>
        <el-card shadow="never" style="border: none">
          <div slot="header" style="color: #007722">{{film.title}}的剧情简介</div>
          <p v-html="film.summary.replace('\n','<br/>')"></p>
        </el-card>
        <el-card style="border-style: solid none none none" shadow="never">
          <div style="float: right">
            <el-container>
              <el-aside width="60px" style="margin: auto;font-size: 28px">{{(film.rating.average/2).toFixed(1)}}</el-aside>
              <el-main style="width: 180px;color: green;">
                <el-rate v-model="(parseFloat(film.rating.average)/2).toFixed(1)" allow-half disabled></el-rate>
                （{{film.rating.rating_people}}人评价）
              </el-main>
            </el-container>
          </div>
          <div v-for="(star,index) in film.rating.stars" :key="index">
            <span>{{5-index}}星</span><el-progress :percentage="Number(star)" :stroke-width="15" :text-inside="true" style="width: 200px;display: inline-block"></el-progress>
          </div>

        </el-card>
      </el-card>
    </el-card>
  </div>
</template>

<script>
  export default {
    name: "Detail",
    data() {
      return {
        id: 0,
        film: null
      }
    },
    activated() {
      this.id = this.$route.query.id;
      let _self = this;
      _self.axios.get("/getOne?id="+_self.id).then(function (res) {
        if (res.data.success) {
          _self.film=res.data.data;
          for (let i = 1; i < _self.film.directors.length; ++i) {
            _self.$set(_self.film.directors[i], 'name', ' / ' + _self.film.directors[i].name)
          }
          for (let i = 1; i < _self.film.writers.length; ++i) {
            _self.$set(_self.film.writers[i], 'name', ' / ' + _self.film.writers[i].name)
          }
          for (let i = 1; i < _self.film.casts.length; ++i) {
            _self.$set(_self.film.casts[i], 'name', ' / ' + _self.film.casts[i].name)
          }
        }
      });
    }
  }
</script>

<style scoped>
  #Detail {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: left;
    color: #666666;
    margin-top: 60px;
  }

  img {
    float: left;
    width: 200px;
    height: 300px;
    left: 50%;
    top: 50%;
    margin-left: -100px;
    margin-top: -150px;
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
