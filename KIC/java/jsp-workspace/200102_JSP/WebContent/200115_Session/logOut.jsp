<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//logOut.jsp
	session.invalidate();

	out.println("<script type='text/javascript'>");
	out.println("alert('로그아웃 되었습니다.')");
	out.println("location.href='loginForm.jsp'");
	out.println("</script>");
%>