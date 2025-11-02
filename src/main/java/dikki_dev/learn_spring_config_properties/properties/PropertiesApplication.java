package dikki_dev.learn_spring_config_properties.properties;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        PropertiesApplication.SamplePropertiesApplication.class
})
public class PropertiesApplication {


    @ConfigurationProperties("myPrefix") // Tambahkan "@ConfigurationProperties("prefixName")" sesuai dengan "application.properties" file
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
    public static class SamplePropertiesApplication{

        private String name;
        private Integer version;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getVersion() {
            return version;
        }

        public void setVersion(Integer version) {
            this.version = version;
        }
    }
}
