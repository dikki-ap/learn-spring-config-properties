package dikki_dev.learn_spring_config_properties.propertysource;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@SpringBootApplication
@PropertySources({
        // Jika menggunakan 2 file "properties" seperti ini, DISARANKAN MENGGUNAKAN KEY YANG BERBEDA
        // Jika key nya sama, nilai yang ada di "sample.properties", akan dioverride oleh "another_sample.properties"
        @PropertySource("classpath:/sample.properties"),
        @PropertySource("classpath:/another_sample.properties"),

        // Lebih baik membuat file yang berbeda dengan key yang berbeda
        @PropertySource("classpath:/another_sample_with_diff_key.properties")
})
public class PropertySourceApplication {

    @Component
    @Getter
    public static class SampleProperties{

        @Value("${sample.name}")
        private String name;

        @Value("${sample.version}")
        private Integer version;
    }

    @Component
    @Getter
    public static class AnotherSampleProperties{

        @Value("${sample.name}")
        private String name;

        @Value("${sample.version}")
        private Integer version;
    }

    @Component
    @Getter
    public static class AnotherSampleWithDiffKeyProperties{

        @Value("${another.sample.with.diff.key.name}")
        private String name;

        @Value("${another.sample.with.diff.key.version}")
        private Integer version;
    }
}
