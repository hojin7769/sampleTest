package com.sample.sampletest.service.impl;

import com.sample.sampletest.dao.HajaTableDAO;
import com.sample.sampletest.dvo.ChartCategoryVO;
import com.sample.sampletest.dvo.HajaChartVO;
import com.sample.sampletest.dvo.HajaTableVO;
import com.sample.sampletest.service.HajaTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HajaTableServiceImpl implements HajaTableService {

    @Autowired
    private HajaTableDAO hajaTableDAO;

    @Override
    public List<HajaTableVO> selectAll() {


        return hajaTableDAO.seleteList();
    }

    @Override
    public List<HajaChartVO> chartSelect() {
        return hajaTableDAO.chartSelect();
    }

    @Override
    public int save(ChartCategoryVO vo) {
        return hajaTableDAO.save(vo);
    }

    @Override
    public List<ChartCategoryVO> selectListCategory() {
        return hajaTableDAO.selectListCategory();
    }

    @Override
    public int saveHajaTable(HajaTableVO vo) {
        return hajaTableDAO.saveHajaTable(vo);
    }
}
