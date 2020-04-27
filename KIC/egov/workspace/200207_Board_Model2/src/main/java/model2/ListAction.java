package model2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.BoardDAO;
import model1.BoardTO;

public class ListAction implements Controller
{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println(this.getClass().getName() + " call execute");	
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardTO> boardList = dao.boardList();
		
//		request.setAttribute("boardList", boardList);
		
		ModelAndView modelAndView = new ModelAndView("board_list1");
		modelAndView.addObject("boardList", boardList);
		
		return modelAndView;
	}


}
