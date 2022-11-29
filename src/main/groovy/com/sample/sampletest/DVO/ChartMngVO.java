package com.sample.sampletest.DVO;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;


@NamedStoredProcedureQuery(
        name = "ChartMngVO.Select_Chart", //쿼리 이름
        procedureName = "DZZPR_CHARTMNG_SELECT", //데이터베이스의 저장 프로시저명
        parameters = { //저장 프로시저의 매개변수와 일치하는 매개변수 목록
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "CHART_ID"),
        },
        resultClasses =ChartMngVO.class
)
@NamedStoredProcedureQuery(
        name = "ChartMngVO.Select_Chart_Detail",
        procedureName = "DZZPR_CHART_DETAIL_SELECT",
        parameters = { //저장 프로시저의 매개변수와 일치하는 매개변수 목록
                @StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "CHART_ID"),
        },
        resultClasses = ChartMngDetailVO.class
)
@Entity
@Data
@NoArgsConstructor
@Table(name = "DZZT_CHARTMNG")
public class ChartMngVO {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name= "CHART_ID")
    private String chartid;

    @Column(name="CHART_NM")
    private String chartnm;

    @Column(name="CHART_DESC")
    private String chartdesc;

    @Column(name = "CHART_SHAPE")
    private String chartshape;

    @Column(name = "RM_BIGO")
    private String rmBigo;

    @Builder
    public ChartMngVO(String chartnm, String chartdesc, String chartshape, String rmBigo) {
        this.chartnm = chartnm;
        this.chartdesc = chartdesc;
        this.chartshape = chartshape;
        this.rmBigo = rmBigo;
    }

    public static final String Select_Chart =  "DZZPR_CHARTMNG_SELECT";

    public static final String Select_Chart_Detail =  "DZZPR_CHART_DETAIL_SELECT";
}
