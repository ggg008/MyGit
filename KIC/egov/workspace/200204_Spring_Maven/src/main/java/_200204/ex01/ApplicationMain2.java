package _200204.ex01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationMain2
{

	public static void main(String[] args)
	{
		// 스프링에 위임
//		 BoardTO bTo = new BoardTO();
//		 bTo.setSeq(1);
//		 bTo.setSubject("제목");
//		 
//		 WriteAction writeAction = new WriteAction();
//		 writeAction.setbTo(bTo);
//		 
//		 bTo = writeAction.getbTo();
//
//		 System.out.println(bTo.getSeq());
//		 System.out.println(bTo.getSubject());
		 
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:_200204/ex01/beans2.xml");

//		BoardTO bTo = (BoardTO) context.getBean("bto");
		BoardTO bTo = context.getBean("bto", BoardTO.class);
		
//		WriteAction writeAction = context.getBean("writeAction", WriteAction.class);
//		BoardTO bTo = writeAction.getBoardTO();

		System.out.println(bTo.getSeq());
		System.out.println(bTo.getSubject());

		bTo.setSeq(2222);
		
		System.out.println(bTo.getSeq());
		
		context.close();

		
		
	}

}
