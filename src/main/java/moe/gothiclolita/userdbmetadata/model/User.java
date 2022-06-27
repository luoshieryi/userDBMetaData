package moe.gothiclolita.userdbmetadata.model;

import lombok.Data;
import org.springframework.context.annotation.Bean;

/**
 * 用来对比的 Java Bean
 */
@Data
public class User {

    private Integer id;

    private String name;

    private String note;

}
