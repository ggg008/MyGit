 package _200205.ex01_AOP.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LogginAdvice2 implements MethodInterceptor
{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable
	{
		// filter(와 유사)
		// 	전처리
		//	xxx.doFilter(req, res)
		// 	후처리
		
		// ex : 메서드의 실행 시간 비교
		
		String methodName = arg0.getMethod().getName();
		System.out.println(" "+methodName + "호출 시작");
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start(methodName);
		
		Object rtnObj = arg0.proceed();
		
		stopWatch.stop();
		System.out.println(" " + methodName + "호출 끝");
		System.out.println("*실행시간 : " + stopWatch.getTotalTimeSeconds() + "초");
		
		return rtnObj;
	}

}
