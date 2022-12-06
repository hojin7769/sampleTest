<template>
  <div style="display: flex; width: 700px; flex-direction: row">
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
    </div>
    <div style="flex: 1">
      <PieChart :dataset="dataset" :type="type" />
    </div>
  </div>
</template>

<script setup>
import PieChart from "../components/PIEChart";
import { reactive, ref } from "vue";
import axios from "axios";
import {
  Pie,
  Bar,
  Line,
  Bubble,
  PolarArea,
  Doughnut,
  Radar,
  Scatter,
} from "vue-chartjs";
const data = ref();
const chart_id = ref("chart01");
const type = ref(Pie);
const dataset = reactive({
  labels: [],
  datasets: [],
});
const options = reactive([]);
const model = ref();

const search = () => {
  const param = {
    chart_id: chart_id.value,
  };
  axios.post("/api/chartMng/search", param).then((res) => {
    data.value = res.data;
    if (res.data.chartshape === "Bar") {
      type.value = Bar;
    } else {
      type.value = Pie;
    }
  });
};
const detail = () => {
  dataset.labels = [];
  dataset.datasets = [];
  const param = {
    chart_id: chart_id.value,
  };
  axios.post("/api/chartMng/detail", param).then((res) => {
    const data12 = {
      label: "하자기간차트",
      data: [],
      backgroundColor: [
        "red",
        "blue",
        "yellow",
        "green",
        "gray",
        "black",
        "pink",
        "orange",
        "skyblue",
        "purple",
        "Yellowgreen",
        "Navy",
      ],
    };

    res.data.map((t) => {
      dataset.labels.push(t.c_LABEL);
      data12.data.push(t.c_VALUE);
    });
    dataset.datasets.push(data12);
  });
};

const selectBoxSearch = () => {
  axios.post("/api/chartMng/selectBoxSearch").then((res) => {
    console.log(res.data);
    res.data.map((t) => {
      options.push({
        label: t.chartshape,
        value: t.chartid,
      });
    });
  });
};
const test = (newValue) => {
  chart_id.value = newValue.value;
  search();
  detail();
};

search();
detail();
selectBoxSearch();
</script>
