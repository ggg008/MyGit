package com.exam.paging;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model1.BoardDAO;
import com.exam.model1.BoardListTO;
import com.exam.model1.BoardTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	@RequestMapping( value="/list.do" )
	public ModelAndView list(HttpServletRequest request) {
		System.out.println( "list() 호출" );
		
		int cpage = 1;
		if( request.getParameter( "cpage" ) != null && !request.getParameter("cpage").equals("") ) {
			cpage = Integer.parseInt( request.getParameter( "cpage" ) );
		}

		BoardListTO listTO = new BoardListTO();
		listTO.setCpage( cpage );
		
		BoardDAO dao = new BoardDAO();
		listTO = dao.boardList( listTO );

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_list1" );
		modelAndView.addObject( "listTO", listTO );
		
		return modelAndView;
	}
	
	@RequestMapping( value="/view.do" )
	public ModelAndView view(HttpServletRequest request) {
		System.out.println( "view() 호출" );

		String cpage = request.getParameter( "cpage" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardView( to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_view1" );
		modelAndView.addObject( "cpage", cpage );
		modelAndView.addObject( "to", to );

		return modelAndView;
	}
}








