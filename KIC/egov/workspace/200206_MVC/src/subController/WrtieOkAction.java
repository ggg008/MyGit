package subController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WrtieOkAction implements Controller
{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception
	{
//		arg0.setCharacterEncoding("UTF-8");
		
		System.out.printf(" 호출 %s-%s \n", this.getClass().getName(),
				new Exception().getStackTrace()[0].getMethodName());

		System.out.println("data : " + arg0.getParameter("data"));
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("write_ok");
		
		//arg0.setAttribute("data", arg0.getParameter("data"));
		modelAndView.addObject("data", arg0.getParameter("data"));//어트리뷰트 내장
		
		return modelAndView;
	}

}
