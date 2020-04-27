package _191120_Thread;

import _191120_Thread.SharedResource.Account;
import _191120_Thread.SharedResource.Client;

public class P566ATM_SR
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		Account account = new Account();
		
		Client client1 = new Client(account);
		Client client2 = new Client(account);
		
		Thread t1 = new Thread(client1);
		Thread t2 = new Thread(client2);
		
		t1.start();
		t2.start();		
		
	}

}
