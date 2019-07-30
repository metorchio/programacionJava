package ar.com.maxo.helloMaven;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		GreetWorld obj = (HelloWorldImpl) context.getBean("helloBean");
		obj.greet();
		
		GreetWorld obj2 = (GoodbyeWorldImpl) context.getBean("helloBean.2");
		obj2.greet();
		
	}

}
