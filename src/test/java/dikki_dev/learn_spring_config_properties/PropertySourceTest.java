package dikki_dev.learn_spring_config_properties;

import dikki_dev.learn_spring_config_properties.propertysource.PropertySourceApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = PropertySourceApplication.class)
public class PropertySourceTest {

    @Autowired
    private PropertySourceApplication.SampleProperties sampleProperties;

    @Autowired
    private PropertySourceApplication.AnotherSampleProperties anotherSampleProperties;

    @Autowired
    private PropertySourceApplication.AnotherSampleWithDiffKeyProperties anotherSampleWithDiffKeyProperties;

    @Test
    void testPropertySource(){

        // Harusnya "Sample Name" tetapi berubah menjadi "Another Sample Name"
        // karena dioverride oleh "another_sample.properties" dengan key yang sama
        // Sesuai urutan inject @PropertySource
        Assertions.assertEquals("Another Sample Name", sampleProperties.getName());

        // Harusnya "2" tetapi berubah menjadi "3"
        // karena dioverride oleh "another_sample.properties" dengan key yang sama
        // Sesuai urutan inject @PropertySource
        Assertions.assertEquals(3, sampleProperties.getVersion());

        // Ini sesuai, karena memang nilai aslinya, dan file ini yang melakukan override
        Assertions.assertEquals("Another Sample Name", anotherSampleProperties.getName());
        Assertions.assertEquals(3, anotherSampleProperties.getVersion());

        // Ini sesuai nilai aslinya, karena key nya berbeda dari yang lain
        Assertions.assertEquals("Another Sample Name With Diff Key", anotherSampleWithDiffKeyProperties.getName());
        Assertions.assertEquals(4, anotherSampleWithDiffKeyProperties.getVersion());
    }
}
