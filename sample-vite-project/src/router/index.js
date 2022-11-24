import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import App from '../App.vue'
import Home from '../views/Home.vue'
import About from '../views/About.vue'

const routes = [
  { path: '/', name: 'Home', component: Home },
  { path: '/about', name: 'about', component: About }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})
export default router
