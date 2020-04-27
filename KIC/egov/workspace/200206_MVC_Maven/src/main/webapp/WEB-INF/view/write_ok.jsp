<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쓰기 오키</title>
</head>
<body>
write_ok.jsp
<hr>

<%
	String data = (String) request.getAttribute("data");
	out.println("data : "+ data);
%>
<hr>

${ data }

</body>
</html>