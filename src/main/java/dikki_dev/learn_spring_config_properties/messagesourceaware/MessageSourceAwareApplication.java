package dikki_dev.learn_spring_config_properties.messagesourceaware;

import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootApplication
public class MessageSourceAwareApplication {

    /*
        Spring Boot menyediakan "MessageSourceAware" Interface untuk membuat Internationalization
        - Dengan catatan, interface ini akan membaca file bernama "messages.properties"
        - Jika ingin membuat Internationalization, bisa membuat "messsages_in_ID.properties" atau "messages_fr_FR.properties" sesuai kebutuhan
        - Kita hanya tinggal membuat object "MessageSource" dan tidak perlu setBaseNames lagi
     */
    @Component
    public class MessageSourceAwareSample implements MessageSourceAware{

        @Setter
        private MessageSource messageSource;

        // Locale digunakan sebagai Parameter
        public String sayHelloDikki(Locale locale){
            return messageSource.getMessage("hello", new Object[]{"Dikki"}, locale);
        }
    }
}
