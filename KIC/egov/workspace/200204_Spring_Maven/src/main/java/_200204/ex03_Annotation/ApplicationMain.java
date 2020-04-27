package _200204.ex03_Annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import _200204.ex03_Annotation.di.BeanConfig;

public class ApplicationMain
{

	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);//클래스 파일 호출
		
		HelloAnnotation helloAnnotation = context.getBean("helloAnnotation", HelloAnnotation.class);//메서드명, 타입
		helloAnnotation.sayHello("홍길동");
		
		context.close();

	}

}
