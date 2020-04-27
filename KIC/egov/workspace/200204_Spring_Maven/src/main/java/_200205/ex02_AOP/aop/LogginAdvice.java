package _200205.ex02_AOP.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogginAdvice
{
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable
	{
		System.out.println(" " + this.getClass().getName() + " 전 처리");
		
		Object rtnObj = joinPoint.proceed();

		System.out.println(" " + this.getClass().getName() + " 후 처리");
		
		return rtnObj;
	}
	
	public void before() throws Throwable
	{	
		System.out.println(" " + new Exception().getStackTrace()[0].getMethodName() + " 실행");
	}

	public void after() throws Throwable
	{
		System.out.println(" " + new Exception().getStackTrace()[0].getMethodName() + " 실행");
	}
}
