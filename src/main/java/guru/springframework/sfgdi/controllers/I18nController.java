package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by jt on 12/27/19.
 */
// i18N is a common abbreviation for internationalization. 
// internationalization begins with an I then has 18 characters then ends with N - so now you know!
@Controller
public class I18nController {

    private final GreetingService greetingService;

    // i18nService could be I18nEnglishGreetingService or I18NSpanishService - without profiles this causes an error:
    // ConflictingBeanDefinitionException I think    
    public I18nController(@Qualifier("i18nService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello(){
        return greetingService.sayGreeting();
    }
}
