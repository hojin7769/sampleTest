package com.sample.sampletest.API;

import com.sample.sampletest.dvo.HajaChartVO;
import com.sample.sampletest.dvo.HajaTableVO;
import com.sample.sampletest.responses.BasicResponse;
import com.sample.sampletest.service.HajaTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
