import { createApp } from 'vue'
import { createRouter, createWebHashHistory, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import ChartAbout from '../views/ChartAbout.vue'
import ChartLine from '../components/LineChart.vue'

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/about', name: 'about', component: About },
  { path: '/chart', name: 'chart', component: ChartAbout },
  { path: '/chart1', name: 'chart1', component: ChartLine },
  { path: '/pieChart', name: 'pieChart', component: () => import('../views/PieChart.vue'), props: true }
]

// create history
const router = createRouter({
  history: createWebHashHistory(),
  routes
})
export default router
