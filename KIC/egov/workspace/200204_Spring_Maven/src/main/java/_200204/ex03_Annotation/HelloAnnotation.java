package _200204.ex03_Annotation;

public class HelloAnnotation implements Hello
{
	public HelloAnnotation()
	{
		System.out.println(this.getClass().getName() + "의 생성자 호출");
	}
	
	
	@Override
	public void sayHello(String name)
	{
		System.out.println(name + "님 안녕하세요");
	}

}
