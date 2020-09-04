import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MyTest2
{
	ExecutorService executorService = Executors.newFixedThreadPool(2);
	public MyTest2() throws InterruptedException
	{
		// TODO Auto-generated method stub

		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
		System.out.println("운용가능 프로세서 갯수2 " +threadPoolExecutor.getPoolSize());
		
		for (int i = 0; i < 10; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run()
				{
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[총 스레드 개수: " + poolSize + "] 작업 스레드 이름: " + threadName);
					
					int value = Integer.parseInt("숫자");
				}
			};
			
//            executorService.execute(runnable);
			executorService.submit(runnable);
			
			Thread.sleep(10);
		}
		executorService.shutdown();		
	}

	public static void main(String[] args) throws InterruptedException
	{
		MyTest2 mt = new MyTest2();		
	}

}
