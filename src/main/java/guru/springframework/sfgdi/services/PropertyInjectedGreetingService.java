package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

/**
 * Created by jt on 12/27/19.
 */
// when @Service annotation was missing we got an error:-
// ....PropertyInjectedController required a bean of type ‘guru.springframework.sfgdi.services.GreetingService' that could not be found.
// adding @Service means Spring brings an instance of this into its context. 
// There's no effective functional difference between service, controller + component, 
// these different Spring stereotypes indicate it's a Spring managed component. 
// It indicates how you intend to utilize it. 
@Service
public class PropertyInjectedGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - Property";
    }
}
