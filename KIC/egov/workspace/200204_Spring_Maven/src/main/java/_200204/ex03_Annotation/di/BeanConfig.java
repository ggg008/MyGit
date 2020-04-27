package _200204.ex03_Annotation.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import _200204.ex03_Annotation.BoardTO;
import _200204.ex03_Annotation.HelloAnnotation;

@Configuration
@Scope("singleton")
public class BeanConfig
{
	@Bean
	public HelloAnnotation helloAnnotation()
	{
		return new HelloAnnotation();		
	}
	
	@Bean
	public BoardTO boardTO()
	{
		BoardTO bTo = new BoardTO();
		bTo.setSeq(1);
		bTo.setSubject("제목");
		
		
		return bTo;
	}
}
