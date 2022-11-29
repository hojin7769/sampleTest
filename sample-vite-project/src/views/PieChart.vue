<template>
  <div>
    <PieChart :dataset = dataset />
  </div>
  {{dataset.datasets.label}}
</template>

<script setup>
import PieChart from '../components/PIEChart'
import { reactive, ref } from 'vue'
import axios from 'axios'

const data = ref()
const dataset = reactive({
  labels: [],
  datasets: []
})
const search = () => {
  const param = {
    chart_id: 'chart01'
  }
  axios.post('/api/chartMng/search', param).then(res => {
    data.value = res.data
    console.log(data.value)
  })
}

const detail = () => {
  const param = {
    chart_id: 'chart01'
  }
  axios.post('/api/chartMng/detail', param).then(res => {
    const data12 = {
      label: 'Data One',
      data: [],
      backgroundColor: [
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

    }
    res.data.map((t) => {
      dataset.labels.push(t.c_LABEL)
      data12.data.push(t.c_VALUE)
    }
    )
    dataset.datasets.push(data12)
  })
}
search()
detail()

console.log(dataset)

</script>
