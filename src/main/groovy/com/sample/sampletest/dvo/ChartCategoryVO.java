package com.sample.sampletest.dvo;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class ChartCategoryVO {


    private int SN_SEQ;
    private String ID_CATEGORY;
    private String NM_CATEGORY;
    private String DESC_CATEGORY;
    private String RM_BIGO;
    private String DT_INSERT;
    private String DT_UPDATE;

    public ChartCategoryVO(String ID_CATEGORY, String NM_CATEGORY) {
        this.ID_CATEGORY = ID_CATEGORY;
        this.NM_CATEGORY = NM_CATEGORY;
    }

}
