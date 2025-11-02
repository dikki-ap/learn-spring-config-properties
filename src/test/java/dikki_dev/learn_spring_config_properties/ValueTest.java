package dikki_dev.learn_spring_config_properties;

import dikki_dev.learn_spring_config_properties.value.ValueApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ValueApplication.class)
public class ValueTest {

    @Autowired
    private ValueApplication.ValueApplicationProperties valueApplicationProperties;

    @Autowired
    private ValueApplication.SystemProperties systemProperties;

    @Test
    void testValueApplicationProperties(){
        Assertions.assertEquals("learn-spring-config-properties", valueApplicationProperties.getName());
        Assertions.assertEquals(1, valueApplicationProperties.getVersion());
        Assertions.assertEquals(false, valueApplicationProperties.isProductionMode());
    }

    @Test
    void testValueSystemProperties(){
        Assertions.assertEquals("C:\\Program Files\\Java\\jdk-25", systemProperties.getJavaHome());
    }

}
