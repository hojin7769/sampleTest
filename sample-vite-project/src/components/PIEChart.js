import { defineComponent, h } from 'vue'

import { Bar, Pie } from 'vue-chartjs'

import { Chart, registerables } from 'chart.js'

Chart.register(...registerables)

export default defineComponent({
  name: 'PieChart',
  components: {
    Pie
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
    }
  },
  setup (props) {
    const chartData = {
      labels: props.dataset.labels,
      datasets: props.dataset.datasets,
      options: {
        plugins: {
          datalabels: {
            align: 'center',
            formatter: function (value, context) {
              // data 에 넣은 데이타 순번. 물론 0 부터 시작

              const idx = context.dataIndex

              // 여기선 첫번째 데이타엔 단위를 '원' 으로, 그 다음 데이타엔 'P' 를 사용

              // addComma() 는 여기서 기술하지 않았지만, 천단위 세팅. ChartJS 의 data 엔 숫자만 입력

              return context.chart.data.labels[idx]
            }
          }
        }
      }
    }

    const chartOptions = {
      responsive: true,
      maintainAspectRatio: false
    }

    return () =>
      h(Pie, {
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
