<%@page import="com.album.model.AlbumBoardTO"%>
<%@page import="com.album.model.AlbumBoardDAO"%>
<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>

<%
	
	int flag = (Integer)request.getAttribute("flag");
	int maxFileSize = (Integer)request.getAttribute("maxFileSize");

	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		out.println("alert('글쓰기에 성공했습니다.');");
		out.println("location.href='./list.do';");
	} else if(flag == 3) {
		out.println("alert('파일 사이즈가 최대 크기 " + maxFileSize + "보다 큽니다.');");
		out.println("history.back();");
	} else {
		out.println("alert('글쓰기에 실패했습니다.');");
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