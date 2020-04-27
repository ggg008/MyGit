package _200205.exercise.chap07;

public class ImpeCalculator implements Calculator
{

	@Override
	public long factoria(long num)
	{
		long result = 1;
		for(long i = 1; i <= num; ++i) {
			result *= i;
		}			
		
		return result;
	}

}
