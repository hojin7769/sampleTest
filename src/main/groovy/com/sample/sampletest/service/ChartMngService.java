package com.sample.sampletest.service;

import com.sample.sampletest.DVO.ChartMngDetailVO;
import com.sample.sampletest.DVO.ChartMngVO;

public interface ChartMngService {
    ChartMngVO search(String id);

    ChartMngDetailVO detail(String id);
}
