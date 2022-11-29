import { defineComponent, h } from 'vue'

import { Pie, Bar, Line, Bubble, PolarArea, Doughnut, Radar, Scatter } from 'vue-chartjs'

import { Chart, registerables } from 'chart.js'

Chart.register(...registerables)

export default defineComponent({
  name: 'PieChart',
  components: {
    Bar, Pie
  },
  props: {
    chartId: {
      type: String,
      default: 'pie-chart'
    },
    width: {
      type: Number,
      default: 400
    },
    height: {
      type: Number,
      default: 400
    },
    cssClasses: {
      default: '',
      type: String
    },
    styles: {
      type: Object,
      default: () => {}
    },
    dataset: {
      type: Object,
      default: () => {
      }
    },
    type: {
      type: Object,
      default: Bar
    }
  },
  setup (props) {
    const chartData = {
      labels: props.dataset.labels,
      datasets: props.dataset.datasets
    }

    const chartOptions = {
      responsive: true,
      maintainAspectRatio: false,
      plugins: {
        title: {
          display: true,
          text: '하자기간 차트',
          padding: {
            top: 10,
            bottom: 30
          }
        }
      }
    }

    return () =>
      h(props.type, {
        chartData,
        chartOptions,
        chartId: props.chartId,
        width: props.width,
        height: props.height,
        cssClasses: props.cssClasses,
        styles: props.styles
      })
  }
})
