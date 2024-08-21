package be.jimsa.springtutorial.mvc.configs;

import jakarta.validation.constraints.Min;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Map;

@Component("appProps")
@Data
@PropertySource(value = "classpath:app.properties", ignoreResourceNotFound = true)
@ConfigurationProperties(prefix = "myapp")
@Validated
public class AppProps {

    @Min(value = 5)
    private int pageSize;

    private Map<String, String> content;

    private List<String> unit;

}
