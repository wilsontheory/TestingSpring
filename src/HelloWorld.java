import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;

public class HelloWorld implements InitializingBean, DisposableBean {
	//can implement ApplicationContextAware for access to context, other interfaces do similar
   private String message;
   private ExtraBean extraBeanA;
   private ExtraBean extraBeanB;

   public void setMessage(String message){
	   //used by property tag in XML
      this.message  = message;
   }
   public void getMessage(){
      System.out.println("Message : " + message);
      System.out.println("ExtraMessage from ExtraBeanA: " + extraBeanA.extraBeanMessage);
      System.out.println("ExtraMessage from ExtraBeanB: " + extraBeanB.extraBeanMessage);
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
}