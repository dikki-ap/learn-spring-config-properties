package dikki_dev.learn_spring_config_properties.properties;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        SamplePropertiesApplication.class
})
public class PropertiesApplication {
}
