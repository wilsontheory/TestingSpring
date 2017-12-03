package io.github.wilsontheory;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener implements ApplicationListener{
	//registered already due to component scanning
	@Override
	public void onApplicationEvent(ApplicationEvent e) {
		System.out.println("MyEventListener: " + e.toString());
	}

}
