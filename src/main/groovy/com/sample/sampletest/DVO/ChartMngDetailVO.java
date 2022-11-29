package com.sample.sampletest.DVO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Getter
@Setter
@Entity
public class ChartMngDetailVO implements Serializable {

    private static final long serialVersionUID = 348348L;

    @Id
    @Column(name = "C_LABEL")
    private String C_LABEL;

    @Column(name = "C_VALUE")
    private String C_VALUE;

    public ChartMngDetailVO() {
    }

    public ChartMngDetailVO(String c_LABEL, String c_VALUE) {
        C_LABEL = c_LABEL;
        C_VALUE = c_VALUE;
    }

    @Override
    public String toString() {
        return "ChartMngDetailVO{" +
                "C_LABEL='" + C_LABEL + '\'' +
                ", C_VALUE='" + C_VALUE + '\'' +
                '}';
    }
}
