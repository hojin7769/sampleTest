package com.sample.sampletest.dao;

import org.apache.commons.collections4.MapUtils;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ChartDrawDAO {


    @Autowired
    DataSource dataSource;

    public Map<String,Object> chartDrawInfo(Map<String,Object> map){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(dataSource);

        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("CHART_ID", MapUtils.getString(map,"chart_id"));

        jdbcCall.withSchemaName("dbo");
        jdbcCall.withProcedureName("DZZPR_CHARTMNG_SELECT");
        Map<String, Object> result = null;
        try {
            result = jdbcCall.execute(paramMap);
        } catch (UncategorizedSQLException e) {
            e.getMessage();
        }
        return result;
    }



}
