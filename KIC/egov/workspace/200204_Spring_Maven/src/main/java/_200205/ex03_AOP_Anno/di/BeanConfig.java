package _200205.ex03_AOP_Anno.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import _200205.ex03_AOP_Anno.action.WriteAction;
import _200205.ex03_AOP_Anno.aop.LogginAdvice;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BeanConfig
{
	@Bean
	public WriteAction action()
	{
		WriteAction action = new WriteAction();
		action.setWriter("박문수");
		
		return action;
	}
	
	@Bean
	public LogginAdvice imAspectMaker()
	{
		return new LogginAdvice();
	}
}
