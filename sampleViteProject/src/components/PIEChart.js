import { defineComponent, h } from "vue";
import ChartDataLabels from "chartjs-plugin-datalabels";

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

import { Chart, registerables } from "chart.js";

Chart.register(ChartDataLabels, ...registerables);

export default defineComponent({
  name: "PieChart",
  components: {
    Bar,
    Pie,
  },
  props: {
    chartId: {
      type: String,
      default: "pie-chart",
    },
    width: {
      type: Number,
      default: 400,
    },
    height: {
      type: Number,
      default: 400,
    },
    cssClasses: {
      default: "",
      type: String,
    },
    styles: {
      type: Object,
      default: () => {},
    },
    dataset: {
      type: Object,
      default: () => {},
    },
    type: {
      type: String,
    },
  },
  setup(props) {
    const chartData = {
      labels: props.dataset.labels,
      datasets: props.dataset.datasets,
    };
    const chartOptions = {
      responsive: false,
      maintainAspectRatio: false,
      plugins: {
        title: {
          display: true,
          text: "하자기간 차트",
          padding: {
            top: 10,
            bottom: 30,
          },
        },
        legend: {
          display: false,
        },
        datalabels: {
          backgroundColor: function (context) {
            return context.dataset.backgroundColor;
          },
          borderColor: "white",
          borderRadius: 30,
          borderWidth: 2,
          color: function (context) {
            return "white";
          },
          font: {
            weight: "normal",
          },
          listeners: {
            enter: function (context) {
              context.hovered = true;
              return true;
            },
            leave: function (context) {
              context.hovered = false;
              return true;
            },
          },
          display: true,
          formatter: function (value, context) {
            // let sum = 0;
            // let valueArr = chartData.datasets[0].data;

            // for (var i in valueArr) {
            //   sum += parseInt(valueArr[i]);
            // }

            // let percentage = +((value * 100) / sum).toFixed(2) + "%";
            // return percentage;
            var idx = context.dataIndex;
            // 여기선 첫번째 데이타엔 단위를 '원' 으로, 그 다음 데이타엔 'P' 를 사용
            // addComma() 는 여기서 기술하지 않았지만, 천단위 세팅. ChartJS 의 data 엔 숫자만 입력
            return context.chart.data.labels[idx];
          }.bind(this),
        },
      },
    };

    return () =>
      h(props.type === "pie" ? Pie : Bar, {
        chartData,
        chartOptions,
        chartId: props.chartId,
        width: props.width,
        height: props.height,
        cssClasses: props.cssClasses,
        styles: props.styles,
      });
  },
});
