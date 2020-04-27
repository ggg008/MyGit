package com.album.subController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.album.model.AlbumBoardDAO;
import com.album.model.AlbumBoardListTO;
import com.album.model.AlbumBoardTO;
import com.album.model.AlbumCommentDAO;
import com.album.model.AlbumCommentTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController
{

	@RequestMapping(value = "/list.do")
	public ModelAndView list(HttpServletRequest request)
	{
		Mylog.callMethodLog(this);

		int cpage = 1;
		if (request.getParameter("cpage") != null && !request.getParameter("cpage").equals("")) {
			cpage = Integer.parseInt(request.getParameter("cpage"));
		}

		AlbumBoardListTO listTO = new AlbumBoardListTO();
		listTO.setCpage(cpage);

		AlbumBoardDAO dao = new AlbumBoardDAO();
		listTO = dao.boardList(listTO);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_list1");
		modelAndView.addObject("listTO", listTO);

		return modelAndView;
	}

	@RequestMapping(value = "/view.do")
	public ModelAndView view(HttpServletRequest request)
	{
		Mylog.callMethodLog(this);

		String cpage = request.getParameter("cpage");

		AlbumBoardTO to = new AlbumBoardTO();
		to.setSeq(request.getParameter("seq"));

		AlbumBoardDAO dao = new AlbumBoardDAO();
		to = dao.boardView(to);

		AlbumCommentDAO cDao = new AlbumCommentDAO();

		ArrayList<AlbumCommentTO> commentList = new ArrayList<AlbumCommentTO>();
		commentList = cDao.commentList(commentList, to.getSeq());

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_view1");
		modelAndView.addObject("cpage", cpage);
		modelAndView.addObject("to", to);
		modelAndView.addObject("commentList", commentList);

		return modelAndView;
	}

}
