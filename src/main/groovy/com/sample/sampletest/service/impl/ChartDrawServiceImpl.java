package com.sample.sampletest.service.impl;

import com.sample.sampletest.dao.ChartDrawDAO;
import com.sample.sampletest.service.ChartDrawService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ChartDrawServiceImpl implements ChartDrawService {


    @Autowired
    ChartDrawDAO chartDrawDAO;
    @Override
    public Map<String, Object> chartDrawInfo(Map<String, Object> map) {
        Map<String,Object> result = new HashMap<>();
        result.put("result" ,MapUtils.getObject(chartDrawDAO.chartDrawInfo(map),"#result-set-1"));
        return result;
    }
}
