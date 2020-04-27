<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%
	int checkExistUser = (Integer)request.getAttribute("checkExistUser");

	out.println("<script type='text/javascript'>");
	
	out.println("alert('"+ (String) request.getAttribute("msg") +"');");
	out.println(checkExistUser == 1 ? "self.close();" : "history.back();");
	
	out.println("</script>");
%>