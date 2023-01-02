package com.sample.sampletest.service;

import com.sample.sampletest.dvo.ChartCategoryVO;
import com.sample.sampletest.dvo.HajaChartVO;
import com.sample.sampletest.dvo.HajaTableVO;

import java.util.List;

public interface HajaTableService {

    List<HajaTableVO> selectAll();
    List<HajaChartVO> chartSelect();
    int save(ChartCategoryVO vo);

    List<ChartCategoryVO> selectListCategory();
    int saveHajaTable(HajaTableVO vo);

}
