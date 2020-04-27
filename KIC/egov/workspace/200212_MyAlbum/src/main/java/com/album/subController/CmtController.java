package com.album.subController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.album.model.AlbumCommentDAO;
import com.album.model.AlbumCommentTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CmtController {
		
	@RequestMapping( value="/comment_delete_ok.do" )
	public ModelAndView commentDelOk(HttpServletRequest request) {
		Mylog.callMethodLog(this);

		String cpage = request.getParameter("cpage");
		String seq = request.getParameter("seq");	
		String commentno = request.getParameter("commentno");
		String password = request.getParameter("comment_del_password");
		
		//out.println(commentno);
		//out.println(password);
		
		AlbumCommentTO cto = new AlbumCommentTO();
		cto.setCommentno(commentno);
		cto.setPassword(password);
		cto.setParentseq(seq);

		AlbumCommentDAO cdao = new AlbumCommentDAO();
		int flag = cdao.commentDeleteOk(cto);
		
		
		ModelAndView modelAndView = new ModelAndView("comment_delete_ok");		
		modelAndView.addObject("cpage", cpage);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("flag", flag);
		
		return modelAndView;
	}
	
	@RequestMapping( value="/comment_write_ok.do" )
	public ModelAndView commentWriteOk(HttpServletRequest request) {
		Mylog.callMethodLog(this);

		String cpage = request.getParameter("cpage");
		String seq = request.getParameter("seq");
		
		AlbumCommentTO cto = new AlbumCommentTO();
		cto.setWriter(request.getParameter("cwriter"));
		cto.setPassword(request.getParameter("cpassword"));
		cto.setContent(request.getParameter("ccontent"));
		cto.setWip(request.getRemoteAddr());
		cto.setParentseq(seq);
		
		AlbumCommentDAO cdao = new AlbumCommentDAO();
		int flag = cdao.commentWriteOk(cto);
		
		ModelAndView modelAndView = new ModelAndView("comment_write_ok");
		modelAndView.addObject("cpage", cpage);
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("flag", flag);
		
		return modelAndView;
	}
	
}
