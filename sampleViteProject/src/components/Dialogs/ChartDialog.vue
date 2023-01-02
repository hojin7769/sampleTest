<script setup>
import PieChart from '../PIEChart.js';
import colorArray from '../../utils/chart/Plugins/ColorArray.js'
import { ref, reactive } from 'vue';

const props = defineProps(['dialog', 'data', 'type'])
defineEmits(['closeDialog'])
const datas = ref([]);
const label = ref([]);
const backColor = ref([]);
(() => {
  props.data.map((s) => {
    datas.value.push(s.value)
    label.value.push(s.nm_CATEGORY)
  })

  datas.value.forEach((data, i) => {
    backColor.value.push(colorArray[i])
  })
})()
const dataset = reactive({
  labels: label.value,
  datasets: [{
    label: '차트',
    data: datas.value,
    backgroundColor: backColor.value,
    datalabels: { anchor: 'center' }
  }]
});

</script>
<template>
  <q-dialog v-model="props.dialog">
    <q-card >
      <q-card-section>
        <div class="text-h6">Chart</div>
      </q-card-section>

      <q-card-section class="q-pt-none">
        <PieChart :dataset="dataset" :type="type" />
      </q-card-section>
      <q-card-actions align="right" class="bg-white text-teal">
        <q-btn flat label="OK" @click="$emit('closeDialog')" />
      </q-card-actions>
    </q-card>
  </q-dialog>
</template>
