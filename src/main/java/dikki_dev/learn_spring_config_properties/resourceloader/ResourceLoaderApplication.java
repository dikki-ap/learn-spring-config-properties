package dikki_dev.learn_spring_config_properties.resourceloader;

import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ResourceLoaderApplication {

    // Implementasi "ResourceLoaderAware" Interface
    @Component
    public static class SampleResource implements ResourceLoaderAware{

        // Gunakan Lombok agar tidak ribet buat Setter manual
        @Setter
        private org.springframework.core.io.ResourceLoader resourceLoader;

        public String getText() throws Exception{
        /*
            - Method getResource() memiliki beberapa parameter
            1. classpath    --> classpath:/yourPackage/yourFileName.properties (Mengambil resource dari classPath (isi Project)
            2. file         --> file:///yourPath/yourFileName.properties (Mengambil resource dari file system)
            3. https        --> https://yourDomain/yourFileName.properties (Mengambil resource dari http)
         */
            Resource resource = resourceLoader.getResource("classpath:/text/sample.txt");

            try(var inputStream = resource.getInputStream()){ // Aambil semua Stream dari file resource
                return new String(inputStream.readAllBytes()); // Ambil semua bytes dan convert ke String
            }
        }
    }
}
