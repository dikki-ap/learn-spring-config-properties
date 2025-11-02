package dikki_dev.learn_spring_config_properties;

import dikki_dev.learn_spring_config_properties.messagesource.MessageSourceApplication;
import dikki_dev.learn_spring_config_properties.messagesourceaware.MessageSourceAwareApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Locale;

@SpringBootTest(classes = MessageSourceAwareApplication.class)
public class MessageSourceAwareTest {

    // Tinggal 'Field-Based' DI AwareSample yang sudah dibuat
    @Autowired
    private MessageSourceAwareApplication.MessageSourceAwareSample messageSourceAwareSample;

    @Test
    void testSayHelloDikki(){

        // Panggil method "sayHelloDikki(Locale)" berdasarkan file di "messages.properties"
        Assertions.assertEquals("Hello Dikki", messageSourceAwareSample.sayHelloDikki(Locale.ENGLISH));
        Assertions.assertEquals("Halo Dikki", messageSourceAwareSample.sayHelloDikki(new Locale("in_ID")));
        Assertions.assertEquals("Bonjour Dikki", messageSourceAwareSample.sayHelloDikki(new Locale("fr_FR")));
    }
}
