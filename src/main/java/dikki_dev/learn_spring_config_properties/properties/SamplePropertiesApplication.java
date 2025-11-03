package dikki_dev.learn_spring_config_properties.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
// Tambahkan "@ConfigurationProperties("prefix-Name")" sesuai dengan "application.properties" file
// "prefix" hanya bisa "kebab-case" atau "snake_case" untuk spring boot 3.x ++
@ConfigurationProperties("my-prefix-kebab-case")
    /*
        - Gunakan "mvn compile" untuk generate METADATA file agar bisa melihat isinya
        - Filenya ada di "/target/classes/META-INF/spring-configuration-metadata.json"

        ** Contoh file METADATA **
        {
          "groups": [
            {
              "name": "my-prefix-kebab-case",
              "type": "dikki_dev.learn_spring_config_properties.properties.PropertiesApplication$SamplePropertiesApplication",
              "sourceType": "dikki_dev.learn_spring_config_properties.properties.PropertiesApplication$SamplePropertiesApplication"
            }
          ],
          "properties": [
            {
              "name": "my-prefix-kebab-case.name",
              "type": "java.lang.String",
              "sourceType": "dikki_dev.learn_spring_config_properties.properties.PropertiesApplication$SamplePropertiesApplication"
            },
            {
              "name": "my-prefix-kebab-case.version",
              "type": "java.lang.Integer",
              "sourceType": "dikki_dev.learn_spring_config_properties.properties.PropertiesApplication$SamplePropertiesApplication"
            }
          ],
          "hints": [],
          "ignored": {
            "properties": []
          }
        }

        - File ini nantinya akan berisi list METADATA yang bisa kita gunakan
        - Jadi Class "SamplePropertiesApplication" untuk "name" dan "version" nya otomatis mengambil dari "application.properties" file
        - Tidak perlu menggunakan "@Value("${key}")" satu persatu lagi
     */
public class SamplePropertiesApplication {
    // Wajib menggunakan Final dan Constructor tanpa Setter karena sudah "final"
    private final String name;
    private final Integer version;

    // Tambahan untuk Inner Class terkait "Complex Configuration Properties"
    private final DatabaseProperties databaseProperties;

    // 'Embedded-Collection' for "@ConfigurationProperties" Annotation
    private final List<Role> defaultRoles;
    private final Map<String, Role> roles;

    // Conversion / Converter
    private final Duration defaultTimeout;

    // Add "Custom Converter"
    private final Date expiredDate;

    // Tambahan untuk Inner Class terkait "Complex Configuration Properties"
    @Getter
    @AllArgsConstructor
    public static class DatabaseProperties{
        private final String username;
        private final String password;
        private final String url;
        private final String databaseName; // Kalau "camelCase" seperti ini akan menjadi "kebab-case" di "mvn-compile" METADATA nya

        // Collection "@ConfigurationProperties" Annotation
        private final List<String> whiteListTables; // "whiteListTables" menjadi "white-list-tables"
        private final Map<String, Integer> maxTablesSize; // "maxTablesSize" menjadi "max-tables-size"
    }


    // 'Embedded-Collection' for "@ConfigurationProperties" Annotation
    @Getter
    @AllArgsConstructor
    public static class Role{
        private final String id;
        private final String name;
    }
}
