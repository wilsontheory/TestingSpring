package io.github.wilsontheory;
import javax.annotation.Resource;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Bean;

public class HelloWorld implements InitializingBean, DisposableBean, Messenger {
	//can implement ApplicationContextAware for access to context, other interfaces do similar
   private String message;
   private ExtraBean extraBeanA;
   private ExtraBean extraBeanB;
   private ExtraBean extraBeanC;
   private UberBean uberBean;

   @Required
   public void setMessage(String message){
	   //used by property tag in XML, required annotation prevent NPE
      this.message  = message;
   }
   public void getMessage(){
      System.out.println("Message : " + message);
      System.out.println("ExtraMessage from ExtraBeanA: " + extraBeanA.extraBeanMessage);
      System.out.println("ExtraMessage from ExtraBeanB: " + extraBeanB.extraBeanMessage);
      System.out.println("ExtraMessage from ExtraBeanC: " + extraBeanC.extraBeanMessage);
      System.out.println("UberBean message: " + uberBean.getUberBeanMessage());
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
}