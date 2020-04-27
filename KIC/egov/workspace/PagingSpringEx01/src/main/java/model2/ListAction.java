package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.BoardDAO;
import model1.BoardListTO;

public class ListAction implements Controller {

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "ListAction 호출" );
		
		int cpage = 1;
		if( arg0.getParameter( "cpage" ) != null
				&& !arg0.getParameter("cpage").equals("") ) {
			cpage = Integer.parseInt( arg0.getParameter( "cpage" ) );
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


}
