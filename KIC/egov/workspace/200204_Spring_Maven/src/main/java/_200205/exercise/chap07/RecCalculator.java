package _200205.exercise.chap07;

public class RecCalculator implements Calculator
{

	@Override
	public long factoria(long num)
	{
		if(num == 0) {
			return 1;
		}
		else {
			return num * factoria(num - 1);			
		}
	}

}
