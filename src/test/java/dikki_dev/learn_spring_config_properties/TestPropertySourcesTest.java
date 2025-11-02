package dikki_dev.learn_spring_config_properties;

import dikki_dev.learn_spring_config_properties.testpropertysources.TestPropertySourcesApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.TestPropertySources;


@SpringBootTest(classes = TestPropertySourcesApplication.class)
@TestPropertySources({
        // Akan membaca file "test.properties" khusus untuk Unit Test ini
        @TestPropertySource("classpath:/test.properties")
})
public class TestPropertySourcesTest {

    @Autowired
    private TestPropertySourcesApplication.TestSampleProperties testSampleProperties;

    @Test
    void testTestSampleProperties(){

        // Akan membaca file "test.properties" khusus untuk Unit Test ini
        Assertions.assertEquals("Sample Project Test", testSampleProperties.getName());
        Assertions.assertEquals(5, testSampleProperties.getVersion());
    }
}
