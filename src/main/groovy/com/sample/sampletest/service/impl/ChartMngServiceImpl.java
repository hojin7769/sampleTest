package com.sample.sampletest.service.impl;

import com.sample.sampletest.DVO.ChartMngVO;
import com.sample.sampletest.service.ChartMngService;
import org.hibernate.Transaction;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
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


//        System.out.println(spq.getOutputParameterValue("result"));


       ChartMngVO chartMngVO = (ChartMngVO) spq.getSingleResult();





        return chartMngVO;
    }
}
