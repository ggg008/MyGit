 package _200205.ex01_AOP.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogginAdvice1 implements MethodInterceptor
{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable
	{
		// filter(와 유사)
		// 	전처리
		//	xxx.doFilter(req, res)
		// 	후처리
		
		// ex : 메서드의 실행 시간 비교
		
		// 전처리용 공통사항
		System.out.println(" 공통기능 전처리 구간");
		Object rtnObj = arg0.proceed();
		// 후처리용 공통사항
		System.out.println(" 공통기능 후처리 구간");
		
		return rtnObj;
	}

}
