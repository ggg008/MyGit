package spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AppllicationMain
{
	public static void main(String[] args)
	{	
		// 1번째
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/context.xml");

		// 2번째 방법
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:spring/context.xml");		
		
		// 다형성
//		Hello helloSpring = (HelloSpring) ctx.getBean("helloSpring1");
//		Hello helloSpring = (Hello) ctx.getBean("helloSpring1");
//		helloSpring.sayHello("홍길동");
//
//		helloSpring = (Hello) ctx.getBean("helloSpring2");
//		helloSpring.sayHello("박문수");
		
		HelloSpring3 helloSpring = (HelloSpring3) ctx.getBean("helloSpring4");
		helloSpring.sayHello();		
		
		
		ctx.close();

	}

}
