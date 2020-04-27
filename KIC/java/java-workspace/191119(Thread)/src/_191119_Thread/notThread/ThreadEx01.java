package _191119_Thread.notThread;

public class ThreadEx01
{

	public static void main(String[] args)
	{	
		// TODO Auto-generated method stub
		// 쓰레드가 아닐시
		
		Go g = new Go();
		Come c = new Come();
		
		g.go();
		c.come();
	}

}
