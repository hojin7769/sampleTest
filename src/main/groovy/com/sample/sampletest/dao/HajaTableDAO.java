package com.sample.sampletest.dao;

import com.sample.sampletest.dvo.ChartCategoryVO;
import com.sample.sampletest.dvo.HajaChartVO;
import com.sample.sampletest.dvo.HajaTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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



    public int save(ChartCategoryVO vo){

        String sql = """
                    insert into DZZT_CHARTCATEGORY (ID_CATEGORY,NM_CATEGORY,DT_INSERT,DESC_CATEGORY) 
                    VALUES (:ID_CATEGORY,:NM_CATEGORY,GETDATE(),:DESC_CATEGORY)
                """;


        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("ID_CATEGORY",vo.getID_CATEGORY())
                .addValue("NM_CATEGORY",vo.getNM_CATEGORY())
                .addValue("DESC_CATEGORY",vo.getDESC_CATEGORY());


        int i = jdbcTemplate.update(sql,parameterSource);
        return i;
    }

    public List<ChartCategoryVO> selectListCategory(){
        String sql = """
                    SELECT SN_SEQ,ID_CATEGORY,NM_CATEGORY,DESC_CATEGORY,RM_BIGO,DT_INSERT,DT_UPDATE
                    FROM DZZT_CHARTCATEGORY
                """;

        List<ChartCategoryVO> list = new ArrayList<>();

        list = jdbcTemplate.query(sql, new RowMapper<ChartCategoryVO>() {
            @Override
            public ChartCategoryVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                ChartCategoryVO vo = new ChartCategoryVO();
                vo.setSN_SEQ(rs.getInt("SN_SEQ"));
                vo.setID_CATEGORY(rs.getString("ID_CATEGORY"));
                vo.setNM_CATEGORY(rs.getString("NM_CATEGORY"));
                vo.setDESC_CATEGORY(rs.getString("DESC_CATEGORY"));
                vo.setDT_INSERT(rs.getString("DT_INSERT"));
                vo.setRM_BIGO(rs.getString("RM_BIGO"));
                vo.setDT_UPDATE(rs.getString("DT_UPDATE"));
                return vo;
            }
        });
        return list;
    }


    public int saveHajaTable(HajaTableVO vo){

        MapSqlParameterSource parameterSource = new MapSqlParameterSource().addValue("TITLE",vo.getTitle())
                .addValue("DESC_CONTENT",vo.getDesc_content())
                .addValue("SEQ_CATEGORY",vo.getSeq_category());

        String sql = """
                INSERT INTO haja_TABLE(TITLE,DESC_CONTENT,SEQ_CATEGORY,DT_INSERT) VALUES(:TITLE,:DESC_CONTENT,:SEQ_CATEGORY,GETDATE())
                """;

        int i = jdbcTemplate.update(sql,parameterSource);
        return i;

    }






}
