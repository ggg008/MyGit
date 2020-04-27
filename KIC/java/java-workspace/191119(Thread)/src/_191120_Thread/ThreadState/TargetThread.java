package _191120_Thread.ThreadState;

public class TargetThread extends Thread
{
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		for(long i = 0; i<1000000000; ++i) {
			
		}
		
		try {
			// 1500ms 동안 잠시멈춤
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(long i = 0; i<1000000000; ++i) {	
			
		}
	}
}
