<template>
  <div
    style="display: flex; width: 100vw; flex-direction: row; column-gap: 10%"
  >
    <div class="q-pa-md" style="max-width: 300px; flex: 1">
      <div class="q-gutter-md">
        <q-select
          standout
          v-model="model"
          :options="options"
          label="Standout"
          @update:model-value="test"
        />
      </div>
      <div>
        <PieChart :dataset="dataset" :type="type" ref="test1" />
      </div>
    </div>
    <div style="max-width: 500px; flex: 1">
      <div class="q-pa-md">
        <q-table
          title="하자통계"
          :rows="colums"
          :columns="rows"
          row-key="index"
          hide-pagination
          rows-per-page-options="0"
          virtual-scroll
          style="height: 400px"
        />
      </div>
    </div>
  </div>
</template>

<script setup>
import PieChart from '../components/PIEChart';
import { reactive, ref } from 'vue';
import axios from 'axios';
import { getColumList } from '../utils/list/ChartTableList';
import {
  Pie,
  Bar,
  Line,
  Bubble,
  PolarArea,
  Doughnut,
  Radar,
  Scatter
} from 'vue-chartjs';
const data = ref();
const colums = ref();
const chart_id = ref('chart01');
const type = ref('');
const dataset = reactive({
  labels: [],
  datasets: []
});
const rows = ref();
rows.value = getColumList();
const options = reactive([]);
const model = ref();
const test1 = ref();
const search = () => {
  const param = {
    chart_id: chart_id.value
  };
  axios.post('/api/chartMng/search', param).then((res) => {
    data.value = res.data;

    if (res.data.result[0].CHART_SHAPE === 'Bar') {
      type.value = 'bar';
    } else {
      type.value = 'pie';
    }
  });
};
const detail = () => {
  dataset.labels = [];
  dataset.datasets = [];
  const param = {
    chart_id: chart_id.value
  };
  axios.post('/api/chartMng/detail', param).then((res) => {
    const data12 = {
      label: '하자기간차트',
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
      ],
      datalabels: { anchor: 'end' }
    };
    colums.value = res.data;
    console.dir(colums.value);
    res.data.map((t) => {
      dataset.labels.push(t.c_LABEL);
      data12.data.push(t.c_VALUE);
    });
    dataset.datasets.push(data12);
  });
};

const selectBoxSearch = () => {
  axios.post('/api/chartMng/selectBoxSearch').then((res) => {
    console.log(res.data);
    res.data.map((t) => {
      options.push({
        label: t.chartshape,
        value: t.chartid
      });
    });
  });
};

const test = (newValue) => {
  chart_id.value = newValue.value;
  console.dir(test1);
  search();
  detail();
};

search();
detail();
selectBoxSearch();
</script>

<style scoped>
table tr th,
td {
  border: 1px solid black;
}
</style>
