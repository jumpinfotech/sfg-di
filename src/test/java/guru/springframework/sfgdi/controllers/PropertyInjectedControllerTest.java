package guru.springframework.sfgdi.controllers;

import guru.springframework.sfgdi.services.ConstructorGreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// properties are the least preferred method for dependency injection, don't use this approach
// simple JUnit 5 test
class PropertyInjectedControllerTest {

    PropertyInjectedController controller;

    // setUp() we are doing the Dependency Injection / acting as the inversion of control:-
    @BeforeEach
    void setUp() {
        // mimicking what the spring framework would do
        controller = new PropertyInjectedController();

        // accessing that public field directly - not recommended
        controller.greetingService = new ConstructorGreetingService();
    }

    @Test
    void getGreeting() {

        System.out.println(controller.getGreeting());
    }
}
