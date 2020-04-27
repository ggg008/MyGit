
class SingletonClass{
	private static SingletonClass instance = null;
	private SingletonClass() {};
	
	public static SingletonClass getInstance() {
		if(instance == null)
		{
			instance = new SingletonClass();
		}
		return instance;
	}
	
	public void sayHello() {
		System.out.printf("Hello 나는 %s의 %s이다.\n", this.getClass().getName(), this);
	}
}

public class MySingletonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingletonClass sc1 = SingletonClass.getInstance();
		SingletonClass sc2 = SingletonClass.getInstance();
		System.out.printf("두 객체는 같은가? %b\n", sc1 == sc2);
		sc1.sayHello();
		sc2.sayHello();
		
		System.out.println("---------");
		
		
	}

}
