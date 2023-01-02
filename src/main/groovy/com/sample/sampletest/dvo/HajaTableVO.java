package com.sample.sampletest.dvo;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class HajaTableVO {

    private int sn_seq;
    private String title;
    private String desc_content;
    private int seq_category;
    private String dt_insert;

    private ChartCategoryVO chartCategoryVO;


    @Builder
    public HajaTableVO(){
        chartCategoryVO = new ChartCategoryVO();
    }
    @Builder
    public HajaTableVO(ChartCategoryVO chartCategoryVO) {
        this.chartCategoryVO = chartCategoryVO;
    }

    @Builder
    public HajaTableVO(int sn_seq, String title, String desc_content, int seq_category) {
        this.sn_seq = sn_seq;
        this.title = title;
        this.desc_content = desc_content;
        this.seq_category = seq_category;
    }
    @Builder
    public HajaTableVO(String title, String desc_content, int seq_category) {
        this.title = title;
        this.desc_content = desc_content;
        this.seq_category = seq_category;
    }

    @Override
    public String toString() {
        return "HajaTableVO{" +
                "sn_seq=" + sn_seq +
                ", title='" + title + '\'' +
                ", desc_content='" + desc_content + '\'' +
                ", seq_category=" + seq_category +
                '}';
    }
}
