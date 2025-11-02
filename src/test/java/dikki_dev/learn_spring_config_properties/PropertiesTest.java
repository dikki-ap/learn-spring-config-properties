package dikki_dev.learn_spring_config_properties;

import dikki_dev.learn_spring_config_properties.properties.SamplePropertiesApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) // Mengganti @SpringBootTest khusus JUnit 5, karena @SpringBootTest akan menjalankan semua class yang ada annotation tersebut dan scan semua Bean yang diperlukan
@EnableConfigurationProperties(SamplePropertiesApplication.class)
@TestPropertySource(locations = "classpath:application.properties")
class PropertiesTest {

    @Autowired
    private SamplePropertiesApplication samplePropertiesApplication;

    @Test
    void testSamplePropertiesApplication(){
        Assertions.assertEquals("My Application Name", samplePropertiesApplication.getName());
        Assertions.assertEquals(33, samplePropertiesApplication.getVersion());
    }
}
