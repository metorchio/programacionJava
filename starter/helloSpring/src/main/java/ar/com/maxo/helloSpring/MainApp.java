package ar.com.maxo.helloSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		printXmlBean();
		printAnnotationBean();
	}

	public static void printXmlBean() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

		HelloWorld obj = (HelloWorld) context.getBean("helloBean");
		obj.printHello();
	}

	public static void printAnnotationBean() {
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloSpringConfig.class);

		HelloWorld helloWorld = context.getBean(HelloWorld.class);
		helloWorld.printHello();
	}

}
