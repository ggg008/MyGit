package _200204.ex02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import _200204.ex02.action.BoardAction;
import _200204.ex02.action.ListAction;
import _200204.ex02.model.BoardDAO;

public class ApplicationMain
{

	public static void main(String[] args)
	{
		//1
//		BoardDAO dao = new BoardDAO();
//		BoardAction action = new ListAction(dao);
		
		//2
//		GenericXmlApplicationContext context = new GenericXmlApplicationContext("_200204/ex02/beansContext.xml");
//		BoardAction action  = context.getBean("listAction", ListAction.class);
		
		//3
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
		BoardAction action  = context.getBean("listAll", ListAction.class);
		BoardAction action2  = context.getBean("listAll", ListAction.class);
		
		action.execute();
		System.out.println(action);
		System.out.println(action2);

		context.close();
	}

}
