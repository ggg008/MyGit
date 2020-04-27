package com.exam.album;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.albummodel1.CommentDAO;
import com.exam.albummodel1.CommentTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class CommentController {
	
	@RequestMapping(value = "/comment_write1_ok.do")
	public String write_ok(HttpServletRequest request, Model model) {
		String cpage = request.getParameter( "cpage" );
		String pseq =  request.getParameter( "pseq" );
		
		CommentTO cto = new CommentTO();
		cto.setPseq( request.getParameter( "pseq" ) );		
		cto.setWriter( request.getParameter( "writer" ) );
		cto.setPassword( request.getParameter( "password" ) );
		cto.setContent( request.getParameter( "content" ) );
		
		CommentDAO cdao = new CommentDAO();
		int flag = cdao.commentWriteOk( cto );
		
		model.addAttribute( "cpage", cpage );
		model.addAttribute( "pseq", pseq );
		model.addAttribute( "flag", flag );
		
		return "comment_write1_ok";
	}	
}
