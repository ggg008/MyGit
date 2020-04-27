package _200205.exercise.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import _200205.exercise.chap07.Calculator;
import _200205.exercise.config.AppCtx;

public class MainAspect
{

	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Calculator calculator = context.getBean("calculator", Calculator.class);
		long fiveFact = calculator.factoria(5);
		System.out.println("cal.factora(5) = " + fiveFact);
		System.out.println(calculator.getClass().getName());
		context.close();

	}

}
