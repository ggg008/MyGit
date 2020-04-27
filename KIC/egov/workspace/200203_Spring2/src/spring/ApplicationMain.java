package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain
{

	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:spring/context.xml");//context 경로
		
		//의존대상
		HelloSpring helloSpring1 = (HelloSpring) ctx.getBean("helloSpring2");//context bean name : XML을 통해 의존관계를 분리하여 성립
		
		//의존
		//호출시에만 생성하는게 아님
		helloSpring1.sayHello("홍길동");
		
	}

}
