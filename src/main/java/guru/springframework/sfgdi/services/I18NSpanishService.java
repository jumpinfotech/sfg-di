package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by jt on 12/27/19.
 */
// This bean has a ES + default profile
// When in application.properties we have no spring.profiles.active set then this "default" profile is considered active.
// This Spring component is part of the default profile. When no active profile is set, this bean will be used by the Spring context.    
@Profile({"ES", "default"})
@Service("i18nService")
public class I18NSpanishService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hola Mundo - ES";
    }
}
