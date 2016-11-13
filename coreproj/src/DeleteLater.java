class DeleteLater {

}

public class CustomerService
{
	String message;

	public String getMessage(){
		return message;
	}

	public void setMessage(String message){
		this.message= message;
	}

	@PostConstruct
	public void initIt() throws Exception{
		System.out.println("Init method after properties are set : "+ message);
	}

	@PreDestroy
	public void cleanUp()throws Exception{
		System.out.println("Spring Container is destroy! Customer clean up");
	}
}


	<beanclass="org.springframework.context.annotation.CommonAnnotationBeanPostProcessor"/>
 
	<beanid="customerService" class="CustomerService">
		<property name="message" value="i'm property message"/>
	</bean>
 

