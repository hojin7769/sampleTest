package com.sample.sampletest.service;

import com.sample.sampletest.dvo.ChartMngDetailVO;
import com.sample.sampletest.dvo.ChartMngVO;

import java.util.List;

public interface ChartMngService {
    ChartMngVO search(String id);

    List<ChartMngDetailVO> detail(String id);

    List<ChartMngVO> select_box_search();


}
