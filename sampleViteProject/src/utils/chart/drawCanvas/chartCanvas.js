import Plugin, { Chart, registerables } from 'chart.js'

Chart.register(Plugin, ...registerables)

const ctx = document.createElement('canvas').getContext('2d')

Chart.plugins.register({
  beforeRender (chart, args, options) {
    if (chart.config.options.showAllToolips) {

    }
  }
})

const chartFixedTooltips = new Chart(ctx, {
  type: 'pie',
  data: {
    labels: ['January', 'February', 'March', 'April'],
    datasets: [{
      label: 'Chart One',
      backdropColor: 'rgba(183,183,183,0.6',
      data: [0, 10, 50, 90]
    }]
  },
  animation: {
    animateScale: true,
    animateRotate: true
  },
  options: {
    responsive: true,
    legend: {
      display: false
    },
    scales: {
      yAxes: [{
        ticks: {
          min: 0,
          max: 100,
          stepSize: 20
        }
      }]
    },
    scaleShowLabelBackdrop: true,
    showAllTooltips: true,
    tooltips: {
      displayColors: false,
      callbacks: {
        title: function (tooltipItem, data) {

        },
        label: function (tooltipItem, data) {
          // eslint-disable-next-line dot-notation
          return data[' labels'][tooltipItem[' index']] + ':' + data['datasets'][0][' data'][tooltipItem[' index']];
        }
      }
    }

  }
})
