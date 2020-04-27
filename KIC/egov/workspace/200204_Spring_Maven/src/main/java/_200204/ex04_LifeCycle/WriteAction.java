package _200204.ex04_LifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;


public class WriteAction implements Action, ApplicationContextAware, BeanFactoryAware, BeanNameAware, DisposableBean, InitializingBean
{
	private String writer;
	private String beanName;
	private BeanFactory beanFactory;
	
	
	//생성자	
	public WriteAction()
	{
		System.out.println(" 1. 빈의 생성자 실행");		
	}
	
	public void setWriter(String writer)
	{
		this.writer = writer;
		System.out.println(" 2. setWriter( " + this.writer +" ) 실행");	
	}

	public String getWriter()
	{
		System.out.println(" getWriter() 실행");	
		return writer;
	}

	@Override
	public void execute()
	{
		System.out.println(" --> execute() 실행");	

	}

	@Override
	public void afterPropertiesSet() throws Exception
	{
		// 프로퍼티가 셋 될때
		System.out.println(" 7. afterPropertiesSet() 호출 : property 설정 완료");
		
	}

	@Override
	public void destroy() throws Exception
	{
		System.out.println(" 10. destroy() 실행 : 종료");
		
	}

	@Override
	public void setBeanName(String arg0)
	{
		System.out.println(" 3. setBeanName(String arg0) 실행 : 빈의 이름 설정");
		this.beanName = arg0;
		System.out.println("--> " + beanName);
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException
	{
		//빈의 인스턴스를 만드는 팩토리를 만든다(쉽게 말하자면...)
		System.out.println(" 4. setBeanFactory(BeanFactory arg0) 실행 : 빈 팩토리 설정");
		this.beanFactory = arg0;
		System.out.println("--> " + beanFactory);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		System.out.println(" 5. setApplicationContext(ApplicationContext applicationContext) 실행");
		
	}
	
	public void init_method()
	{
		System.out.println(" 8. 빈의 사용자 초기화 메서드");
	}
	
	public void destroy_method()
	{
		System.out.println(" 11. 빈의 사용자 소멸 메서드");
	}

}
