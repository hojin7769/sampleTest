<template>
  <div style="display: flex; width: 1000px; flex-direction: row">
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
      <ChartDrawCompVue
        :data="totalData.data"
        :label="totalData.label"
        :type="type"
        v-if="flog"
        ref="testChart"
      />
    </div>
  </div>
</template>
<script setup>
import { reactive, ref } from "@vue/reactivity";
import { onBeforeMount, onMounted } from "@vue/runtime-core";
import axios from "axios";
import ChartDrawCompVue from "../components/ChartDrawComp.vue";

const data = ref();
const flog = ref(false);
const totalData = reactive({
  label: [],
  data: [],
});
const chart_id = ref("chart01");
const testChart = ref();
const options = reactive([]);
const type = ref("bar");
const model = ref({ label: "Bar", value: "CHART01" });

const search = () => {
  const param = {
    chart_id: chart_id.value,
  };
  axios.post("/api/chartMng/search", param).then((res) => {
    data.value = res.data;
    if (res.data.result[0].CHART_SHAPE === "Bar") {
      type.value = "bar";
    } else {
      type.value = "pie";
    }
  });
};
const detail = () => {
  const param = {
    chart_id: chart_id.value,
  };
  let labels = [];
  let datas = [];
  axios.post("/api/chartMng/detail", param).then((res) => {
    res.data.forEach((element) => {
      labels.push(element.c_LABEL);
      datas.push(element.c_VALUE);
    });
    totalData.label = labels;
    totalData.data = datas;
    flog.value = true;
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
search();
detail();
selectBoxSearch();
const test = (newValue) => {
  chart_id.value = newValue.value;
  testChart.value.getCanvas();
  search();
  detail();
  // testChart.value.drawChartInCanvas(
  //   testChart.value.getCanvas(),
  //   totalData.data,
  //   totalData.label
  // );
};
</script>
<style scoped></style>
