package dikki_dev.learn_spring_config_properties.value;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ValueApplication {

    @Component
    @Getter
    public static class ValueApplicationProperties{

        // Kita juga bisa menggunakan "@Value("${key.application.properties}") untuk mengambil langsung data yang ada di application.properties
        @Value("${spring.application.name}")
        private String name;

        @Value("${spring.application.version}")
        private Integer version;

        @Value("${spring.application.production-mode}")
        private boolean productionMode;
    }
}
