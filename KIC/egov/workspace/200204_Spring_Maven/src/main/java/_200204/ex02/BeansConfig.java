package _200204.ex02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import _200204.ex02.action.ListAction;
import _200204.ex02.model.BoardDAO;

@Configuration
public class BeansConfig
{
	@Bean
	public BoardDAO boardDAO()
	{
		return new BoardDAO();
	}
	
	@Bean(name="listAll")
	public ListAction list()
	{
//		BoardDAO dao = new BoardDAO();
//		return new ListAction(dao);
		
		return new ListAction(this.boardDAO());
	}
}
