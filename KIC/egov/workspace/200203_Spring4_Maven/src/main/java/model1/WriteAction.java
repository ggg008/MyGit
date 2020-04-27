package model1;

public class WriteAction
{
	public WriteAction()
	{
		System.out.println("▷ 생성자 호출 : WriteAction() " + this.getClass().getName());		
	}
	
	public WriteAction(BoardTO boardTO)
	{
		System.out.println("▷ 생성자 호출 : WriteAction(BoardTO boardTO) " + this.getClass().getName());				
	}
	
	public WriteAction(BoardTO boardTO, String name)
	{
		System.out.println("▷ 생성자 호출 : WriteAction(BoardTO boardTO, String name) " + this.getClass().getName());				
	}	
	
	public void execute()
	{
		System.out.println("▶ 실행 메서드 호출");	
		
		return ;
	}
	
	public void execute(int x)
	{
		System.out.println("안녕하세요");
	}
	
}
