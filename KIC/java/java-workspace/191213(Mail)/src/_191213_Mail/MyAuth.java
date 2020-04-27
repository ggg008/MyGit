package _191213_Mail;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuth extends Authenticator
{
	//https://myaccount.google.com/lesssecureapps
	private String userName;
	private String password;
	
	public MyAuth(String userName, String password)
	{
		this.userName = userName;
		this.password = password;
	}
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication()
	{
		// TODO Auto-generated method stub
		return new PasswordAuthentication(userName, password);
	}
}
