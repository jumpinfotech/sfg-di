package guru.springframework.sfgdi;

import guru.springframework.sfgdi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

// this application starts + finishes > there's no web server configured.
@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		// get a handle on the ApplicationContext
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		// We don't create MyController object with the new keyword - spring handles creating a new instance + places it in the context.
		// Inversion of control - Spring Framework manages MyController's construction.
		// The context is asked for an instance of MyController, I need a cast as it returns just an object type. 
		// By default when Spring creates beans, the string name of the bean is going to be the class name with a lower case 1st letter.
		// When Spring starts up it scans for beans + creates them in the Spring context. 
		// MyController has no @Qualifier for GreetingService so the PrimaryGreetingService which is marked @Primary is injected.
		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("------- Primary Bean");
		// call sayHello method of myController class.
		System.out.println(myController.sayHello());

		System.out.println("------ Property");
		// we ask the context for an instance 
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------- Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-------- Constructor" );
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}
