<%@page import="java.util.ArrayList"%>
<%@page import="model.ZipcodeTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	ArrayList<ZipcodeTO> zips = (ArrayList<ZipcodeTO>) request.getAttribute("dong");

	StringBuffer sb = new StringBuffer();

	sb.append("<table width='600' border='1'>");
	for (ZipcodeTO zTo : zips) {

		sb.append("<tr>");
		sb.append("	<td>" + zTo.getSeq() + "</td>");
		sb.append("	<td>" + zTo.getZipcode() + "</td>");
		sb.append("	<td>" + zTo.getSido() + "</td>");
		sb.append("	<td>" + zTo.getGugun() + "</td>");
		sb.append("	<td>" + zTo.getDong() + "</td>");
		sb.append("	<td>" + zTo.getRi() + "</td>");
		sb.append("	<td>" + zTo.getBunji() + "</td>");
		sb.append("</tr>");

	}
	sb.append("</table>");

	sb.append("<br>" + request.getAttribute("data"));

	//out.println("동이름 : " + request.getAttribute("dong") + "<br>");
	//out.println("데이터 : " + (String) request.getAttribute("data") + "<br>");//모델->뷰 데이터 전송할때 주로 Attribute..
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>zipcode_ok</title>
</head>
<body>
	zipcode_ok.jsp
	<br>

	<%=sb%>
</body>
</html>