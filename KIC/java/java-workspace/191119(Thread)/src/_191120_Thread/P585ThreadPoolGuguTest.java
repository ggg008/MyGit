package _191120_Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class P585ThreadPoolGuguTest
{
	private static int[][] gugudan = new int[9][9];
	private static int dans = 0;
	
	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub
		
		
		int processCnt = Runtime.getRuntime().availableProcessors();
		System.out.println("VM에서 운용가능한 프로세서 개수: " + processCnt);
		ExecutorService es = Executors.newFixedThreadPool(processCnt);
		System.out.println("작업 시작 전: " + es);
		
		Callable<String> callable = () -> {
			int dan = ++dans;
			for(int i = 1; i < 10; ++i) {
				gugudan[dan - 1][i - 1] = dan * i;				
			}
			
			return dan + " 작업완료, " + Thread.currentThread().getName();
		};
		
		for(int i =0; i < 9; ++i) {
			Future<String> guguFuture = es.submit(callable);
			new Thread( () -> {
				try {
					System.out.println(guguFuture.get());
				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}).start();
		}
		
		
		Thread.sleep(1000 * 2);
		System.out.println("작업 종료 후: " + es);
		
		System.out.println();
		System.out.println();
		
		
		System.out.println("int[][] gugudan 출력");
		for(int[] dans : gugudan) {
			for(int num : dans) {
				System.out.print(num + "\t");
			}
			System.out.println();			
		}
		es.shutdown();
	}

}
