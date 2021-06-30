package guru.springframework.sfgdi.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// This bean implements the variety of interfaces that Spring Framework gives us to work with lifecycle events.
@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
        BeanFactoryAware, ApplicationContextAware {

    // Log output of this class, all the Spring interfaces that work with Spring bean lifecycle events have been implemented:-
    // CONTEXT COMES UP, LIFECYCLE EVENTS:-
    // ## I'm in the LifeCycleBean Constructor
    // ## My Bean Name is: lifeCycleDemoBean
    // ## Bean Factory has been set
    // ## Application context has been set
    // ## — Before Init - Called by Bean Post Processor
    // ## The Post Construct annotated method has been called
    // ## The LifeCycleBean has its properties set!
    // ## — After init called by Bean Post Processor
    // ...
    // CONTEXT SHUTS DOWN, LIFECYCLE EVENTS:-
    // ## The Predestroy annotated method has been called
    // ## The Lifecycle bean has been terminated

    public LifeCycleDemoBean() {
        System.out.println("## I'm in the LifeCycleBean Constructor");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("## My Bean Name is: " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## Bean Factory has been set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## Application context has been set");
    }

    public void beforeInit(){
        System.out.println("## - Before Init - Called by Bean Post Processor");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("## The Post Construct annotated method has been called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## The LifeCycleBean has its properties set!");
    }

    public void afterInit(){
        System.out.println("## - After init called by Bean Post Processor");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("## The Predestroy annotated method has been called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## The Lifecycle bean has been terminated");
    }
}
