<template>
  <div >
      <component :is="componentFile" :chartClass ='mychart' />
  </div>
</template>
<script setup>
import ClassTestChart from '../components/ClassTestChart.js';
import Mychart from '../utils/chart/global.js';
import axios from 'axios';
import { Pie, Bar, Line, Bubble, PolarArea, Doughnut, Radar, Scatter } from 'vue-chartjs'
import { computed, defineAsyncComponent, ref } from 'vue';

const chart_id = ref('chart01')
const mychart = new Mychart();
const data = ref()
const search = () => {
  const param = {
    chart_id: chart_id.value
  }
  axios.post('/api/chartMng/search', param).then(res => {
    data.value = res.data
    if (res.data.chartshape === 'Bar') {
      mychart.type = Bar
    } else {
      mychart.type = Pie
    }
    mychart.label = data.value.chartdesc
  })
}

const detail = () => {
  const param = {
    chart_id: chart_id.value
  }
  const labels = []
  const data = []
  axios.post('/api/chartMng/detail', param).then(res => {
    res.data.map((t) => {
      labels.push(t.c_LABEL)
      data.push(t.c_VALUE)
    }
    )
    mychart.data = data
    mychart.labels = labels
  })
}
mychart.backgroundColor = [
  'red',
  'blue',
  'yellow',
  'green',
  'gray',
  'black',
  'pink',
  'orange',
  'skyblue',
  'purple',
  'Yellowgreen',
  'Navy'
]
mychart.chartOptions = {
  responsive: true,
  maintainAspectRatio: false,
  plugins: {
    title: {
      display: true,
      text: '하자기간 차트',
      padding: {
        top: 10,
        bottom: 30
      }
    }
  }
}
search()
detail()
const componentFile = computed(() => {
  return defineAsyncComponent({
    loader: () => import('../components/ClassTestChart.js'),
    delay: 200,
    timeout: 3000
  })
})
</script>

<style scoped>

</style>
