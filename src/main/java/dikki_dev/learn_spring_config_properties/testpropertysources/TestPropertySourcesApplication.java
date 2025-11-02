package dikki_dev.learn_spring_config_properties.testpropertysources;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

// Tidak perlui menggunakan "@PropertySources" karena nanti akan digunakan di Unit Test dengan file yang berbeda
@SpringBootApplication
public class TestPropertySourcesApplication {

    @Component
    @Getter
    public static class TestSampleProperties{

        @Value("${sample.name}")
        private String name;

        @Value("${sample.version}")
        private Integer version;
    }
}
