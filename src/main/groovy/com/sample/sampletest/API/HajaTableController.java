package com.sample.sampletest.API;

import com.sample.sampletest.dvo.ChartCategoryVO;
import com.sample.sampletest.dvo.HajaChartVO;
import com.sample.sampletest.dvo.HajaTableVO;
import com.sample.sampletest.responses.BasicResponse;
import com.sample.sampletest.service.HajaTableService;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/hajaTable")
public class HajaTableController {

    @Autowired
    private HajaTableService hajaTableService;



    @RequestMapping("/select")
    public ResponseEntity<?> selectAll(@RequestBody(required = false)HajaTableVO vo){


        List<HajaTableVO> list =hajaTableService.selectAll();
        BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK).result(list).build();

        return  new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
    }


    @RequestMapping("chartAll")
    public ResponseEntity<?> chartAll(@RequestBody(required = false)HajaTableVO vo) {

        List<HajaChartVO> list = hajaTableService.chartSelect();
        BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK).result(list).build();
        return  new ResponseEntity<>(basicResponse, basicResponse.getHttpStatus());
    }

    @RequestMapping("/save")
    public ResponseEntity<?> save(@RequestBody(required = false) Map<String,Object> map){
        ChartCategoryVO vo = new ChartCategoryVO(MapUtils.getString(map,"ID_CATEGORY"),MapUtils.getString(map,"NM_CATEGORY"),MapUtils.getString(map,"DESC_CATEGORY"));

        int i = hajaTableService.save(vo);

        BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK).result(Collections.emptyList()).build();

        return new ResponseEntity<>(basicResponse,basicResponse.getHttpStatus());
    }

    @PostMapping("/selectCategory")
    public ResponseEntity<?> selectListCategory(@RequestBody(required = false) Map<String,Object> map){

        List<ChartCategoryVO> list = hajaTableService.selectListCategory();

        BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK).result(list).build();

        return new ResponseEntity<>(basicResponse,basicResponse.getHttpStatus());
    }

    @PostMapping("/saveHaja")
    public ResponseEntity<?> saveHajaTable(@RequestBody(required = false) Map<String,Object> map){
        HajaTableVO vo = new HajaTableVO();
        vo.setTitle(MapUtils.getString(map,"Title"));
        vo.setDesc_content(MapUtils.getString(map,"desc_content"));
        vo.setSeq_category(MapUtils.getInteger(map,"seq_category"));

        int i = hajaTableService.saveHajaTable(vo);

        BasicResponse basicResponse = BasicResponse.builder().code(HttpStatus.OK.value()).httpStatus(HttpStatus.OK).result(Collections.emptyList()).build();

        return new ResponseEntity<>(basicResponse,basicResponse.getHttpStatus());
    }

}
