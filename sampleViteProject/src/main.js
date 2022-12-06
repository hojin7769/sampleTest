import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router/index.js'
import { Quasar } from 'quasar'

// Import icon libraries
import '@quasar/extras/material-icons/material-icons.css'
// Import Quasar css
import 'quasar/src/css/index.sass'

import { createPinia } from 'pinia'

const Vue = createApp(App);
const pinia = createPinia()
Vue.use(pinia).use(router).use(Quasar, {
  plugins: {} // import Quasar plugins and add here
}).mount('#app')
