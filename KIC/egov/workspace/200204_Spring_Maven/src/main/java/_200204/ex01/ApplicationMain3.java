package _200204.ex01;

import java.util.ArrayList;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ApplicationMain3
{

	public static void main(String[] args)
	{

		System.out.println(" 1. userList "); 
//		ArrayList<String> userList = new ArrayList<String>();
//		userList.add("홍길동");
//		userList.add("박문수");
//		
//		BoardListTO listTO = new BoardListTO();
//		listTO.setUserList(userList);
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("classpath:_200204/ex01/beans3.xml");
		
		BoardListTO listTO = context.getBean("listTO", BoardListTO.class);

		
		ArrayList<String> userList2 = listTO.getUserList();
		for(String user : userList2) {
			System.out.println(user);			
		}
		
		System.out.println("=============================");
		
		System.out.println(" 2. boardList ");
//		BoardTO to1 = new BoardTO();
//		to1.setSeq(1);
//		to1.setSubject("제목1");
//		
//		BoardTO to2 = new BoardTO();
//		to2.setSeq(2);
//		to2.setSubject("제목2");
//		
//		ArrayList<BoardTO> boardList = new ArrayList<BoardTO>();
//		
//		boardList.add(to1);
//		boardList.add(to2);
//				
//		BoardListTO listTO2 = new BoardListTO();
//		listTO2.setBoardList(boardList);
		
		BoardListTO listTO2 = context.getBean("listTO2", BoardListTO.class);
		
		for(BoardTO bTo : listTO2.getBoardList()) {
			System.out.println(" " +bTo.getSeq()+ " " + bTo.getSubject());
		}
		
		context.close();
		
	}

}
