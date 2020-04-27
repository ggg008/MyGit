package _200205.exercise.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import _200205.exercise.chap07.Calculator;
import _200205.exercise.config.AppCtxWithCache;

public class MainAspectWithCache
{

	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppCtxWithCache.class);
		
		//실행의 순서를 오더링 할수 있다
		
		Calculator calculator = context.getBean("calculator", Calculator.class);
		calculator.factoria(7);
		calculator.factoria(7);
		calculator.factoria(5);
		calculator.factoria(5);
		context.close();

	}

}
