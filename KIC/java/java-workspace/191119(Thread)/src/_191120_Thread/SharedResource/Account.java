package _191120_Thread.SharedResource;

public class Account
{
	private int balance = 1000;

	public int getBalance()
	{
		return balance;
	}
	
	public synchronized void withdraw(int money) //걸어두면 스레드가 전스레드 일끝날때까지 기다린후 처리
	{
		if(money <= balance) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
			balance -= money;
		} else {
			System.out.println("잔고 없음");
		}
		
	}
}
