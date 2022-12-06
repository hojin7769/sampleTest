export default class Mychart {
  label
  data
  chartId
  width
  height
  cssClasses
  styles
  type
  labels
  chartOptions
  backgroundColor

  constructor () {
    this.label = '';
    this.data = [];
    this.chartId = '';
    this.width = 600;
    this.height = 600;
    this.cssClasses = '';
    this.styles = [];
    this.type = '';
    this.labels = [];
    this.chartOptions = [];
    this.backgroundColor = [];
  }

  setLabel (value) {
    this.label = value
  }

  getLabel () {
    return this.label
  }

  setData (value) {
    this.data = value
  }

  getData () {
    return this.data
  }

  setChartId (value) {
    this.chartId = value
  }

  getChartId () {
    return this.chartId
  }

  setWidth (value) {
    this.width = value
  }

  getWidth () {
    return this.width
  }

  setHeight (value) {
    this.height = value
  }

  getHeight () {
    return this.height
  }

  setCssClasses (value) {
    this.cssClasses = value
  }

  getCssClasses () {
    return this.cssClasses
  }

  setStyle (value) {
    this.styles = value
  }

  getStyles () {
    return this.styles
  }

  setType (value) {
    this.type = value
  }

  getType () {
    return this.type
  }

  setLabels (value) {
    this.labels = value
  }

  getLabels () {
    return this.labels
  }

  setChartOptions (value) {
    this.chartOptions = value
  }

  getChartOption () {
    return this.chartOptions
  }

  setBackgroundColor (value) {
    this.backgroundColor = value
  }

  getBackgroundColor () {
    return this.backgroundColor
  }
}
