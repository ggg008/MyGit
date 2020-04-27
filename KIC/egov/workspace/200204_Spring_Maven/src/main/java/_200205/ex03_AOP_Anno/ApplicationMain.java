package _200205.ex03_AOP_Anno;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import _200205.ex03_AOP_Anno.action.Action;
import _200205.ex03_AOP_Anno.di.BeanConfig;


public class ApplicationMain
{

	public static void main(String[] args)
	{
//		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:_200205/ex03_AOP_Anno/context.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		Action action = context.getBean("action", Action.class);

		System.out.println();
		action.execute();
		System.out.println();
		action.execute1();
		System.out.println();
		
		context.close();

	}

}
