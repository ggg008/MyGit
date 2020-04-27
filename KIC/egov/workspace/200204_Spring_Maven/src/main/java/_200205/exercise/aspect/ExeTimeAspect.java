package _200205.exercise.aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class ExeTimeAspect
{
	//빈컨텍스트를 범위에 포함시키지 않게 주의
	//(등록된 메서드를 한번 호출하나?)
	@Pointcut("execution(public * _200205.exercise.chap07..*(..))")
	private void publicTarget()
	{
	}

	@Around("publicTarget()")	
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable
	{
		long start = System.nanoTime();

		try {
			Object result = joinPoint.proceed();
			return result;
			
		} finally {
			
			long finish = System.nanoTime();
			Signature signature = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) 실행시간 : %d ns \n", joinPoint.getTarget().getClass().getSimpleName(),
					signature.getName(), Arrays.toString(joinPoint.getArgs()), finish - start);
		}
	}
	
//	@After("publicTarget()")
//	public void test() {
//		System.out.println(" 애프터!!");
//	}

}
