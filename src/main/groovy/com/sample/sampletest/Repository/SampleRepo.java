package com.sample.sampletest.Repository;


import com.sample.sampletest.DVO.SampleVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepo extends JpaRepository<SampleVO,Long> {

}
