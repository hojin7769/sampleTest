package com.sample.sampletest.DVO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Map;


@Getter
@Setter
@Table(name = "DZZT_CHARTMNG")
public class ChartMngDetailVO {



    private Map<String,Object> C_LABEL;
    private Map<String,Object> C_VALUE;

    public ChartMngDetailVO() {
    }

    public ChartMngDetailVO(Map<String, Object> c_LABEL, Map<String, Object> c_VALUE) {
        C_LABEL = c_LABEL;
        C_VALUE = c_VALUE;
    }


}
