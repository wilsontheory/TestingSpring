package io.github.wilsontheory;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
	//to be published by UberBean
	public MyEvent(Object source) {
		super(source);
	}
	
	@Override
	public String toString(){
		return "Custom event received from UberBean before sending UberBeanMessage!";
	}

}
