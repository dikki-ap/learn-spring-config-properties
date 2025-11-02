package dikki_dev.learn_spring_config_properties.profileproperties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ProfilePropertiesApplication {

    @Component
    @Getter
    public static class SampleProfileProperties{

        @Value("${profile.default}")
        private String profileDefault;

        @Value("${profile.test}")
        private String profileTest;

        @Value("${profile.production}")
        private String profileProduction;
    }
}
