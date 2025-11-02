package dikki_dev.learn_spring_config_properties;

import dikki_dev.learn_spring_config_properties.profileproperties.ProfilePropertiesApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ProfilePropertiesApplication.class)
@ActiveProfiles({"test", "production"}) // Enable untuk @ActiveProfiles nya adalah "test" dan "production"
public class ProfilePropertiesTest {

    @Autowired
    private ProfilePropertiesApplication.SampleProfileProperties sampleProfileProperties;

    @Test
    void testProfileProperties(){
        /*
            - Spring bisa membaca berdasarkan profile dengan nama "application-{profileName}.properties"
            - Jadi kita bisa membuat konfigurasi file "application.properties" berdasarkan environment nantinya
            - Hanya saja kita harus set setiap @Component atau @Bean atau apapun itu berdasarkan value @Profile nya
         */
        Assertions.assertEquals("Profile Default", sampleProfileProperties.getProfileDefault()); // Otomatis akan didapatkan karena secara default akan membaca application.properties
        Assertions.assertEquals("Profile Test", sampleProfileProperties.getProfileTest());
        Assertions.assertEquals("Profile Production", sampleProfileProperties.getProfileProduction());
    }
}
