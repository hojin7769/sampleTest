<template>
  <div id="div1223">
    <button @click="changeValue('pie')">test</button>
    <canvas id="canvasChart" width="500" height="500"></canvas>
  </div>
</template>
<script setup>
import { Chart } from "chart.js";
import { onMounted, ref } from "vue";

Chart.defaults.set("plugins.datalabels", {
  color: "#FE777B",
});

const typeChart = ref("bar");
const myChart = ref(null);
onMounted(() => {
  // alwaysShowTooltip plugins block
  const ctx = document.getElementById("canvasChart");
  makeChart(ctx);
});

function makeChart(mycanvas, data, labels) {
  const alwaysShowTooltip = {
    id: "alwaysShowTooltip",
    afterDraw(chart, args, options) {
      const { ctx } = chart;
      ctx.save();
      chart.data.datasets.forEach((dataset, i) => {
        chart.getDatasetMeta(i).data.forEach((datapoint, index) => {
          const { x, y } = datapoint.tooltipPosition();

          //const text = ;
          const text =
            chart.data.labels[index] +
            " : " +
            chart.data.datasets[i].data[index];

          const textWidth = ctx.measureText(text).width;

          ctx.fillStyle = "rgba(0,0,0,0.8)";
          const width = 20;
          ctx.fillRect(x - (textWidth + 10) / 2, y - 25, textWidth + 10, 20);
          // x,y,w,h

          // triangle
          ctx.fillStyle = "rgba(0,0,0,0.8)";
          ctx.beginPath();
          ctx.moveTo(x, y);
          ctx.lineTo(x - 5, y - 5);
          ctx.lineTo(x + 5, y - 5);
          ctx.fill();
          ctx.restore();

          //text
          ctx.font = "12px Arial";
          ctx.fillStyle = "white";
          ctx.fillText(text, x - textWidth / 2, y - 11);
          ctx.restore();
        });
      });
    },
  };
  const ctx = mycanvas.getContext("2d");
  myChart.value = new Chart(ctx, {
    type: typeChart.value,
    data: {
      labels: ["Red", "Blue", "Yellow", "Green", "Purple", "Orange"],
      datasets: [
        {
          label: "# of Votes",
          data: [12, 19, 3, 5, 2, 3],
          backgroundColor: [
            "rgba(255, 99, 132, 0.2)",
            "rgba(54, 162, 235, 0.2)",
            "rgba(255, 206, 86, 0.2)",
            "rgba(75, 192, 192, 0.2)",
            "rgba(153, 102, 255, 0.2)",
            "rgba(255, 159, 64, 0.2)",
          ],
          borderColor: [
            "rgba(255, 99, 132, 1)",
            "rgba(54, 162, 235, 1)",
            "rgba(255, 206, 86, 1)",
            "rgba(75, 192, 192, 1)",
            "rgba(153, 102, 255, 1)",
            "rgba(255, 159, 64, 1)",
          ],
          borderWidth: 1,
        },
      ],
    },
    options: {
      plugins: {
        title: {
          display: true,
          text: "하자기간 차트",
          padding: {
            top: 10,
            bottom: 30,
          },
        },
        tooltip: {
          enabled: false,
        },
        legend: {
          display: false,
        },
      },
    },
    plugins: [alwaysShowTooltip],
  });
}

function changeValue(value) {
  typeChart.value = value;
  myChart.value.destroy();
  const ctx = document.getElementById("canvasChart");
  makeChart(ctx);
}
</script>
