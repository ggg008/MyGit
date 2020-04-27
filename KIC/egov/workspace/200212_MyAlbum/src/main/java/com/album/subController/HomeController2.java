package com.album.subController;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.album.model.AlbumBoardDAO;
import com.album.model.AlbumBoardTO;
import com.album.model.AlbumCommentDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController2 {


	@RequestMapping( value="/delete.do" )
	public ModelAndView delete(HttpServletRequest request) {
		Mylog.callMethodLog(this);
		
		String cpage = request.getParameter( "cpage" );

		AlbumBoardTO to = new AlbumBoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		AlbumBoardDAO dao = new AlbumBoardDAO();
		to = dao.boardDelete( to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_delete1" );
		modelAndView.addObject( "cpage", cpage );
		modelAndView.addObject( "to", to );
		
		return modelAndView;
	}

	@RequestMapping( value="/delete_ok.do" )
	public ModelAndView delete_ok(HttpServletRequest request) {
		Mylog.callMethodLog(this);
		
		AlbumBoardTO to = new AlbumBoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		to.setPassword( request.getParameter( "password" ) );
		to.setImgname(request.getParameter("imgname"));

		AlbumBoardDAO dao = new AlbumBoardDAO();
		int flag = dao.boardDeleteOk( to );
		
		if(flag == 0)
		{
			AlbumCommentDAO cdao = new AlbumCommentDAO();
			cdao.commentDeleteOkByParent(to.getSeq());
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_delete1_ok" );
		modelAndView.addObject( "flag", flag );
		
		return modelAndView;
	}
	
	@RequestMapping( value="/modify.do" )
	public ModelAndView modify(HttpServletRequest request) {
		Mylog.callMethodLog(this);
		
		String cpage = request.getParameter( "cpage" );
		
		AlbumBoardTO to = new AlbumBoardTO();
		to.setSeq( request.getParameter( "seq" ) );
		
		AlbumBoardDAO dao = new AlbumBoardDAO();
		to = dao.boardModify(to);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_modify1" );
		modelAndView.addObject( "cpage", cpage );
		modelAndView.addObject( "to", to );
		
		return modelAndView;
	}

	@RequestMapping( value="/modify_ok.do" )
	public ModelAndView modify_ok(HttpServletRequest request) {
		Mylog.callMethodLog(this);
		
		String cpage = request.getParameter( "cpage" );
		String seq = request.getParameter( "seq" );
		
		AlbumBoardDAO dao = new AlbumBoardDAO();
		String uploadPath = dao.getUploadPath();
		int maxFileSize = dao.getMaxFileSize();
		int flag = 1;

		try {
			MultipartRequest multi = new MultipartRequest(request, uploadPath, maxFileSize, "utf-8",
					new DefaultFileRenamePolicy()/*중복 시 이름재정의 옵션*/);

			cpage = multi.getParameter("cpage");
			seq = multi.getParameter("seq");
			
			String mail = "";
			if (!multi.getParameter("mail1").equals("") && !multi.getParameter("mail2").equals("")) {
				mail = multi.getParameter("mail1") + "@" + multi.getParameter("mail2");
			}			
			
			String content = multi.getParameter("content");

			content = multi.getParameter("content").replaceAll("\n", "<br>");
			content = multi.getParameter("content").replaceAll(" ", "&nbsp;");

			File file = null;
			if (multi.getFilesystemName("upload") != null) {
//				out.println(multi.getFilesystemName("upload") + "<br>");//저장된 파일명
				//out.println(multi.getOriginalFileName("upload") + "<br>"); //원 파일명
				System.out.println(multi.getFilesystemName("upload"));

				file = multi.getFile("upload");
//				out.println(file.length() + "<br>");
				System.out.println(file.length());
			}
			if (multi.getParameter("filename") != null) {

			}

			/* 
				System.out.println(seq);
				System.out.println(writer);
				System.out.println(subject);
				System.out.println(password);
				System.out.println(mail);
				System.out.println(content);
			*/

			AlbumBoardTO to = new AlbumBoardTO();

			to.setSeq(multi.getParameter("seq"));
			to.setSubject(multi.getParameter("subject"));
			to.setWriter(multi.getParameter("writer"));
			to.setPassword(multi.getParameter("password"));
			to.setContent(content);
			to.setMail(mail);
			to.setImgname(multi.getFilesystemName("upload"));
			to.setImgsize(file != null ? String.valueOf(file.length()) : "0");

			flag = dao.boardModifyOk(to);
			
		} catch (IOException e) {
			flag = 3;
		}
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_modify1_ok" );
		modelAndView.addObject( "cpage", cpage );
		modelAndView.addObject( "seq", seq );
		modelAndView.addObject( "flag", flag );
		modelAndView.addObject( "maxFileSize", maxFileSize );
		
		return modelAndView;
	}
	
	@RequestMapping( value="/write.do" )
	public ModelAndView write(HttpServletRequest request) {
		Mylog.callMethodLog(this);
		
		String cpage = request.getParameter( "cpage" );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_write1" );
		modelAndView.addObject( "cpage", cpage );
		
		return modelAndView;
	}
	
	@RequestMapping( value="/write_ok.do" )
	public ModelAndView write_ok(HttpServletRequest request, HttpServletResponse response) {

		Mylog.callMethodLog(this);
		
//		String mail = "";
//		if(!request.getParameter( "mail1" ).equals("") && !request.getParameter( "mail2" ).equals("")) {
//			mail = request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" );	
//		}
//		
//		AlbumBoardTO to = new AlbumBoardTO();
//		to.setSubject( request.getParameter( "subject" ) );
//		to.setWriter( request.getParameter( "writer" ) );
//		to.setMail( mail );
//		to.setPassword( request.getParameter( "password" ) );
//		to.setContent( request.getParameter( "content" ) );
//		to.setWip( request.getRemoteAddr() );
		
		int flag = 1;
		
		AlbumBoardDAO dao = new AlbumBoardDAO();

		String uploadPath = dao.getUploadPath();
		int maxFileSize = dao.getMaxFileSize();

		try {

			MultipartRequest multi = new MultipartRequest(request, uploadPath, maxFileSize, "utf-8",
					new DefaultFileRenamePolicy()/*중복 시 이름재정의*/);

			File imgFile = null;
			if (multi.getFilesystemName("upload") != null) {

//				out.println(multi.getFilesystemName("upload") + "<br>");//저장된 파일명
				//out.println(multi.getOriginalFileName("upload") + "<br>"); //원 파일명
				System.out.println(multi.getFilesystemName("upload"));

				imgFile = multi.getFile("upload");
				System.out.println(imgFile.length());
			}

			String mail = "";
			if (!multi.getParameter("mail1").equals("") && !multi.getParameter("mail2").equals("")) {
				mail = multi.getParameter("mail1") + "@" + multi.getParameter("mail2");
			}

			String content = multi.getParameter("content");
			content = multi.getParameter("content").replaceAll("\n", "<br>");
			content = multi.getParameter("content").replaceAll(" ", "&nbsp;");

			//System.out.println(content);

			AlbumBoardTO to = new AlbumBoardTO();
			to.setSubject(multi.getParameter("subject"));
			to.setWriter(multi.getParameter("writer"));
			to.setPassword(multi.getParameter("password"));
			to.setWip(request.getRemoteAddr());
			to.setContent(content);
			to.setMail(mail);
			to.setImgname(multi.getFilesystemName("upload"));
			to.setImgsize(imgFile != null ? String.valueOf(imgFile.length()) : "0");

			flag = dao.boardWriteOk(to);

			
		} catch (IOException e) {
			flag = 3;
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_write1_ok" );
		modelAndView.addObject( "flag", flag );
		modelAndView.addObject( "maxFileSize", maxFileSize );
		
		return modelAndView;
	}
	
}
