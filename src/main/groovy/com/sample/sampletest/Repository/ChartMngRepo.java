package com.sample.sampletest.Repository;

import com.sample.sampletest.DVO.ChartMngVO;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

public interface ChartMngRepo extends JpaRepository<ChartMngVO,String> {



}
