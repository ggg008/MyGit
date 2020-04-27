package com.exam.paging;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exam.model1.BoardDAO;
import com.exam.model1.BoardTO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController2 {
	

	@RequestMapping( value="/write.do" )
	public ModelAndView write(HttpServletRequest request) {
		System.out.println( "write() 호출" );
		
		String cpage = request.getParameter( "cpage" );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_write1" );
		modelAndView.addObject( "cpage", cpage );
		
		return modelAndView;
	}
	
	@RequestMapping( value="/write_ok.do" )
	public ModelAndView write_ok(HttpServletRequest request, HttpServletResponse response) {
		System.out.println( "write_ok() 호출" );
		
		String mail = "";
		if(!request.getParameter( "mail1" ).equals("") && !request.getParameter( "mail2" ).equals("")) {
			mail = request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" );	
		}
		
		BoardTO to = new BoardTO();
		to.setSubject( request.getParameter( "subject" ) );
		to.setWriter( request.getParameter( "writer" ) );
		to.setMail( mail );
		to.setPassword( request.getParameter( "password" ) );
		to.setContent( request.getParameter( "content" ) );
		to.setWip( request.getRemoteAddr() );
		
		BoardDAO dao = new BoardDAO();
		int flag = dao.boardWriteOk( to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_write1_ok" );
		modelAndView.addObject( "flag", flag );
		
		return modelAndView;
	}
	
	@RequestMapping( value="/modify.do" )
	public ModelAndView modify(HttpServletRequest request) {
		System.out.println( "modify() 호출" );
		
		String cpage = request.getParameter( "cpage" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardModify(to);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_modify1" );
		modelAndView.addObject( "cpage", cpage );
		modelAndView.addObject( "to", to );
		
		return modelAndView;
	}

	@RequestMapping( value="/modify_ok.do" )
	public ModelAndView modify_ok(HttpServletRequest request) {
		System.out.println( "modify_ok() 호출" );
		
		String cpage = request.getParameter( "cpage" );
		
		BoardTO to = new BoardTO();

		String mail = "";
		if(!request.getParameter( "mail1" ).equals("") && !request.getParameter( "mail2" ).equals("")) {
			mail = request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" );	
		}

		to.setSeq( request.getParameter( "seq" ) );
		to.setSubject( request.getParameter( "subject" ) );
		to.setMail( mail );
		to.setPassword( request.getParameter( "password" ) );
		to.setContent( request.getParameter( "content" ) );
		
		BoardDAO dao = new BoardDAO();
		int flag = dao.boardModifyOk( to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_modify1_ok" );
		modelAndView.addObject( "cpage", cpage );
		modelAndView.addObject( "to", to );
		modelAndView.addObject( "flag", flag );
		
		return modelAndView;
	}

	@RequestMapping( value="/delete.do" )
	public ModelAndView delete(HttpServletRequest request) {
		System.out.println( "delete() 호출" );
		
		String cpage = request.getParameter( "cpage" );

		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardDelete( to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_delete1" );
		modelAndView.addObject( "cpage", cpage );
		modelAndView.addObject( "to", to );
		
		return modelAndView;
	}

	@RequestMapping( value="/delete_ok.do" )
	public ModelAndView delete_ok(HttpServletRequest request) {
		System.out.println( "delete_ok() 호출" );
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setPassword( request.getParameter( "password" ) );

		BoardDAO dao = new BoardDAO();
		int flag = dao.boardDeleteOk( to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_delete1_ok" );
		modelAndView.addObject( "flag", flag );
		
		return modelAndView;
	}
}








