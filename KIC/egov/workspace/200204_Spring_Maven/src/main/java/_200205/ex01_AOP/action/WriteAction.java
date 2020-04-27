package _200205.ex01_AOP.action;

public class WriteAction implements Action
{
	private String writer;

	public void setWriter(String writer)
	{
		this.writer = writer;
	}

	@Override
	public void execute()
	{
		System.out.println(" call execute()");
		System.out.println(" Hello" + writer);
	}

	@Override
	public void execute1()
	{
		for (int i = 0; i < 1000000000; ++i) {

		}

		System.out.println(" call execute1( " + writer + " )");
	}

	@Override
	public void execute2()
	{
		System.out.println(" call execute2( " + writer + " )");
	}

}
