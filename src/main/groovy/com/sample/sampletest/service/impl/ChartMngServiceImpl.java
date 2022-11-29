package com.sample.sampletest.service.impl;

import com.sample.sampletest.DVO.ChartMngDetailVO;
import com.sample.sampletest.DVO.ChartMngVO;
import com.sample.sampletest.service.ChartMngService;
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

}
