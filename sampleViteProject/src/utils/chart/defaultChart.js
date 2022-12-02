import { defineComponent, h } from 'vue'
import { Pie, Bar, Line, Bubble, PolarArea, Doughnut, Radar, Scatter } from 'vue-chartjs'
import { Chart, registerables } from 'chart.js'
Chart.register(...registerables)
