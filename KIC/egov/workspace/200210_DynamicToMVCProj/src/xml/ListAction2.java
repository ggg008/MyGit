package xml;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListAction2 implements Controller
{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		System.out.println(" 호출 " + this.getClass().getName());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("listview2");
		
		return modelAndView;
	}

}
