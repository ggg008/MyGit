package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class WriteAction implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println( "WriteAction 호출" );
		
		String cpage = arg0.getParameter( "cpage" );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_write1" );
		modelAndView.addObject( "cpage", cpage );
		
		return modelAndView;
	}


}
