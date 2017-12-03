package io.github.wilsontheory;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class ExtraBean {
	public String extraBeanMessage;

	public String getExtraBeanMessage() {
		return extraBeanMessage;
	}

	public void setExtraBeanMessage(String extraBeanMessage) {
		this.extraBeanMessage = extraBeanMessage;
	}
	
	@PostConstruct
	public void initExtraBean(){
//		System.out.println("Just made an ExtraBean obj, method called by @PostConstruct");
	}
	
	@PreDestroy
	public void destroyExtraBean(){
		System.out.println("Gonna destroy an ExtraBean, method called by @PreDestroy annotation!");
	}
}
