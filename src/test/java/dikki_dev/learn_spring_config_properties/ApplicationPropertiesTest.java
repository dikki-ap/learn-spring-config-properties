package dikki_dev.learn_spring_config_properties;

import dikki_dev.learn_spring_config_properties.applicationproperties.ApplicationPropertiesApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.util.Objects;

@SpringBootTest(classes = ApplicationPropertiesApp.class)
public class ApplicationPropertiesTest {

    // Di sini kita menggunakan "Environment" object, dan gunakan "getProperty(key)"
    @Autowired
    private Environment environment;

    @Test
    void testGetApplicationProperites(){
        String springApplicationName = environment.getProperty("spring.application.name");
        Assertions.assertEquals("learn-spring-config-properties", springApplicationName);

        // Karena "getProperty(key)" return String, maka wajib parse ke Integer, dan karena ada kemungkinan null maka gunakan "Objects.requireNonNull(param)"
        int springApplicationVersion = Integer.parseInt(Objects.requireNonNull(environment.getProperty("spring.application.version")));
        Assertions.assertEquals(1, springApplicationVersion);
    }
}
