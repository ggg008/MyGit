package basic;

public class ApplicationMain
{

	public static void main(String[] args)
	{
		// 의존대상
		HelloSpring1 hello1 = new HelloSpring1();
		
		// 의존
		hello1.sayHello("홍길동");
				
	}

}
