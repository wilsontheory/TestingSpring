package io.github.wilsontheory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class UberBean implements ApplicationEventPublisherAware {
	//declared as a generic bean with @Component, can be referenced by other beans as uberBean
	//these types of annotations are "Stereotype annotations"
	//others include @Service for services, @Repository for data pojos, @Controller for MVC
	//ApplicationEventPublisherAware makes ApplicationContext give this thing an event publisher through setter
	private String uberBeanMessage = "Hello, I'm the uber bean";
	
	private ApplicationEventPublisher applicationEventPublisher;

	public String getUberBeanMessage() {
		applicationEventPublisher.publishEvent(new MyEvent(this));
		return uberBeanMessage;
	}

	public void setUberBeanMessage(String uberBeanMessage) {
		this.uberBeanMessage = uberBeanMessage;
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher aep) {
		this.applicationEventPublisher = aep;
	}

}
