package _200205.ex01_AOP;
import org.springframework.context.support.GenericXmlApplicationContext;

import _200205.ex01_AOP.action.Action;

public class ApplicationMain
{

	public static void main(String[] args)
	{
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:_200205/ex01_AOP/context.xml");
		
//		Action action = context.getBean("action", Action.class);
		Action action = context.getBean("proxy", Action.class);
		
		action.execute1();
		
		context.close();
		

	}

}
