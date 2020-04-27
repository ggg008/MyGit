package _191119_Thread;

public class Go extends Thread
{
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		
		//작업내용 기술
		for (int i = 1; i <= 10; ++i) {
			System.out.println("go : " + i);
		}
	}
}
