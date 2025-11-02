package dikki_dev.learn_spring_config_properties;

import dikki_dev.learn_spring_config_properties.profile.ProfileApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ProfileApplication.class)
public class ProfileLocalTest {
    @Autowired
    private ProfileApplication.ProfileAppLocal profileAppLocal;


    // Jika di "application.properties", di mana "spring.profiles.active=local" saja, maka Bean di bawah ini harus di disable
//    @Autowired
//    private ProfileApplication.ProfileAppProduction profileAppProduction;

    @Test
    void testProfileAppLocal(){
        Assertions.assertEquals("Hello Dikki from Local", profileAppLocal.sayHello("Dikki"));
    }
}
