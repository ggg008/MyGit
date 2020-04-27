package day16Class.Collection;

public class Phone
{
	String number;

	public Phone(String number)
	{
		this.number = number;
	}

	@Override
	public String toString()
	{
		return "[Phone Number=" + number + "]";
	}
}
