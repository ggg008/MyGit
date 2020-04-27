package day16Class.Collection;

public class Phone2
{
	String number;
	Integer price;

	
	public Phone2(String number, Integer price)
	{
		this.number = number;
		this.price = price;
	}

	@Override
	public int hashCode()
	{
		System.out.println("call Phone2 hashCode()");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		System.out.println("call Phone2 equals()");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone2 other = (Phone2) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	
	@Override
	public String toString()
	{
		return "Phone2 [number=" + number + ", price=" + price + "]";
	}
}
