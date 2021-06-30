package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by jt on 12/26/19.
 */
// setter based controller
@Controller
public class SetterInjectedController {

    private GreetingService greetingService;

    // 3 classes implement GreetingService, take SetterInjectedGreetingService
    @Qualifier("setterInjectedGreetingService")
    // the GreetingService is set by the setter, 
    // @Autowired - tells the Spring Framework that we want a GreetingService injected into this bean
    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
