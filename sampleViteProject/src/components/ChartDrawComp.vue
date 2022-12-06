<template>
  <div id="tt">
    <canvas id="myChart"></canvas>
  </div>
</template>
<script setup>
import { onMounted } from "@vue/runtime-core";
import { Chart } from "chart.js";
const props = defineProps(["data", "label"]);

onMounted(() => {
  const canvas = document.getElementById("myChart");
  drawChartInCanvas(canvas, props.data, props.label);
});

function drawChartInCanvas(canvas, data, label) {
  const alwaysShowTooltip = {
    id: "alwaysShowTooltip",
    afterDraw(chart, args, options) {
      const { ctx } = chart;
      ctx.save();
      chart.data.datasets.forEach((dataset, i) => {
        chart.getDatasetMeta(i).data.forEach((datapoint, index) => {
          const { x, y } = datapoint.tooltipPosition();

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
  const ctx = canvas.getContext("2d");
  const myChart = new Chart(ctx, {
    type: "pie",
    data: {
      labels: label,
      datasets: [
        {
          label: "# of Votes",
          data: data,
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
      responsive: false,
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
        labels: {
          render: (arg) => {
            return arg;
          },
        },
      },
    },
    plugins: [alwaysShowTooltip],
  });
}
</script>
<style>
canvas {
  display: block;
  width: 500px;
  height: 500px;
}
</style>
