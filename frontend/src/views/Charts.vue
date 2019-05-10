<template>
  <div id="charts">
    <el-card shadow="hover">
      <!--<router-link to="/" style="float: left">回到主页</router-link>-->
      <label for="numberEveryKind">各类电影数量统计</label>
      <div id="numberEveryKind" style="width:1000px;height: 400px;margin: 0 auto" v-loading="loading"></div>
      <label for="numberEveryRegion">各地区电影数量统计</label>
      <div id="numberEveryRegion" style="width:1000px;height: 400px;margin: 0 auto" v-loading="loading"></div>
    </el-card>
  </div>
</template>

<script>
  import echarts from "echarts"

  export default {
    name: "charts",
    data() {
      return {
        loading: false,
        films: [],
        numberEveryKind: null,
        myEchart1: null,
        numberEveryRegion: null,
        myEchart2: null
      }
    },
    mounted() {
      let _self = this;
      _self.loading = true;
      _self.axios.get("/getAll").then(function (res) {
        _self.films = res.data.data;
        let everyKind = new Map();
        let everyRegion = new Map();
        _self.films.forEach(function (f) {
          f.genres.forEach(function (g) {
            if (g !== "") {
              if (everyKind.has(g)) {
                everyKind.set(g, everyKind.get(g) + 1);
              } else {
                everyKind.set(g, 1);
              }
            } else {
            }
          });
          f.countries.forEach(function (g) {
            if (g !== "") {
              if (everyRegion.has(g)) {
                everyRegion.set(g, everyRegion.get(g) + 1);
              } else {
                everyRegion.set(g, 1);
              }
            } else {
            }
          })
        });
        _self.numberEveryRegion = new Map();
        _self.numberEveryKind = new Map();
        let sum = 0;
        debugger;
        everyKind.forEach(function (value, key) {
          if (value > _self.films.length / 100) {
            _self.numberEveryKind.set(key, value);
          } else {
            sum = sum + value;
          }
        });
        _self.numberEveryKind.set("其他", sum);
        sum = 0;
        everyRegion.forEach(function (value, key) {
          if (value > _self.films.length / 100) {
            _self.numberEveryRegion.set(key, value);
          } else {
            sum = sum + value;
          }
        });
        _self.numberEveryRegion.set("其他", sum);

        _self.myEchart1 = echarts.init(document.getElementById("numberEveryKind"), "macarons");
        let option1 = {
          title: {},
          tooltip: {
            trigger: 'axis'
          },
          legend: {},
          toolbox: {},
          calculable: true,
          xAxis: [
            {
              type: 'category',
              show: true,
              data: Array.from(_self.numberEveryKind.keys())
            }
          ],
          yAxis: [
            {
              type: 'value',
              show: true,
            }
          ],
          series: [
            {
              type: 'bar',
              data: Array.from(_self.numberEveryKind.values()),
              itemStyle: {
                normal: {
                  //好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，
                  color: function (params) {
                    // build a color map as your need.
                    var colorList = [
                      '#C1232B', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                      '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
                      '#D7504B', '#C6E579', '#F4E001', '#F0805A', '#26C0C0'
                    ];
                    return colorList[params.dataIndex % 9]
                  },
                }
              },
            },
          ]
        };
        _self.myEchart1.setOption(option1)

        _self.myEchart2 = echarts.init(document.getElementById("numberEveryRegion"), "macarons");
        let option2 = {
          title: {},
          tooltip: {
            trigger: 'axis'
          },
          legend: {},
          toolbox: {},
          calculable: true,
          xAxis: [
            {
              type: 'category',
              show: true,
              data: Array.from(_self.numberEveryRegion.keys())
            }
          ],
          yAxis: [
            {
              type: 'value',
              show: true,
            }
          ],
          series: [
            {
              type: 'bar',
              data: Array.from(_self.numberEveryRegion.values()),
              itemStyle: {
                normal: {
                  //好，这里就是重头戏了，定义一个list，然后根据所以取得不同的值，这样就实现了，
                  color: function (params) {
                    // build a color map as your need.
                    var colorList = [
                      '#C1232B', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                      '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
                      '#D7504B', '#C6E579', '#F4E001', '#F0805A', '#26C0C0'
                    ];
                    return colorList[params.dataIndex % 9]
                  },
                }
              },
            },
          ]
        };
        _self.myEchart2.setOption(option2);
      }).catch(function () {
      }).finally(function () {
        _self.loading = false;
      });

    }
  }
</script>

<style scoped>
  #charts {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }

  /*a{*/
  /*text-decoration: none;*/
  /*color: green;*/
  /*}*/
</style>
