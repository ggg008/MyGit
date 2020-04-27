package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.BoardDAO;
import model1.BoardTO;

public class ModifyAction implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println( "ModifyAction 호출" );
		
		String cpage = arg0.getParameter( "cpage" );
		
		BoardTO to = new BoardTO();
		to.setSeq( arg0.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardModify(to);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_modify1" );
		modelAndView.addObject( "cpage", cpage );
		modelAndView.addObject( "to", to );
		
		return modelAndView;
	}



}
