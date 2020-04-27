package _191119_Thread.runnable;


//class MyG<T>{//제네릭 한번 써봄
//	
//	T item;
//
//	public T getItem()
//	{
//		return item;
//	}
//
//	public void setItem(T item)
//	{
//		this.item = item;
//	}
//}


public class P551ThreadEx1
{
		
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		//runnable를 이용한 인터페이스 구현을 통한 쓰레드 실행
		
//		Go g = new Go();
//		Come c= new Come();
		
		
		Thread t1 = new Thread(new Go());
		Thread t2 = new Thread(new Come());
		
		t1.start();
		t2.start();
		
		
//		System.out.printf("%s", "으아아\n아아아");
	}

}
