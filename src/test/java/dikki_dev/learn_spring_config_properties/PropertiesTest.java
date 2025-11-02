package dikki_dev.learn_spring_config_properties;

import dikki_dev.learn_spring_config_properties.properties.PropertiesApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(classes = PropertiesApplication.class)
@TestPropertySource(locations = "classpath:/application.properties")
public class PropertiesTest {

    @Autowired
    private PropertiesApplication.SamplePropertiesApplication samplePropertiesApplication;

    @Test
    void testSamplePropertiesApplication(){
        Assertions.assertEquals("My Application Name", samplePropertiesApplication.getName());
        Assertions.assertEquals(33, samplePropertiesApplication.getVersion());
    }
}
