package _191119_Thread.runnable;

public class Come implements Runnable
{
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for (int i = 1; i <= 10; ++i) {
			System.out.println("come : " + i);
		}
	}
}
