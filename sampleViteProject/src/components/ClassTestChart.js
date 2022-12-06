import { defineComponent, h } from 'vue'
import { Pie, Bar, Line, Bubble, PolarArea, Doughnut, Radar, Scatter } from 'vue-chartjs'
import { Chart, registerables } from 'chart.js'
Chart.register(...registerables)

export default defineComponent({
  name: 'classTestChart',
  components: {
    Bar, Pie
  },
  props: {
    chartClass: {
      type: Object
    }
  },
  setup (props) {
    let type = null;
    if (props.chartClass.getType() === Bar) {
      type = Pie;
    } else {
      type = Bar
    }

    const chartData = {
      labels: props.chartClass.labels,
      datasets: [{
        label: props.chartClass.label,
        data: props.chartClass.data,
        backgroundColor: props.chartClass.backgroundColor
      }]
    }

    console.dir(chartData)

    console.log(props.chartClass)
    return () => {
      h(props.chartClass.type, {
        chartData,
        chartOptions: props.chartClass.chartOptions,
        chartId: props.chartClass.chartId,
        width: props.chartClass.width,
        height: props.chartClass.height,
        cssClasses: props.chartClass.cssClasses,
        styles: props.chartClass.styles
      })
    }
  }

})
