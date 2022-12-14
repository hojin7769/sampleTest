package com.sample.sampletest.service;

import com.sample.sampletest.dvo.HajaChartVO;
import com.sample.sampletest.dvo.HajaTableVO;

import java.util.List;

public interface HajaTableService {

    List<HajaTableVO> selectAll();
    List<HajaChartVO> chartSelect();

}
