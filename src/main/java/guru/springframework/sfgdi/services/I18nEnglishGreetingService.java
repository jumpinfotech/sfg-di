package guru.springframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by jt on 12/27/19.
 */
// i18nService is the bean name given, instead of the default value i18nEnglishGreetingService

// @Service                has the name i18nEnglishGreetingService (same as class name, 1st letter lowercase)
// @Service("i18nService") has the name i18nService

// If 2 or more classes have the same name (this means same interface name??), then use @Service with parameter.

// Another explanation of the above, 2 classes implement CustomerRepository:
//
// @Repository
// public class MyCustomerRepositoryImpl implements CustomerRepository { }
// 
// @Repository
// public class OtherCustomerRepositoryImpl implements CustomerRepository { }
// Without differentiation between both CustomerRepository's we get an exception - the bean to inject is unknown:
// 
// public class SomeClass {
//     @Autowired
//     private CustomerRepository customerRepository;
// }
// 
// Add a name to each implementation:
// 
// @Repository("myRepository")
// public class MyCustomerRepositoryImpl implements CustomerRepository { }
// 
// @Repository("otherRepository")
// public class OtherCustomerRepositoryImpl implements CustomerRepository { }
// Ambiguity is solved:
// 
// public class SomeClass {
//     @Autowired
//     @Qualifier("myRepository")
//     private CustomerRepository customerRepository;
// }
// In this project we seem to be naming the GreetingService bean the same, 
// and solving the ambiguity using profiles.    

// EN profile added
@Profile("EN")
@Service("i18nService")
public class I18nEnglishGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "Hello World - EN";
    }
}
