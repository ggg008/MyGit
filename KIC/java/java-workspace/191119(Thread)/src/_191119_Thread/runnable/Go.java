package _191119_Thread.runnable;

public class Go implements Runnable
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
