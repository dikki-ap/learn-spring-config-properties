package dikki_dev.learn_spring_config_properties.properties;

import dikki_dev.learn_spring_config_properties.converter.StringToDateConverter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.ConversionService;

@SpringBootApplication
@EnableConfigurationProperties({
        SamplePropertiesApplication.class
})
public class PropertiesApplication {


    @Bean
    // Create "Custom Converter" using ConversionService (in this case String to Date)
    // Sebenarnya ConversionService ini nanti bisa digunakan otomatis dengan Spring Web (tetapi kali ini dibuat manual)
    public ConversionService conversionService(StringToDateConverter stringToDateConverter){
        ApplicationConversionService applicationConversionService = new ApplicationConversionService();
        applicationConversionService.addConverter(stringToDateConverter); // Menambahkan salah satu Custom Converter
        return  applicationConversionService;
    }
}
