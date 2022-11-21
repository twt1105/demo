package com.example.conf;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "test")
@Component
public class ListConfig {
     private List<String> abc;
}
