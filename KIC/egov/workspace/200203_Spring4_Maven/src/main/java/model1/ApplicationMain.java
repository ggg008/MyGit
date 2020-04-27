package model1;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationMain
{

	public static void main(String[] args)
	{
		/*
		WriteAction writeAction1 = new WriteAction();
		writeAction1.execute();
		
		//클래스가 들어가는 생성자
		WriteAction writeAction2 = new WriteAction(new BoardTO());
		writeAction2.execute();
		*/
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:model1/context.xml");
		
		WriteAction writeAction1 = (WriteAction) context.getBean("writeAction1");//객체 생성 기능의 상실
		writeAction1.execute();
		
		
		context.close();
	}

}
