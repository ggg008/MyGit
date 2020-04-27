<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	String doUrl = request.getAttribute("doUrl") != null ? (String) request.getAttribute("doUrl") : "";

	out.println("<script type='text/javascript'>");
	
	out.println("alert('"+ (String) request.getAttribute("msg") +"');");
	out.println(doUrl.equals("") ? "history.back();" : "location.href='./" + doUrl + "';");
	
	out.println("</script>");
%>