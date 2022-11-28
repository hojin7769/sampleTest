package com.sample.sampletest.DVO;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "hj_dept")
public class SampleVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DEPT_NUM")
    private Long deptnum;

    @Column(name = "DEPT_NAME")
    private String deptname;

    @Column(name = "DEPT_BIGO")
    private String deptbigo;

    public SampleVO(String deptname, String deptbigo) {
        this.deptname = deptname;
        this.deptbigo = deptbigo;
    }
}
