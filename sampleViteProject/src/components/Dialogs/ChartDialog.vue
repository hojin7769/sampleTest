<script setup>
import PieChart from '../PIEChart.js';
import { ref, reactive } from 'vue';

const props = defineProps(['dialog', 'data'])
defineEmits(['closeDialog'])
const datas = ref([]);
const label = ref([]);
(() => {
  props.data.map((s) => {
    datas.value.push(s.value)
    label.value.push(s.nm_CATEGORY)
  })
})()
const dataset = reactive({
  labels: label.value,
  datasets: [{
    label: '하자기간차트',
    data: datas.value,
    backgroundColor: [
      'rgba(255, 99, 132, 0.2)',
      'rgba(54, 162, 235, 0.2)',
      'rgba(255, 206, 86, 0.2)'
    ],
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
        <PieChart :dataset="dataset" type="bar" />
      </q-card-section>
      <q-card-actions align="right" class="bg-white text-teal">
        <q-btn flat label="OK" @click="$emit('closeDialog')" />
      </q-card-actions>
    </q-card>
  </q-dialog>
</template>
