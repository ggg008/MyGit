package _191120_Thread;


public class UnPgThread_AnonymousClass
{
	//쓰레드	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		Thread t1 = new Thread(new Runnable() {//익명 내부 클래스
			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				for(int i = 0; i <= 10; ++i) {
					System.out.println("go : " + i);
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {//익명 내부 클래스 <= 스레드 이렇게 자주사용(사족)
			
			@Override
			public void run()
			{
				// TODO Auto-generated method stub
				for(int i = 0; i <= 10; ++i) {
					System.out.println("come : " + i);
				}
			}
		});
		
		t1.start();
		t2.start();

	}

}
