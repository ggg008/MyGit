package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.BoardDAO;
import model1.BoardTO;

public class ModifyOkAction implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println( "ModifyOkAction 호출" );
		
		String cpage = arg0.getParameter( "cpage" );
		
		BoardTO to = new BoardTO();

		String mail = "";
		if(!arg0.getParameter( "mail1" ).equals("") && !arg0.getParameter( "mail2" ).equals("")) {
			mail = arg0.getParameter( "mail1" ) + "@" + arg0.getParameter( "mail2" );	
		}

		to.setSeq( arg0.getParameter( "seq" ) );
		to.setSubject( arg0.getParameter( "subject" ) );
		to.setMail( mail );
		to.setPassword( arg0.getParameter( "password" ) );
		to.setContent( arg0.getParameter( "content" ) );
		
		BoardDAO dao = new BoardDAO();
		int flag = dao.boardModifyOk( to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_modify1_ok" );
		modelAndView.addObject( "cpage", cpage );
		modelAndView.addObject( "to", to );
		modelAndView.addObject( "flag", flag );
		
		return modelAndView;
	}



}
