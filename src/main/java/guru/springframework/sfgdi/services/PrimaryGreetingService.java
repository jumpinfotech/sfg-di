package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by jt on 12/27/19.
 */
// If 1 bean is @Primary + the others are not, when Spring is in doubt it uses the one marked primary. 
// This happens when nothing is marked @Qualifier in the object that has a dependency injected into it. 
@Primary
@Service
public class PrimaryGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "Hello World - From the PRIMARY Bean";
    }
}
