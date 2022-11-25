import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import App from '../App.vue'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import ChartAbout from '../views/ChartAbout.vue'
import ChartLine from '../components/LineChart.vue'

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/about', name: 'about', component: About },
  { path: '/chart', name: 'chart', component: ChartAbout },
  { path: '/chart1', name: 'chart1', component: ChartLine }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})
export default router
