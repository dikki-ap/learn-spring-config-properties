package dikki_dev.learn_spring_config_properties;

import dikki_dev.learn_spring_config_properties.resourceloader.ResourceLoaderApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ResourceLoaderApplication.class)
public class ResourceLoaderApplicationAwareTest {
    @Autowired
    private ResourceLoaderApplication.SampleResource sampleResource;

    @Test
    void testResourceLoaderAware() throws Exception {
        // Compare textnya
        Assertions.assertEquals("This is a sample text", sampleResource.getText().trim());
    }
}
