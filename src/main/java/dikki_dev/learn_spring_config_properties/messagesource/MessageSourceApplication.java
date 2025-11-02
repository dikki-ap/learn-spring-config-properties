package dikki_dev.learn_spring_config_properties.messagesource;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class MessageSourceApplication {

    // Membuat Bean dari "MessageSource" Interface
    @Bean
    public MessageSource messageSource(){

        // "ResourceBundleMessageSource" adalah salah satu class implementasi dari Interface "MessageSource"
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();

        /*
            - Ada banyak function yang bisa digunakan, salah satunya adalah "setBaseNames()"
            - setBaseName("fileName")     --> Jika hanya ingin mengambil 1 file saja
            - setBaseNames("fileName")    --> Jika ingin mengambil banyak file dengan menerapkan Internationalization
            - Terdapat 2 file di "Resource Root" yaitu "my.properties" dan "my_in_ID.properties"
         */

        // Ambil fileName nya saja karena akan mengambil multi file based on Internationalization
        resourceBundleMessageSource.setBasenames("my");

        return resourceBundleMessageSource;
    }
}
