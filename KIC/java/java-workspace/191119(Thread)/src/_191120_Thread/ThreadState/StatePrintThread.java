package _191120_Thread.ThreadState;

public class StatePrintThread extends Thread
{
	//쓰레드의 상태를 체크하는 모니터링 클래스
	private Thread targetThread;
	
	public StatePrintThread(Thread targetThread) 
	{
		this.targetThread = targetThread;
	}
	
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		while(true) {
			//쓰레드의 상태
			Thread.State state = targetThread.getState();
			
			//출력 부분
			System.out.println("현재 상태 : " + state);
			
			if(state == Thread.State.NEW) {
				targetThread.start();
			}
			
			if(state == Thread.State.TERMINATED) {
				break;
			}
			
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
