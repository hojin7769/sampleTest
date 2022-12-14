import { createApp } from 'vue';
import {
  createRouter,
  createWebHashHistory,
  createWebHistory
} from 'vue-router';
import Home from '../views/Home.vue';
import About from '../views/About.vue';
import ChartAbout from '../views/ChartAbout.vue';
import ChartLine from '../components/LineChart.vue';

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/about', name: 'about', component: About },
  { path: '/chart', name: 'chart', component: ChartAbout },
  { path: '/chart1', name: 'chart1', component: ChartLine },
  {
    path: '/pieChart',
    name: 'pieChart',
    component: () => import('../views/PieChart.vue'),
    props: true
  },
  {
    path: '/classChart',
    name: 'classChart',
    component: () => import('../views/ClasstestChart.vue'),
    props: true
  },
  {
    path: '/chartLine',
    name: 'chartLine',
    component: () => import('../views/ChartLine.vue'),
    props: true
  },
  {
    path: '/drawchart',
    name: 'drawchart',
    component: () => import('../views/DrawChart.vue'),
    props: true
  }, {
    path: '/hajaTable',
    name: 'hajaTable',
    component: () => import('../views/HajaTable.vue'),
    props: true
  }
];

// create history
const router = createRouter({
  history: createWebHashHistory(),
  routes
});
export default router;
