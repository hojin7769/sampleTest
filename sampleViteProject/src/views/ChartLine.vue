<template>
  <div id="div1223" >
    <canvas id = 'canvasChart' width="500" height="500"></canvas>
  </div>

</template>
<script setup>
import { Chart } from 'chart.js';
import { onMounted } from 'vue';

Chart.defaults.set('plugins.datalabels', {
  color: '#FE777B'
});

onMounted(() => {
  const ctx = document.getElementById('canvasChart').getContext('2d')
  const chart = new Chart(ctx, {
    data: {
      datasets: [
        {
          fill: {
            target: 'origin',
            above: 'rgb(255, 0, 0)', // Area will be red above the origin
            below: 'rgb(0, 0, 255)' // And blue below the origin
          }
        }
      ]
    }
  });
})
</script>
