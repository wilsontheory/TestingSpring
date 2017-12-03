package io.github.wilsontheory;
import javax.annotation.Resource;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

public class HelloWorld implements InitializingBean, DisposableBean, Messenger {
	//can implement ApplicationContextAware for access to context, other interfaces do similar
   private String message;
   private ExtraBean extraBeanA;
   private ExtraBean extraBeanB;
   private ExtraBean extraBeanC;
   private UberBean uberBean;
   @Autowired
   private MessageSource messageSource;

   @Required
   public void setMessage(String message){
	   //used by property tag in XML, required annotation prevent NPE
      this.message  = message;
   }
   public void getMessage(){
      System.out.println("HelloWorld: Message : " + message);
      System.out.println("HelloWorld: Message from ExtraBeanA is " + extraBeanA.extraBeanMessage);
      System.out.println("HelloWorld: Message from ExtraBeanB is" + extraBeanB.extraBeanMessage);
      System.out.println("HelloWorld: Message from ExtraBeanC is: " + extraBeanC.extraBeanMessage);
      System.out.println("HelloWorld: UberBean message is " + uberBean.getUberBeanMessage());
      System.out.println("HelloWorld: get superbeanmessage from mymessages " + messageSource.getMessage("superbeanmessage", 
    		  new Object[]{"placeholder"}, "default superbeanmsg", null));
   }
   
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("properties were set on HelloWorld bean");
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("HelloWorld bean destroyed");
	}
	
	public void setExtraBeanA(ExtraBean extraBean) {
		this.extraBeanA = extraBean;
	}

	public void setExtraBeanB(ExtraBean extraBeanB) {
		this.extraBeanB = extraBeanB;
	}

	//some JSR250 annotations are supported in Spring
	@Resource(name="extraBeanC")
	public void setExtraBeanC(ExtraBean extraBeanC) {
		this.extraBeanC = extraBeanC;
	}
	
	public void setUberBean(UberBean uberBean){
		this.uberBean = uberBean;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
}