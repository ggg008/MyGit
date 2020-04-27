package _191120_Thread;
import java.time.LocalTime;

public class P555SleepTest1
{
	static class Timer extends Thread
	{
		@Override
		public void run()
		{
			// TODO Auto-generated method stub
			
			for(int i = 0; i < 3; ++i) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				System.out.println("째깍 : " + LocalTime.now());
			}
		}
	}
	

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		Timer timer = new Timer();
		timer.start();

	}

}
