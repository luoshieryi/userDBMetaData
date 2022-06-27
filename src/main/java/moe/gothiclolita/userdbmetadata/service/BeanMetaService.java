package moe.gothiclolita.userdbmetadata.service;

import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Arrays;

@Service
public class BeanMetaService {

    // 获取 Java Bean 的属性名称
    public String[] getFieldNames(String className) {
        try {
            Class<?> beanClass = Class.forName(className);
            return Arrays.stream(beanClass.getDeclaredFields()).map(Field::getName).toArray(String[]::new);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new String[0];
    }

}
