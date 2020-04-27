<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String cpage = (String)request.getAttribute( "cpage" );
	String pseq = (String)request.getAttribute( "pseq" );	
	int flag = (Integer)request.getAttribute( "flag" );
	
	out.println( "<script type='text/javascript'>" );
	if( flag == 0 ) {
		out.println( "alert('댓글쓰기에 성공했습니다.')" );
		out.println( "location.href='board_view1.do?cpage=" + cpage + "&seq=" + pseq + "'" );
	} else {
		out.println( "alert('댓글쓰기에 실패했습니다.')" );
		out.println( "history.back()" );
	}
	out.println( "</script>" );
%>