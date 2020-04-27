package spring;

public class HelloSpring implements Hello {

	public HelloSpring() {
		System.out.println(this.getClass().getName() + " 생성자 호출");
	}
	
	@Override
	public void sayHello(String name)
	{
		System.out.println(name + "님 안녕하세요");
	}

}
