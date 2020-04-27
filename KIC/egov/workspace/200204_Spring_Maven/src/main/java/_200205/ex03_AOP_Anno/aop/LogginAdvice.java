package _200205.ex03_AOP_Anno.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class LogginAdvice
{
//	@Pointcut("execution(* execute())")
//	private void myTarget()
//	{	
//	}

//	@Around("myTarget()")//전후처리 포인트컷 around advice //재사용을 위해서
	@Around("execution(* execute())")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable
	{
		System.out.println(" 전처리");
		
		Object rtnObj = joinPoint.proceed();
		
		System.out.println(" 후처리");
		
		return rtnObj;
	}
	
//	@After("execution(* execute())")
//	public void test() {
//		
//		System.out.println(" 애프터!!");
//		
//	}
}
