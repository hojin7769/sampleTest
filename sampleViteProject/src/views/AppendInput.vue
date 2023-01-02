<script setup>
import { ref } from 'vue';
import axios from 'axios';

const tab = ref('mails');
const splitterModel = ref(20)
const category_id = ref()
const category_name = ref()
const category_desc = ref()

const table_TITLE = ref();
const table_content = ref();
const table_SEQ = ref();

const table_options = ref([]);

function categorySubmit () {
  const params = {
    ID_CATEGORY: category_id.value,
    NM_CATEGORY: category_name.value,
    DESC_CATEGORY: category_desc.value
  }
  axios.post('/api/hajaTable/save', params).then((res) => {
    alert('저장완료')
    location.reload();
  })
}
function categoryReset () {
  category_id.value = ''
  category_name.value = ''
  category_desc.value = ''
}

function changetTab (value) {
  if (value === 'alarms') {
    table_options.value = []
    axios.post('/api/hajaTable/selectCategory').then(res => {
      res.data.result.map((t) => {
        table_options.value.push({
          label: t.nm_CATEGORY,
          value: t.sn_SEQ
        })
      })
    })
  }
}

function hajaTableSubmit () {
  const params = {
    Title: table_TITLE.value,
    desc_content: table_content.value,
    seq_category: table_SEQ.value.value
  }
  axios.post('/api/hajaTable/saveHaja', params).then((res) => {
    alert('저장완료')
    location.reload();
  })
}

function hajaTableReset () {
  table_TITLE.value = ''
  table_content.value = ''
  table_SEQ.value = {}
}

</script>
<template>
  <div>
    <q-splitter
        v-model="splitterModel"
        style="height:60vh;width: 50vw"
    >

      <template v-slot:before>
        <q-tabs
            v-model="tab"
            vertical
            class="text-teal"
            @update:model-value="changetTab"
        >
          <q-tab name="mails" icon="category" label="카테고리" />
          <q-tab name="alarms" icon="edit_note" label="내용" />
          <q-tab name="movies" icon="movie" label="Movies" />
        </q-tabs>
      </template>

      <template v-slot:after>
        <q-tab-panels
            v-model="tab"
            animated
            swipeable
            vertical
            transition-prev="jump-up"
            transition-next="jump-up"
        >
          <q-tab-panel name="mails">
            <div class="text-h4 q-mb-md">추가</div>
              <div class="q-pa-md" >
                <div class="q-gutter-md"  >
                  <q-form
                      @submit="categorySubmit"
                      @reset="categoryReset"
                      class="q-gutter-md"
                  >
                    <q-input
                        v-model="category_id"
                        label="category_id"
                        lazy-rules
                        :rules="[ val => val && val.length > 0 || 'Please type something']"
                    />
                    <q-input
                        v-model="category_name"
                        label="category_name"
                        lazy-rules
                        :rules="[ val => val && val.length > 0 || 'Please type something']"
                    />
                  <q-input
                      v-model="category_desc"
                      filled
                      autogrow
                      label="desc"
                      lazy-rules
                      :rules="[ val => val && val.length > 0 || 'Please type something']"
                  />
                    <div>
                      <q-btn label="Submit" type="submit" color="primary"/>
                      <q-btn label="Reset" type="reset" color="primary" flat class="q-ml-sm" />
                    </div>
                  </q-form>
                </div>
              </div>
          </q-tab-panel>

          <q-tab-panel name="alarms">
            <div class="text-h4 q-mb-md">추가</div>
            <div class="q-pa-md" >
              <div class="q-gutter-md"  >
                <q-form
                    @submit="hajaTableSubmit"
                    @reset="hajaTableReset"
                    class="q-gutter-md"
                >
                  <q-input
                      v-model="table_TITLE"
                      label="table_TITLE"
                      lazy-rules
                      :rules="[ val => val && val.length > 0 || 'Please type something']"
                  />
                  <q-input
                      v-model="table_content"
                      label="table_content"
                      lazy-rules
                      :rules="[ val => val && val.length > 0 || 'Please type something']"
                  />
                  <q-select filled v-model="table_SEQ" :options="table_options" label="Filled" />
                  <div>
                    <q-btn label="Submit" type="submit" color="primary"/>
                    <q-btn label="Reset" type="reset" color="primary" flat class="q-ml-sm" />
                  </div>
                </q-form>
              </div>
            </div>
          </q-tab-panel>

          <q-tab-panel name="movies">
            <div class="text-h4 q-mb-md">Movies</div>
            <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Quis praesentium cumque magnam odio iure quidem, quod illum numquam possimus obcaecati commodi minima assumenda consectetur culpa fuga nulla ullam. In, libero.</p>
            <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Quis praesentium cumque magnam odio iure quidem, quod illum numquam possimus obcaecati commodi minima assumenda consectetur culpa fuga nulla ullam. In, libero.</p>
            <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Quis praesentium cumque magnam odio iure quidem, quod illum numquam possimus obcaecati commodi minima assumenda consectetur culpa fuga nulla ullam. In, libero.</p>
          </q-tab-panel>
        </q-tab-panels>
      </template>

    </q-splitter>
  </div>
</template>
