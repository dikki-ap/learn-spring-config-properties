package dikki_dev.learn_spring_config_properties.applicationproperties;

import org.springframework.boot.autoconfigure.SpringBootApplication;

// Jika kita membuat class dengan "@SpringBootApplication" seperti ini
// Dengan otomatis kita dapat membaca file di folder "resources" dengan nama "application.properties"
// Kita bisa memanfaatkan "EnvironmentAware" ataupun "Environment"
@SpringBootApplication
public class ApplicationPropertiesApp {
}
