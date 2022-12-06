import { defineComponent, h } from "vue";
import { Pie } from "vue-chartjs";

import { Chart, registerables } from "chart.js";

Chart.register(...registerables);

export default defineComponent({
  name: "BarChart",
  components: {
    Pie,
  },
  props: {
    chartId: {
      type: String,
      default: "bar-chart",
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
  },
  setup(props) {
    const chartData = {
      labels: ["January", "February", "March", "April", "May", "June", "July"],
      datasets: [
        {
          label: "Data One",
          backgroundColor: "#f87979",
          data: [40, 20, 12, 39, 10, 40, 39, 80, 40, 20, 12, 11],
        },
      ],
    };

    const chartOptions = {
      responsive: true,
      maintainAspectRatio: false,
      showAllTooltips: true,
      scaleShowLabelBackdrop: true,
      plugins: {
        title: {
          display: true,
          text: "하자기간 차트",
          padding: {
            top: 10,
            bottom: 30,
          },
        },
        labels: {
          display: true,
          render: (args) => {
            return args;
          },
        },
      },
    };
    return () =>
      h(Pie, {
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
