const tableColum = {
  hajaTable: [
    {
      name: 'sn_seq',
      align: 'center',
      label: '번호',
      field: 'sn_seq'
    },
    {
      name: 'title',
      align: 'center',
      label: '제목',
      field: 'title'
    },
    {
      name: 'desc_content',
      align: 'center',
      label: '내용',
      field: 'desc_content'
    },
    {
      name: 'chartCategoryVO.id_CATEGORY',
      align: 'center',
      label: '카테고리',
      field: row => { return row.chartCategoryVO.id_CATEGORY }
    },
    {
      name: 'chartCategoryVO.nm_CATEGORY',
      align: 'center',
      label: '카테고리 명',
      field: row => { return row.chartCategoryVO.nm_CATEGORY }
    }
  ],
  hajaChart: [

    {
      name: 'id_CATEGORY',
      align: 'center',
      label: '카테고리 아이디',
      field: 'id_CATEGORY'
    },
    {
      name: 'nm_CATEGORY',
      align: 'center',
      label: '카테고리 이름',
      field: 'nm_CATEGORY'
    },
    {
      name: 'value',
      align: 'center',
      label: '건수',
      field: 'value'
    }
  ]

}
export default tableColum;
