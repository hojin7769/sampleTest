<template>
  <div>
    <PieChart :dataset = dataset />
  </div>
</template>

<script setup>
import PieChart from '../components/PIEChart'
import { reactive, ref } from 'vue'
import axios from 'axios'

const dataset = reactive({
  labels: [
    'Red',
    'Blue',
    'Yellow'
  ],
  datasets: [
    {
      label: 'My First Dataset',
      data: [300, 50, 100],
      backgroundColor: [
        'rgb(255, 99, 132)',
        'rgb(54, 162, 235)',
        'rgb(255, 205, 86)'
      ],
      hoverOffset: 4
    }
  ]
})
const data = ref()
const search = () => {
  const param = {
    chart_id: 'chart01'
  }
  axios.post('/api/chartMng/search', param).then(res => {
    data.value = res.data
    console.log(data.value)
  })
}

search()

</script>
