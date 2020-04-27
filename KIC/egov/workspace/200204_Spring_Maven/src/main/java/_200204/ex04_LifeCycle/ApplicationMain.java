package _200204.ex04_LifeCycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationMain
{

	public static void main(String[] args)
	{
//		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:_200204/ex04_LifeCycle/context.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
		
		WriteAction action = context.getBean("action", WriteAction.class);
		action.execute();
		
		context.close();

	}

}
