package _200205.ex02_AOP;

import org.springframework.context.support.GenericXmlApplicationContext;

import _200205.ex02_AOP.action.Action;

public class ApplicationMain
{

	public static void main(String[] args)
	{
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:_200205/ex02_AOP/beanContext.xml");
		
		Action action = context.getBean("action", Action.class);

		System.out.println();
		action.execute();
		System.out.println();
		action.execute1();
		System.out.println();
		
		context.close();

	}

}
