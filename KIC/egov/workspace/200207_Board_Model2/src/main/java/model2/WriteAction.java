package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WriteAction implements Controller
{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName() + " call execute");		
		return new ModelAndView("board_write1");
	}

}
