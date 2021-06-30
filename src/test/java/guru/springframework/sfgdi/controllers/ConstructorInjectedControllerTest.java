package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// using the constructor is the most preferred method for dependency injection
class ConstructorInjectedControllerTest {

    ConstructorInjectedController controller;

    // setUp() we are doing the Dependency Injection / acting as the inversion of control:-
    @BeforeEach
    void setUp() {
        // I am mimicking what the spring framework would be doing by instantiating ConstructorInjectedController.
        // this was the original code:-
        // controller = new ConstructorInjectedController(new GreetingServiceImpl());
        controller = new ConstructorInjectedController(new ConstructorGreetingService());
    }

    @Test
    void getGreeting() {

        System.out.println(controller.getGreeting());

    }
}
