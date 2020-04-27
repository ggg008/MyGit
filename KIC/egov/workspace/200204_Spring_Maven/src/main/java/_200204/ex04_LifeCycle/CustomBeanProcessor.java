package _200204.ex04_LifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class CustomBeanProcessor implements BeanPostProcessor
{

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException
	{
		System.out.println(" 9. 초기화 후 빈 처리");
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException
	{
		System.out.println(" 6. 초기화 전 빈 처리");
		return bean;
	}
	
}
