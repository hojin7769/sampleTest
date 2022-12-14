package com.sample.sampletest.Repository;

import com.sample.sampletest.dvo.ChartMngVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartMngRepo extends JpaRepository<ChartMngVO,String> {



}
