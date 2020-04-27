package spring;

public class HelloSpring3 implements Hello
{
	private String name = "";
	
	public HelloSpring3() {
		System.out.println(this.getClass().getName() + " 생성자 호출");
	}

	public HelloSpring3(String name) {
		this.name = name;
		System.out.println(this.getClass().getName() + " 생성자 호출 파라메터값 : " + this.name);
	}

	@Override
	public void sayHello(String name)
	{
		System.out.println("Hello " + name);
	}

	public void sayHello()
	{
		System.out.println(name + " 님 안녕하세요");
	}
}
