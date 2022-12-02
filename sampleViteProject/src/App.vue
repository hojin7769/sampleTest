<script setup>
// This starter template is using Vue 3 <script setup> SFCs
// Check out https://vuejs.org/api/sfc-script-setup.html#script-setup
</script>
<template>
  <q-layout view="hHh lpR fFf">

    <q-header elevated class="bg-primary text-white" height-hint="98">
      <q-toolbar align="left">
        <q-toolbar-title>
          my-first-site
        </q-toolbar-title>

        <q-space />

        <q-btn round icon="notifications" color="black" flat dense>
          <q-badge floating color="red" rounded flat dense/>
        </q-btn>
        <q-btn flat round dense icon="more_vert" />
      </q-toolbar>

      <q-tabs align="left">
        <q-route-tab to="/" label="Page One" />
        <q-route-tab to="/about" label="Page Two" />
        <q-route-tab to="/chart" label="Page Three" />
        <q-route-tab to="/chart1" label="Page chart" />
        <q-route-tab to="/pieChart" label="Pie Chart" />
        <q-route-tab to="/classChart" label="Class Chart" />
        <q-route-tab to="/chartLine" label="Class Line" />
      </q-tabs>
    </q-header>

    <q-page-container>
      <router-view />
    </q-page-container>

    <q-footer elevated class="bg-grey-8 text-white">
      <q-toolbar>
        <q-toolbar-title>
          <q-avatar>
            <img src="https://cdn.quasar.dev/logo-v2/svg/logo-mono-white.svg">
          </q-avatar>
          <div>Title</div>
        </q-toolbar-title>
      </q-toolbar>
    </q-footer>

  </q-layout>
</template>
<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
