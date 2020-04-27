package _200205.exercise.main;

import _200205.exercise.chap07.ExeTimeCalculator;
import _200205.exercise.chap07.ImpeCalculator;
import _200205.exercise.chap07.RecCalculator;

public class MainProxy
{

	public static void main(String[] args)
	{
		ExeTimeCalculator ttCal1 = new ExeTimeCalculator(new ImpeCalculator());
		System.out.println(ttCal1.factoria(20));
		
		ExeTimeCalculator ttCal2 = new ExeTimeCalculator(new RecCalculator());
		System.out.println(ttCal2.factoria(20));

	}

}
