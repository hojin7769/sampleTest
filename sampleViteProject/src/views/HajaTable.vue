<template>
  <div style="display: flex; flex-direction: row; column-gap: 20px; width: 100vw">
<!--    <input type="text" id="input1" value="ABCD"/>-->
<!--    <input type="text" id="input2" value="1234"/>-->
<!--    <button @click="changeText"> 클릭 </button>-->
  <div style="flex:1">
      <q-table
        :rows = data
        :columns  = colums
        row-key="name"
        hide-pagination
        :rows-per-page-options="[0]"
        virtual-scroll
        style="height: 400px; width: 500px"
      />
  </div>
  <div style="flex:1">
    <q-table
        :rows = chartData
        :columns  = chCoulums
        row-key="name"
        hide-pagination
        :rows-per-page-options="[0]"
        virtual-scroll
        style="height: 400px; width: 500px"
    />
  </div>

  </div>
  <q-btn @click="openDialog()">차트로 보기</q-btn>
  <ChartDialog :dialog="dialog" :data = "chartData" @closeDialog="closeDialog()" v-if="dialog"/>
</template>

<script setup>
import ChartDialog from '../components/Dialogs/ChartDialog.vue'
import { ref } from 'vue';
import tableColum from '../utils/list/ChartListColum.js';
import axios from 'axios';

const dialog = ref(false)
const data = ref();
const chartData = ref();
const colums = ref(tableColum.hajaTable);
const chCoulums = ref(tableColum.hajaChart);
const test = () => {
  axios.post('/api/hajaTable/select').then(res => {
    data.value = res.data.result
  })
}

const charttable = () => {
  axios.post('/api/hajaTable/chartAll').then(res => {
    console.dir(res.data.result)
    chartData.value = res.data.result
  })
}

function openDialog () {
  dialog.value = true;
}

function changeText () {
  const text1 = document.getElementById('input1');
  const text2 = document.getElementById('input2');

  const temp = text1.value;
  text1.value = text2.value;
  text2.value = temp;
}
function closeDialog () {
  dialog.value = false
}
test()
charttable()
</script>

<style scoped>

</style>
