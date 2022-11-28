package com.sample.sampletest.DVO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
@Setter
@Entity
public class ChartMngDetailVO {

    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection
    @Column(name = "C_LABEL")
    private List<String> C_LABEL;
    @ElementCollection
    @Column(name = "C_VALUE")
    private List<String> C_VALUE;

    public ChartMngDetailVO() {
    }

    public ChartMngDetailVO(List<String> c_LABEL, List<String> c_VALUE) {
        C_LABEL = c_LABEL;
        C_VALUE = c_VALUE;
    }
}
