package _200204.ex04_LifeCycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@Scope("singleton")
public class BeansConfig
{		
	@Bean(initMethod="init_method", destroyMethod="destroy_method")
	public WriteAction action() 
	{		
		WriteAction action = new WriteAction();
		action.setWriter("Hello Writer");
		
		return action;
	}
	
	@Bean
	public CustomBeanProcessor customBeanProcessor()
	{
		return new CustomBeanProcessor();
	}
}
