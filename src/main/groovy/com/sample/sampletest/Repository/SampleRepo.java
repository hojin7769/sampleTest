package com.sample.sampletest.Repository;


import com.sample.sampletest.dvo.SampleVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SampleRepo extends JpaRepository<SampleVO,Long> {

}
