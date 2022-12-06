<template>
  <ChartDrawCompVue
    :data="totalData.data"
    :label="totalData.label"
    v-if="flog"
  />
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

const search = () => {
  const param = {
    chart_id: chart_id.value,
  };
  axios.post("/api/chartMng/search", param).then((res) => {
    data.value = res.data;
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
detail();
</script>
<style scoped></style>
