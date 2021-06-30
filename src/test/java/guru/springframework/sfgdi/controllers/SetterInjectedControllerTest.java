package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SetterInjectedControllerTest {

    SetterInjectedController controller;

    // setUp() we are doing the Dependency Injection / acting as the inversion of control:-
    @BeforeEach
    void setUp() {
        controller = new SetterInjectedController();
        // using the setter to inject the GreetingService, code was changed it looked like this initially:-
        // controller.setGreetingService(new GreetingServiceImpl());
        controller.setGreetingService(new ConstructorGreetingService());
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());

    }
}
