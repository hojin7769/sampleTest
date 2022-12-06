package com.sample.sampletest.service.impl;

import com.sample.sampletest.dao.ChartDrawDAO;
import com.sample.sampletest.service.ChartDrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ChartDrawServiceImpl implements ChartDrawService {


    @Autowired
    ChartDrawDAO chartDrawDAO;
    @Override
    public Map<String, Object> chartDrawInfo(Map<String, Object> map) {
        return chartDrawDAO.chartDrawInfo(map);
    }
}
