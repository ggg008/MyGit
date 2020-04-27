package _191120_Thread.SharedResource;

public class Client implements Runnable
{
	private Account account;

	public Client(_191120_Thread.SharedResource.Account account)
	{
		this.account = account;
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		while(0 < account.getBalance()) {
			int money = (int)(Math.random() * 3 + 1) * 100;// 100~300 정수형 버림때문에 400불가
			account.withdraw(money);
			
			System.out.println("통장 잔고 : " + account.getBalance());
		}
		
	}

}
