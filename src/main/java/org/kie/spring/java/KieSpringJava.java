package org.kie.spring.java;

import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KieSpringJava {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        KieBase kbase = (KieBase) applicationContext.getBean("kie-spring-rules");
        System.out.println("kbase == "+kbase);

        KieSession kieSession = (KieSession) applicationContext.getBean("ksession2");
        System.out.println("kieSession == "+kieSession);

        org.kie.spring.beans.Person p = new org.kie.spring.beans.Person("HAL", 35);
        System.out.println("Is "+p.getName()+" Happy: "+p.isHappy()+".");
        kieSession.insert(p);
        kieSession.fireAllRules();
        System.out.println("Is "+p.getName() + " Happy after executing rules: "+p.isHappy());
    }
}
