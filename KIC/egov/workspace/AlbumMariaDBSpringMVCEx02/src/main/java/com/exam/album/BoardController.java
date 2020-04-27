package com.exam.album;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exam.albummodel1.BoardDAO;
import com.exam.albummodel1.BoardListTO;
import com.exam.albummodel1.BoardTO;
import com.exam.albummodel1.CommentDAO;
import com.exam.albummodel1.CommentTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	private String uploadPath = "C:/MyCloud/OneDrive/eGovFrameDev-3.8.0-64bit/workspace/AlbumMariaDBSpringMVCEx02/src/main/webapp/upload";
	private int maxFileSize = 1024 * 1024 * 5;
	private String encType = "utf-8";
	
	@RequestMapping(value = "/board_list1.do")
	public String list(HttpServletRequest request, Model model) {
		
		int cpage = 1;
		if( request.getParameter( "cpage" ) != null && !request.getParameter("cpage").equals("") ) {
			cpage = Integer.parseInt( request.getParameter( "cpage" ) );
		}

		BoardListTO listTO = new BoardListTO();
		listTO.setCpage( cpage );
		
		BoardDAO dao = new BoardDAO();
		listTO = dao.boardList( listTO );

		model.addAttribute( "listTO", listTO );
		
		return "board_list1";
	}
	
	@RequestMapping(value = "/board_view1.do")
	public String view(HttpServletRequest request, Model model) {
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardView( to );
		
		CommentDAO cdao = new CommentDAO();
		ArrayList<CommentTO> commentLists = cdao.commentList( to );

		model.addAttribute( "cpage", request.getParameter( "cpage" ) );
		model.addAttribute( "to", to );
		model.addAttribute( "commentLists", commentLists );
		
		return "board_view1";
	}
	
	@RequestMapping(value = "/board_write1.do")
	public String write(HttpServletRequest request, Model model) {
		
		model.addAttribute( "cpage" , request.getParameter( "cpage" ) );
		
		return "board_write1";
	}
	
	@RequestMapping(value = "/board_write1_ok.do")
	public String write_ok(HttpServletRequest request, Model model) {

		MultipartRequest multi = null;

		int flag = 1;
		try {
			multi = new MultipartRequest( request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy());
			BoardTO to = new BoardTO();
				
			to.setSubject( multi.getParameter( "subject" ) );
			to.setWriter( multi.getParameter( "writer" ) );
			to.setMail( "" );
			if( !multi.getParameter( "mail1" ).equals("") && !multi.getParameter( "mail2" ).equals( "" ) ) {
				to.setMail( multi.getParameter( "mail1" ) + "@" + multi.getParameter( "mail2" ) );	
			}
			to.setPassword( multi.getParameter( "password" ) );
			to.setContent( multi.getParameter( "content" ) );
			to.setFilename( multi.getFilesystemName( "upload" ) );
			to.setFilesize( multi.getFile( "upload" ).length() ); 
			to.setWip( request.getRemoteAddr() );

			BoardDAO dao = new BoardDAO();
			flag = dao.boardWriteOk( to );
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		}
		
		model.addAttribute( "flag", flag );
		
		return "board_write1_ok";
	}
	
	@RequestMapping(value = "/board_modify1.do")
	public String modify(HttpServletRequest request, Model model) {
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardModify( to );
		
		model.addAttribute( "cpage", request.getParameter( "cpage" ) );
		model.addAttribute( "to", to );
		
		return "board_modify1";
	}
	
	@RequestMapping(value = "/board_modify1_ok.do")
	public String modify_ok(HttpServletRequest request, Model model) {
		
		MultipartRequest multi = null;

		int flag = 2;
		try {
			multi = new MultipartRequest( request, uploadPath, maxFileSize, encType, new DefaultFileRenamePolicy() );
			
			BoardTO to = new BoardTO();
			to.setSeq( multi.getParameter( "seq" ) );
			to.setPassword( multi.getParameter( "password" ) );
			to.setSubject( multi.getParameter( "subject" ) );
			to.setMail( "" );
			if( !multi.getParameter( "mail1" ).equals("") && !multi.getParameter( "mail2" ).equals( "" ) ) {
				to.setMail( multi.getParameter( "mail1" ) + "@" + multi.getParameter( "mail2" ) );	
			}
			to.setContent( multi.getParameter( "content" ) );
			
			to.setFilename( "" );
			if( multi.getFile( "upload" ) != null ) {
				to.setFilename( multi.getFilesystemName( "upload" ) );
				to.setFilesize( multi.getFile( "upload" ).length() );
			}
			
			BoardDAO dao = new BoardDAO();
			flag = dao.boardModifyOk( to );
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute( "cpage", multi.getParameter( "cpage" ) );
		model.addAttribute( "seq", multi.getParameter( "seq" ) );
		model.addAttribute( "flag", flag );
		
		return "board_modify1_ok";
	}
	
	@RequestMapping(value = "/board_delete1.do")
	public String delete(HttpServletRequest request, Model model) {
		
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		BoardDAO dao = new BoardDAO();
		to = dao.boardDelete( to );

		model.addAttribute( "cpage", request.getParameter( "cpage" ) );
		model.addAttribute( "to", to );
		
		return "board_delete1";
	}
	
	@RequestMapping(value = "/board_delete1_ok.do")
	public String delete_ok(HttpServletRequest request, Model model) {
		BoardTO to = new BoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setPassword( request.getParameter( "password" ) );	
		
		BoardDAO dao = new BoardDAO();
		int flag = dao.boardDeleteOk( to );

		model.addAttribute( "flag", flag );
		
		return "board_delete1_ok";
	}
}
