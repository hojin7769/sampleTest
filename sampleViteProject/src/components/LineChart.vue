<template>
  <div>
    <Line
        :chartData="chart.data"
    ></Line>
  </div>
</template>
<script>
import '../utils/chart/global.js'
import { Line } from 'vue-chartjs'

export default {
  name: 'line-chart',
  type: 'line',
  components: {
    // eslint-disable-next-line vue/no-reserved-component-names
    Line
  },
  data () {
    return {
      chart: {
        data: {
          labels: [2014, 2015, 2016, 2017, 2018, 2019, 2020, 2021, 2022, 2023],
          datasets: [
            {
              label: '인원수',
              backgroundColor: 'rgb(255,153,204, 0.5)',
              pointBackgroundColor: 'hotpink',
              fill: true,
              tension: 0.1,
              borderColor: 'hotpink',
              pointBorderColor: 'hotpink',
              borderWidth: 1,
              pointBorderWidth: 1,
              data: [450, 300, 100, 1000, 750, 600, 900, 1500, 1200, 2000]
            }
          ]
        },
        options: {
          plugins: {
            legend: {
              display: true,
              position: 'left',
              labels: {
                boxWidth: 8,
                padding: 10,
                usePointStyle: true,
                pointStyle: 'circle',
                font: {
                  size: 14
                }
              },
              fullSize: true,
              align: 'center'
            },
            tooltip: {
              boxWidth: 15,
              bodyFont: {
                size: 14
              }
            }
          },
          scales: {
            x: {
              grid: {
                display: false
              },
              ticks: {
                padding: 3
              }
            },
            y: {
              ticks: {
                callback: (val, index) => {
                  return val !== 0 ? val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',') : ''
                },
                padding: 10
              },
              grid: {
                drawBorder: false,
                color: '#323232',
                lineWidth: 1
              }
            }
          },
          responsive: true,
          maintainAspectRatio: false,
          animation: {
            duration: 5000
          }
        }
      }
    }
  }
}
</script>
