package moe.gothiclolita.userdbmetadata.service;

import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeanMetaService {

    // 获取 Java Bean 的属性名称
    public List<String> getFieldNames(String className) {
        try {
            Class<?> beanClass = Class.forName(className);
            return Arrays.stream(beanClass.getDeclaredFields()).map(Field::getName).collect(Collectors.toList());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 获取 Java Bean 的属性类型
    public String getFieldTypes(String className, String fieldName) {
        try {
            Class<?> beanClass = Class.forName(className);
            Field field = beanClass.getDeclaredField(fieldName);
            return field.getType().getSimpleName();
        } catch (ClassNotFoundException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }

}
