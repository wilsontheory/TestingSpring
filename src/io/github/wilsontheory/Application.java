package io.github.wilsontheory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		context.registerShutdownHook();
		Messenger obj = (Messenger) context.getBean("yoWorld"); //alias for HelloWorld.class
		obj.getMessage();
	}
}