package com.example.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
/**
 * @author tao511221
 */
@Data
@ConfigurationProperties(prefix = "user")
@Component
public class User {
    private String name;

    private  int age;

    private Date birth;

    private Map<Object,Object> maps;
    private List<String> lists;
    private Dog dog;
}
