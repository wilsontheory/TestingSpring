
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		context.registerShutdownHook();
		HelloWorld obj = (HelloWorld) context.getBean("yoWorld");
		obj.getMessage();
	}
}