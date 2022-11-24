import { defineStore } from 'pinia'

// defineStore() 의 첫번째 인자는 스토어의 고유한 ID
export const useRootStore = defineStore('root', {
  id: 'root',

  // state
  state: () => ({
    count: 0
  }),

  // getters
  getters: {
    getCount (state) {
      return state.count
    },

    getDoubleCount () {
      // 다른 getter 를 참조
      return this.getCount * 2
    }
  },

  // actions
  actions: {
    increaseCountAction () {
      this.count++
    },

    decreaseCountAciton () {
      this.count--
    },

    initCountAction () {
      this.count = 0
    }
  }
})
