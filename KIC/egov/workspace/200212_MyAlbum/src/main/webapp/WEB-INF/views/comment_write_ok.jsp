<%@page import="com.album.model.AlbumCommentDAO"%>
<%@page import="com.album.model.AlbumCommentTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	String cpage = (String) request.getAttribute("cpage");
	String seq = (String) request.getAttribute("seq");
	int flag = (Integer) request.getAttribute("flag");

	out.println("<script type='text/javascript'>");
	if (flag == 0) {
		//out.println("alert('글쓰기에 성공했습니다.');");
		out.println("location.href='./view.do?cpage=" + cpage + "&seq=" + seq + "';");
	} else {
		out.println("alert('댓글쓰기에 실패했습니다.');");
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