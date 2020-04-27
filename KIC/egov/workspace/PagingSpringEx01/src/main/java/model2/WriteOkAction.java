package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.BoardDAO;
import model1.BoardTO;

public class WriteOkAction implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println( "WriteOkAction 호출" );
		
		String mail = "";
		if(!arg0.getParameter( "mail1" ).equals("") && !arg0.getParameter( "mail2" ).equals("")) {
			mail = arg0.getParameter( "mail1" ) + "@" + arg0.getParameter( "mail2" );	
		}
		
		BoardTO to = new BoardTO();
		to.setSubject( arg0.getParameter( "subject" ) );
		to.setWriter( arg0.getParameter( "writer" ) );
		to.setMail( mail );
		to.setPassword( arg0.getParameter( "password" ) );
		to.setContent( arg0.getParameter( "content" ) );
		to.setWip( arg0.getRemoteAddr() );
		
		BoardDAO dao = new BoardDAO();
		int flag = dao.boardWriteOk( to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_write1_ok" );
		modelAndView.addObject( "flag", flag );

		return modelAndView;
	}


}






