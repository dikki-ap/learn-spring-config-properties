package dikki_dev.learn_spring_config_properties;

import dikki_dev.learn_spring_config_properties.properties.SamplePropertiesApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Duration;
import java.util.Arrays;

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

    @Test
    void testDatabaseProperties(){
        Assertions.assertEquals("admin", samplePropertiesApplication.getDatabaseProperties().getUsername());
        Assertions.assertEquals("admin123", samplePropertiesApplication.getDatabaseProperties().getPassword());
        Assertions.assertEquals("jdbc:example", samplePropertiesApplication.getDatabaseProperties().getUrl());
        Assertions.assertEquals("mydb", samplePropertiesApplication.getDatabaseProperties().getDatabaseName());
    }

    @Test
    void testCollectionProperties(){
        Assertions.assertEquals(Arrays.asList("products", "customers", "categories"), samplePropertiesApplication.getDatabaseProperties().getWhiteListTables());
        Assertions.assertEquals(100, samplePropertiesApplication.getDatabaseProperties().getMaxTablesSize().get("products"));
        Assertions.assertEquals(50, samplePropertiesApplication.getDatabaseProperties().getMaxTablesSize().get("customers"));
        Assertions.assertEquals(30, samplePropertiesApplication.getDatabaseProperties().getMaxTablesSize().get("categories"));
    }

    @Test
    void testEmbeddedCollectionProperties(){
        Assertions.assertEquals("default", samplePropertiesApplication.getDefaultRoles().get(0).getId());
        Assertions.assertEquals("Default Role", samplePropertiesApplication.getDefaultRoles().get(0).getName());
        Assertions.assertEquals("guest", samplePropertiesApplication.getDefaultRoles().get(1).getId());
        Assertions.assertEquals("Guest Role", samplePropertiesApplication.getDefaultRoles().get(1).getName());

        Assertions.assertEquals("admin", samplePropertiesApplication.getRoles().get("admin").getId());
        Assertions.assertEquals("Admin Role", samplePropertiesApplication.getRoles().get("admin").getName());
        Assertions.assertEquals("finance", samplePropertiesApplication.getRoles().get("finance").getId());
        Assertions.assertEquals("Finance Role", samplePropertiesApplication.getRoles().get("finance").getName());
    }

    @Test
    void testDurationProperties(){
        Assertions.assertEquals(Duration.ofSeconds(10), samplePropertiesApplication.getDefaultTimeout());
    }
}
