package _191120_Thread;


public class P553PriorityTest
{
	static class MessengerThread extends Thread//클래스 내부 클래스(static)
	{
		//쓰레드 이름
		public MessengerThread(String name)
		{
			super(name);
			// TODO Auto-generated constructor stub
		}	
		
		@Override
		public void run()
		{
			// TODO Auto-generated method stub
			
			for(int i = 0; i < 40; ++i) {
				System.out.print(this.getName());
			}
		}
	}
	

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		Thread fThread = new MessengerThread("CallF ");
		Thread tThread = new MessengerThread("CallT ");
		fThread.setPriority(Thread.MIN_PRIORITY);//1
		tThread.setPriority(Thread.MAX_PRIORITY);//10 <= 우선순위는 높으나 먼저 실행되는건 아니다 호출확률이 높아질뿐..
		fThread.start();
		tThread.start();
		
	}

}
