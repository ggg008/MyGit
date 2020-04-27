package subController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ListAction1 implements Controller
{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
		System.out.printf( " 호출 %s-%s", this.getClass().getName(), new Exception().getStackTrace()[0].getMethodName());		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("listview1");
		
		
		return modelAndView;
	}

}
