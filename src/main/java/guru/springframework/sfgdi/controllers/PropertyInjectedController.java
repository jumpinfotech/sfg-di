package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by jt on 12/26/19.
 */

// No bean named 'propertyInjectedController' available
// Can happen on Spring startup + no bean named PropertyInjectedController is found.
// @Controller - indicates it's a managed component, add this to prevent the above error.
@Controller
public class PropertyInjectedController {

    // 3 classes implement GreetingService, take PropertyInjectedGreetingService
    @Qualifier("propertyInjectedGreetingService")
    // tells Spring to inject an instance of the GreetingService
    @Autowired
    public GreetingService greetingService;

    public String getGreeting(){
    // java.lang.NullPointerException - happens when greetingService above has no @Autowired annotation 
        return greetingService.sayGreeting();
    }

}
