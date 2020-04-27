package _191120_Thread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P556JoinTest
{
	static class GuguThread extends Thread
	{
		private int dan;
		String[] result = new String[9];
		
		public GuguThread(int dan)
		{
			this.dan = dan;
		}
		
		@Override
		public void run()
		{
			// TODO Auto-generated method stub
			for(int i = 0 ; i < result.length; ++i) {				
				result[i] = dan + "*" + (i + 1) + "=" + (dan * (i + 1));
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(dan + "단완료\t");
		}
		
		
	}
	
	

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		
		List<GuguThread> gugus = new ArrayList<P556JoinTest.GuguThread>();
		
		for(int i = 1; i < 10; ++i) {
			GuguThread gugu = new GuguThread(i);
			gugus.add(gugu);
			gugu.start();
		}
		
		
		for(GuguThread gugu : gugus) {
			try {
				gugu.join();// 순차 정렬
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("\n구구단 출력");
		for(GuguThread gugu : gugus) {
			System.out.println(Arrays.toString(gugu.result));
		}
	}

}
