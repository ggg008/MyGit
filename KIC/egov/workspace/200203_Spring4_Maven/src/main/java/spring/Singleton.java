package spring;

public class Singleton
{
	private int i = 0;

	private static Singleton singleton = null;

	public static Singleton getInstance()
	{
		if (singleton == null) {
			singleton = new Singleton();
		}

		return singleton;
	}

	public void test(String ln)
	{
		System.out.println(ln);
	}
}
