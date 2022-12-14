package com.sample.sampletest.dvo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HajaChartVO {

    private int value;
    private String NM_CATEGORY;
    private String ID_CATEGORY;

    public HajaChartVO(int value, String NM_CATEGORY, String ID_CATEGORY) {
        this.value = value;
        this.NM_CATEGORY = NM_CATEGORY;
        this.ID_CATEGORY = ID_CATEGORY;
    }

    @Override
    public String toString() {
        return "HajaChartVO{" +
                "value=" + value +
                ", NM_CATEGORY='" + NM_CATEGORY + '\'' +
                ", ID_CATEGORY='" + ID_CATEGORY + '\'' +
                '}';
    }
}
