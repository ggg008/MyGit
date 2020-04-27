package _191119_Thread;

public class P547ThreadEx01
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Go g = new Go();
		Come c= new Come();
		
//		g.run();
		
		
		//스레드의 실행(병렬처리 -> cpu활용률이 좋아짐)
		//순차 실행이 아님을 유의
		
		g.start();
		c.start();
		
		
	}

}
