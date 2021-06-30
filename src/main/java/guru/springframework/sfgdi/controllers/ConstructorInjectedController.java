package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by jt on 12/26/19.
 */
@Controller
public class ConstructorInjectedController {
    private final GreetingService greetingService;

    // The autowired annotation on the constructor is optional, (since Spring 4.2 - he thinks). It automatically autowires. 
    // Some developers aren't aware of this.
    // The qualifier tells Spring which bean you want injected.
    // GreetingService has 3 Spring components that qualify for this Dependency Injection - all 3 implement the GreetingService interface.
    // Spring throws an error when it can't determine which to add:
    // Parameter 0 of constructor in ... .ConstructorInjectedController required a single bean, but 3 were found: 
    // - constructorGreetingService: ... - propertyInjectedGreetingService: ... - setterInjectedGreetingService: ...
    // Action: Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, 
    // or using @Qualifier to identify the bean that should be consumed
    
    // With @Qualifier Spring knows which service instance to get, remember lower case for the bean name.
    public ConstructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting() {
        return greetingService.sayGreeting();
    }
}
