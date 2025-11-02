package dikki_dev.learn_spring_config_properties.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties("my-prefix-kebab-case") // Tambahkan "@ConfigurationProperties("prefixName")" sesuai dengan "application.properties" file
    /*
        - Gunakan "mvn compile" untuk generate METADATA file agar bisa melihat isinya
        - Filenya ada di "/target/classes/META-INF/spring-configuration-metadata.json"

        ** Contoh file METADATA **
        {
          "groups": [
            {
              "name": "myPrefix",
              "type": "dikki_dev.learn_spring_config_properties.properties.PropertiesApplication$SamplePropertiesApplication",
              "sourceType": "dikki_dev.learn_spring_config_properties.properties.PropertiesApplication$SamplePropertiesApplication"
            }
          ],
          "properties": [
            {
              "name": "myPrefix.name",
              "type": "java.lang.String",
              "sourceType": "dikki_dev.learn_spring_config_properties.properties.PropertiesApplication$SamplePropertiesApplication"
            },
            {
              "name": "myPrefix.version",
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
    private final String name;
    private final Integer version;
}
