package com.sample.sampletest.service;

import com.sample.sampletest.DVO.ChartMngVO;

import java.util.List;

public interface ChartMngService {
    ChartMngVO search(String id);

    List detail(String id);
}
