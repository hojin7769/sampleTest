package com.sample.sampletest.dao;

import com.sample.sampletest.dvo.ChartCategoryVO;
import com.sample.sampletest.dvo.HajaChartVO;
import com.sample.sampletest.dvo.HajaTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HajaTableDAO {


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;


    public List<HajaTableVO> seleteList(){

        String sql = """
                    SELECT ht.SN_SEQ,ht.TITLE,ht.DESC_CONTENT,ht.SEQ_CATEGORY,ht.DT_INSERT,dzc.ID_CATEGORY,dzc.NM_CATEGORY
                    FROM HAJA_TABLE ht, DZZT_CHARTCATEGORY dzc
                     WHERE ht.SEQ_CATEGORY = dzc.SN_SEQ
                """;

        List<HajaTableVO> list = new ArrayList<>();

            list = jdbcTemplate.query(sql, new RowMapper<HajaTableVO>() {
            @Override
            public HajaTableVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                HajaTableVO vo = new HajaTableVO();
                vo.setSn_seq(rs.getInt("SN_SEQ"));
                vo.setTitle(rs.getString("TITLE"));
                vo.setDesc_content(rs.getString("DESC_CONTENT"));
                vo.setSeq_category(rs.getInt("SEQ_CATEGORY"));
                vo.setDt_insert(rs.getString("DT_INSERT"));
                vo.setChartCategoryVO( new ChartCategoryVO(rs.getString("ID_CATEGORY"),rs.getString("NM_CATEGORY")));
                return vo;
            }
        });
        return list;
    }


    public List<HajaChartVO> chartSelect(){
        String sql = """
                  SELECT count(*) "count" ,dzc.ID_CATEGORY  ,dzc.NM_CATEGORY
                 FROM HAJA_TABLE ht, DZZT_CHARTCATEGORY dzc
                 WHERE ht.SEQ_CATEGORY = dzc.SN_SEQ
                 GROUP BY dzc.ID_CATEGORY  ,dzc.NM_CATEGORY
                """;
        List<HajaChartVO> list = new ArrayList<>();

        list = jdbcTemplate.query(sql, new RowMapper<HajaChartVO>() {
            @Override
            public HajaChartVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                HajaChartVO vo = new HajaChartVO();
                vo.setValue(rs.getInt("count"));
                vo.setID_CATEGORY(rs.getString("ID_CATEGORY"));
                vo.setNM_CATEGORY(rs.getString("NM_CATEGORY"));

                return vo;
            }
        });
        return list;
    }


}
