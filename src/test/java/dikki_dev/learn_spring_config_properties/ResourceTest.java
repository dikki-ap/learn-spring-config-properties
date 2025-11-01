package dikki_dev.learn_spring_config_properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class ResourceTest {

    // Throws "IOException" karena method "getFile()"
    @Test
    void testResource() throws IOException {
        // Ada banyak sekali jenis "Resource" salah satunya adalah ClassPathResource
        // Kita bisa mengambil "application.properties" menggunakan ini
        // Jika ingin lebih tahu banyak bisa cek dokumentasi

        var sampleTxt = new ClassPathResource("/text/sample.txt"); // Mengarahkan ke folder "text"
        var applicationProperties = new ClassPathResource(("/application.properties")); // Tidak ada di dalam foler "resources" karena itu adalah "Resources Root", absolute Path dari Framework Spring

        Assertions.assertNotNull(sampleTxt);
        Assertions.assertNotNull(applicationProperties);

        Assertions.assertTrue(sampleTxt.exists());
        Assertions.assertTrue(applicationProperties.exists());

        Assertions.assertNotNull(sampleTxt.getFile());
        Assertions.assertNotNull(applicationProperties.getFile());
    }
}
