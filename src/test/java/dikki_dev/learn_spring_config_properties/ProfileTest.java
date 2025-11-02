package dikki_dev.learn_spring_config_properties;

import dikki_dev.learn_spring_config_properties.profile.ProfileApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = ProfileApplication.class)
@ActiveProfiles({"local", "production"})
public class ProfileTest {

    // 2 Component / Bean ini tidak perlu di disable, karena kita menggunakan kedua "profile" nya dengan "@ActiveProfiles"
    @Autowired
    private ProfileApplication.ProfileAppLocal profileAppLocal;

    @Autowired
    private ProfileApplication.ProfileAppProduction profileAppProduction;

    @Autowired
    private ProfileApplication.SampleActiveProfiles sampleActiveProfiles;

    @Test
    void testProfileAppLocal(){
        Assertions.assertEquals("Hello Dikki from Local", profileAppLocal.sayHello("Dikki"));
    }

    @Test
    void testProfileAppProduction(){
        Assertions.assertEquals("Hello Dikki from Production", profileAppProduction.sayHello("Dikki"));
    }

    @Test
    void testGetActiveProfiles(){
        // Mengambil "active profiles" yang sedang berjalan
        Assertions.assertArrayEquals(new String[]{"local", "production"}, sampleActiveProfiles.getActiveProfiles());
    }
}
