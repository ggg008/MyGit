package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.BoardDAO;
import model1.BoardTO;

public class ViewAction implements Controller
{
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println(this.getClass().getName() + " call execute");		
		
		BoardDAO dao = new BoardDAO();
		BoardTO to = new BoardTO();
		to.setSeq(request.getParameter("seq"));
		to = dao.boardView(to);
		
//		request.setAttribute("to", to);
		
		ModelAndView modelAndView = new ModelAndView("board_view1");
		modelAndView.addObject("to", to);
		
		return modelAndView;
	}

}
