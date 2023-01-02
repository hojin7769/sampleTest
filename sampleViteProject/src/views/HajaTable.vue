<template>
  <div style="display: flex;flex-direction: column">
    <div style="display: flex; flex-direction: row; column-gap:5px; width: 100vw; flex:1 ;">
  <!--    <input type="text" id="input1" value="ABCD"/>-->
  <!--    <input type="text" id="input2" value="1234"/>-->
    <!--    <button @click="changeText"> 클릭 </button>-->
      <div style="flex:1;max-width: 500px">
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
      <div style="flex:1;max-width: 500px">
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
    <div style="flex:1; display: flex; align-items: center;justify-content: left; column-gap: 10px " class="q-ma-lg">
      <div class="q-gutter-md"  style="max-width: 300px;flex: 1">
        <q-select
            standout
            label="Standout"
            :options="options"
            v-model="model"
        />
      </div>
      <div style="flex: 1;max-width: 120px" >
        <q-btn @click="openDialog()">차트로 보기</q-btn>
      </div>
    </div>
  </div>
    <ChartDialog :dialog="dialog" :data = "chartData" @closeDialog="closeDialog()" v-if="dialog" :type="model.value"/>
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
const model = ref();
const chCoulums = ref(tableColum.hajaChart);

const options = ref([
  { label: 'Bar', value: 'bar' }, { label: 'Pie', value: 'pie' }, { label: 'Line', value: 'line' }
])
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
