package spring;

public class HelloBean
{
	private String name1;
	private String name2;
	
	public HelloBean()
	{
		System.out.println("디폴트 생성자");
	}
	
	public HelloBean(String name1, String name2)
	{
		System.out.println("String name1, String name2 생성자");
		
		this.name1 = name1;
		this.name2 = name2;
	}
	
	public void sayHello()
	{
		System.out.println("sayHello " + name1 +  "/" + name2);
	}
}
