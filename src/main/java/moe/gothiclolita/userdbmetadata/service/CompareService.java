package moe.gothiclolita.userdbmetadata.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CompareService {

    private final DBMetaService dbMetaService;
    private final BeanMetaService beanMetaService;

    public void compare() {
        String tableName = "t_user";

        // compare column names
        String[] columnNames = dbMetaService.getColumnNames(tableName);
        for (String columnName : columnNames) {
            System.out.println(columnName);
        }
        String[] beanFieldNames = beanMetaService.getFieldNames("moe.gothiclolita.userdbmetadata.model.User");
        for (String beanFieldName : beanFieldNames) {
            System.out.println(beanFieldName);
        }

    }

}
