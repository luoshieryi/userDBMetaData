package moe.gothiclolita.userdbmetadata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class DBMetaService {

    private final JdbcTemplate jdbcTemplate;

    public String[] getColumnNames(String tableName) {
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet("SELECT * FROM " + tableName);  // 取得结果集
        return sqlRowSet.getMetaData().getColumnNames();
    }

}
