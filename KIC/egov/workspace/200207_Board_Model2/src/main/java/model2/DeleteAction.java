package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.BoardDAO;
import model1.BoardTO;

public class DeleteAction implements Controller
{	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println(this.getClass().getName() + " call execute");		


		String seq = request.getParameter("seq");

		BoardDAO dao = new BoardDAO();
		BoardTO to = new BoardTO();
		to.setSeq(seq);
		to = dao.boardDelete(to);
				
		ModelAndView modelAndView = new ModelAndView("board_delete1");
		modelAndView.addObject("to", to);
		
		return modelAndView;
		
	}
}
