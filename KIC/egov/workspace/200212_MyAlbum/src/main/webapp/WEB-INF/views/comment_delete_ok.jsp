<%@page import="com.album.model.AlbumCommentDAO"%>
<%@page import="com.album.model.AlbumCommentTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="java.io.File"%>

<%
	String cpage = (String) request.getAttribute("cpage");
	String seq = (String) request.getAttribute("seq");	
	int flag = (Integer) request.getAttribute("flag");

	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('댓글삭제에 성공했습니다.');");
		out.println("location.href='./view.do?cpage=" + cpage + "&seq=" + seq + "';");
	} else if (flag == 1) {
		out.println("alert('비밀번호가 잘못되었습니다.');");
		out.println("history.back();");
	} else {
		out.println("alert('댓글삭제에 실패했습니다.');");
		out.println("history.back();");
	}
	out.println("</script>");
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>