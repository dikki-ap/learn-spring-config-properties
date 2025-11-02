package dikki_dev.learn_spring_config_properties.profile;

import dikki_dev.learn_spring_config_properties.interfaces.SayHello;
import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class ProfileApplication {

    @Component
    @Profile("local") // Menentukan secara eksplisit, bahwa @Component ini "profile" nya adalah "local"
    // Jika tidak ditentukan maka secara default, nama "profile" nya adalah "default"
    public static class ProfileAppLocal implements SayHello {
        @Override
        public String sayHello(String name) {
            return "Hello " + name + " from Local";
        }
    }

    @Component
    @Profile("production") // Menentukan secara eksplisit, bahwa @Component ini "profile" nya adalah "production"
    // Jika tidak ditentukan maka secara default, nama "profile" nya adalah "default"
    public static class ProfileAppProduction implements SayHello {
        @Override
        public String sayHello(String name) {
            return "Hello " + name + " from Production";
        }
    }

    // Mencoba implementasi "EnvironmentAware" interface untuk mengambil profile apa saja yang aktif
    @Component
    public static class SampleActiveProfiles implements EnvironmentAware{

        @Setter
        private Environment environment;

        public String[] getActiveProfiles(){
            // Menggunakan object "Environment" dan method ".getActiveProfiles()"
            // Return value nya adalah String[] (Array of String)
            return environment.getActiveProfiles();
        }
    }
}
