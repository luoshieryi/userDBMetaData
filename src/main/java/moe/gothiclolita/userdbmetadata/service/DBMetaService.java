package moe.gothiclolita.userdbmetadata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class DBMetaService {

    private final JdbcTemplate jdbcTemplate;

    public List<String> getColumnNames(String tableName) {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM " + tableName + " WHERE 1 = 2");  // 取得结果集
        return Arrays.asList(sqlRowSet.getMetaData().getColumnNames());  // 取得列名
    }

    public String getColumnTypes(String tableName, String columnName) {
        // 获取 columnName 的 MetaData
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM " + tableName + " WHERE 1 = 2");  // 取得结果集
        return sqlRowSet.getMetaData().getColumnTypeName(sqlRowSet.findColumn(columnName));  // 取得列类型

    }

}
