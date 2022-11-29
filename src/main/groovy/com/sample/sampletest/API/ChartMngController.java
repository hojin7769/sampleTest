package com.sample.sampletest.API;


import com.sample.sampletest.DVO.ChartMngDetailVO;
import com.sample.sampletest.DVO.ChartMngVO;
import com.sample.sampletest.service.ChartMngService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/chartMng")
public class ChartMngController {

    @Autowired
    private ChartMngService chartMngService;

    @PostMapping("/search")
    public ChartMngVO search(@RequestBody Map<String,Object> map){

        String chartId = MapUtils.getString(map,"chart_id");
        ChartMngVO vo =  chartMngService.search(chartId);
        return vo;
    }

    @PostMapping("/detail")
    public List<ChartMngDetailVO> detail(@RequestBody Map<String,Object> map){
        String chartId = MapUtils.getString(map,"chart_id");
        List<ChartMngDetailVO> list = chartMngService.detail(chartId);

        return list;
    }

    @PostMapping("/selectBoxSearch")
    public List<ChartMngVO> select_box_search(@RequestBody(required = false) Map<String,Object> map){
        return chartMngService.select_box_search();
    }


}
