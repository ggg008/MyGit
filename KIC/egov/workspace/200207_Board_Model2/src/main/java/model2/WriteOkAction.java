package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.BoardDAO;
import model1.BoardTO;

public class WriteOkAction implements Controller
{
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println(this.getClass().getName() + " call execute");	

		String mail = "";
		if (!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")) {
			mail = request.getParameter("mail1") + "@" + request.getParameter("mail2");
		}

		String content = request.getParameter("content");
		content = request.getParameter("content").replaceAll("\n", "<br>");
		content = request.getParameter("content").replaceAll(" ", "&nbsp;");

		//System.out.println(content);

		BoardTO to = new BoardTO();
		to.setSubject(request.getParameter("subject"));
		to.setWriter(request.getParameter("writer"));
		to.setPassword(request.getParameter("password"));
		to.setWip(request.getRemoteAddr());
		to.setMail(mail);
		to.setContent(content);
		

		BoardDAO dao = new BoardDAO();
		int flag = dao.boardWriteOk(to);
		
//		request.setAttribute("flag", flag);	
		
		ModelAndView modelAndView = new ModelAndView("board_write1_ok");
		modelAndView.addObject("flag", flag);
		
		return modelAndView;
	}

}
