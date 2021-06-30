package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.stereotype.Controller;

/**
 * Created by jt on 12/26/19.
 */
@Controller // added steorotype
public class MyController {

    private final GreetingService greetingService;

    // @Qualifier takes precedence over @Primary, 
    // we take the @Primary bean when there is no @Qualifier, like here:-
    public MyController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
