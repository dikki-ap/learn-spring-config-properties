package dikki_dev.learn_spring_config_properties;

import dikki_dev.learn_spring_config_properties.messagesource.MessageSourceApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;

import java.util.Locale;

@SpringBootTest(classes = MessageSourceApplication.class)
public class MessageSourceTest {
    
    @Autowired
    MessageSource messageSource;

    @Test
    void testDefaultLocale(){
        // Gunakan function "getMessage("key", objectParameter, Locale)
        // objectParameter bersifat optional
        String helloEnglish = messageSource.getMessage("hello", new Object[]{"Dikki"}, Locale.ENGLISH);
        Assertions.assertEquals("Hello Dikki", helloEnglish);
    }

    @Test
    void testIndonesiaLocale(){
        // Gunakan function "getMessage("key", objectParameter, Locale)
        // objectParameter bersifat optional
        String helloIndonesia = messageSource.getMessage("hello", new Object[]{"Dikki"}, new Locale("in_ID"));
        Assertions.assertEquals("Halo Dikki", helloIndonesia);
    }

    @Test
    void testDefaultLocaleWithoutObjectParam(){
        // Gunakan function "getMessage("key", objectParameter, Locale)
        // objectParameter bersifat optional
        String helloEnglish = messageSource.getMessage("hello", null, Locale.ENGLISH);
        Assertions.assertEquals("Hello {0}", helloEnglish);
    }

    @Test
    void testIndonesiaLocaleWithoutObjectParam(){
        // Gunakan function "getMessage("key", objectParameter, Locale)
        // objectParameter bersifat optional
        String helloIndonesia = messageSource.getMessage("hello", null, new Locale("in_ID"));
        Assertions.assertEquals("Halo {0}", helloIndonesia);
    }


}
