package io.github.wilsontheory;
import org.springframework.stereotype.Component;

@Component
public class UberBean {
	//declared as a bean with @Component, can be referenced by other beans as uberBean
	//these types of annotations are "Stereotype annotations"
	private String uberBeanMessage = "Hello, I'm the uber bean";

	public String getUberBeanMessage() {
		return uberBeanMessage;
	}

	public void setUberBeanMessage(String uberBeanMessage) {
		this.uberBeanMessage = uberBeanMessage;
	}

}
