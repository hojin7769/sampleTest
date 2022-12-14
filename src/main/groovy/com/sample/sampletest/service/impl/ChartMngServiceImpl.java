package com.sample.sampletest.service.impl;

import com.sample.sampletest.dvo.ChartMngDetailVO;
import com.sample.sampletest.dvo.ChartMngVO;
import com.sample.sampletest.Repository.ChartMngRepo;
import com.sample.sampletest.service.ChartMngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class ChartMngServiceImpl implements ChartMngService {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    ChartMngRepo chartMngRepo;


    public ChartMngServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }




    @Override
    @Transactional(readOnly = true)
    public ChartMngVO search(String id) {

        StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery("ChartMngVO.Select_Chart");

        spq.setParameter("CHART_ID",id);
        spq.execute();

       ChartMngVO chartMngVO = (ChartMngVO) spq.getSingleResult();

        return chartMngVO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ChartMngDetailVO> detail(String id) {
        StoredProcedureQuery spq = entityManager.createNamedStoredProcedureQuery("ChartMngVO.Select_Chart_Detail");

        spq.setParameter("CHART_ID",id);
        spq.execute();

        List<ChartMngDetailVO> list = spq.getResultList();


        return list;
    }

    @Override
    public List<ChartMngVO> select_box_search() {
        List<ChartMngVO> list = chartMngRepo.findAll();

        return list;
    }
}
