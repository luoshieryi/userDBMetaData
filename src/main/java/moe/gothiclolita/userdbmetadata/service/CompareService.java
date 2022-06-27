package moe.gothiclolita.userdbmetadata.service;

import lombok.RequiredArgsConstructor;
import moe.gothiclolita.userdbmetadata.util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class CompareService {

    private final DBMetaService dbMetaService;
    private final BeanMetaService beanMetaService;

    public String compare() throws Exception {
        String tableName = "t_user";
        String beanClassName = "moe.gothiclolita.userdbmetadata.model.User";
        StringBuilder result = new StringBuilder();

        // compare column names
        System.out.println("比较表 " + tableName + " 的列名与 Bean " + beanClassName + " 的属性名称");
        List<String> columnNames = dbMetaService.getColumnNames(tableName);
        List<String> beanFieldNames = beanMetaService.getFieldNames(beanClassName);
        // 共有
        List<String> commonNames = ListUtil.intersect(columnNames, beanFieldNames);
        // db 独有
        List<String> dbOnlyNames = ListUtil.divide(columnNames, beanFieldNames);
        // bean 独有
        List<String> beanOnlyNames = ListUtil.divide(beanFieldNames, columnNames);
        System.out.println("共有: " + commonNames);
        System.out.println("只在 table 中有: " + dbOnlyNames);
        System.out.println("只在 bean 中有: " + beanOnlyNames);
        System.out.println();
        result.append("比较表 ").append(tableName).append(" 的列名与 Bean ").append(beanClassName).append(" 的属性名称\n");
        result.append("共有: ").append(commonNames).append("\n");
        result.append("只在 table 中有: ").append(dbOnlyNames).append("\n");
        result.append("只在 bean 中有: ").append(beanOnlyNames).append("\n");
        result.append("\n");


        // compare union columns
        System.out.println("比较表 " + tableName + " 的列名与 Bean " + beanClassName + " 同名属性的类型");
        List<String> dbCommonTypes = commonNames.stream().map(name -> dbMetaService.getColumnTypes(tableName, name)).collect(Collectors.toList());
        List<String> beanCommonTypes = new ArrayList<>();
        for (String name : commonNames) {
            String fieldTypes = beanMetaService.getFieldTypes(beanClassName, name);
            beanCommonTypes.add(fieldTypes);
        }
        for (int i = 0; i < commonNames.size(); i++) {
            System.out.println(commonNames.get(i) + ": " + dbCommonTypes.get(i) + " vs " + beanCommonTypes.get(i));
        }

        result.append("比较表 ").append(tableName).append(" 的列名与 Bean ").append(beanClassName).append(" 同名属性的类型\n");
        for (int i = 0; i < commonNames.size(); i++) {
            result.append(commonNames.get(i)).append(": ").append(dbCommonTypes.get(i)).append(" vs ").append(beanCommonTypes.get(i)).append("\n");
        }

        return result.toString();

    }

}
