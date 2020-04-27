package _200205.exercise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import _200205.exercise.aspect.CacheAspect;
import _200205.exercise.aspect.ExeTimeAspect;
import _200205.exercise.chap07.Calculator;
import _200205.exercise.chap07.RecCalculator;

@Configuration
@EnableAspectJAutoProxy
public class AppCtxWithCache
{
	@Bean
	public CacheAspect cacheAspect()
	{
		return new CacheAspect();
	}
	
	@Bean
	public ExeTimeAspect exeTimeAspect()
	{
		return new ExeTimeAspect();
	}
	
	@Bean
	public Calculator calculator()
	{
		return new RecCalculator();
	}

}
