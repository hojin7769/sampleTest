package com.sample.sampletest.service;

import com.sample.sampletest.DVO.ChartMngDetailVO;
import com.sample.sampletest.DVO.ChartMngVO;

import java.util.List;

public interface ChartMngService {
    ChartMngVO search(String id);

    List<ChartMngDetailVO> detail(String id);

    List<ChartMngVO> select_box_search();


}
