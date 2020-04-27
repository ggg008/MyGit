package spring;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AppllicationMain2
{
	public static void main(String[] args)
	{	
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:spring/context.xml");
		
//		HelloBean helloBean = (HelloBean) context.getBean("helloBean");
//		helloBean.sayHello();
		
		HelloBean helloBean11 = (HelloBean) context.getBean("helloBeanSingle");
		HelloBean helloBean12 = (HelloBean) context.getBean("helloBeanSingle");
		
		//공유객체(static)
		//한번 만들고 재사용(프로그램 종료시)
		//참조주소 확인
		System.out.println(helloBean11);
		System.out.println(helloBean12);

		HelloBean helloBean21 = (HelloBean) context.getBean("helloBeanProto");
		HelloBean helloBean22 = (HelloBean) context.getBean("helloBeanProto");
		
		//계속객체 생성
		System.out.println(helloBean21);
		System.out.println(helloBean22);
		

		HelloBean helloBean13 = (HelloBean) context.getBean("helloBeanSingle2");
		System.out.println(helloBean13);
				
		context.close();
	}

}
