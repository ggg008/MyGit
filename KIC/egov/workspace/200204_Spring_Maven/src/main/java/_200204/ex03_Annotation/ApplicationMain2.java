package _200204.ex03_Annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import _200204.ex03_Annotation.di.BeanConfig;



public class ApplicationMain2
{

	public static void main(String[] args)
	{
		//1
//		BoardTO boardTO = new BoardTO();
//		boardTO.setSeq(1);
//		boardTO.setSubject("제목");
//		
//		System.out.println(boardTO.getSeq());
//		System.out.println(boardTO.getSubject());
		
		//xml -> annotation
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		
		BoardTO boardTO = context.getBean("boardTO", BoardTO.class);
		
		System.out.println(boardTO.getSeq());
		System.out.println(boardTO.getSubject());
		
		context.close();

	}

}
