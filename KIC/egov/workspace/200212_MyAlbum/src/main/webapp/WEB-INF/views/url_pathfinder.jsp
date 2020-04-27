<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//request URL
	Enumeration param = request.getParameterNames();
	String strParam = "";
	while (param.hasMoreElements()) {
		String name = (String) param.nextElement();
		String value = request.getParameter(name);
		strParam += name + "=" + value + "&";
	}
	/*
	request.getScheme() 	//프로토콜 [http]
	request.getServerName() //서버주소	[www.***.***]
	request.getServerPort() //서버포트	[8080]
	request.getRequestURI();   // 요청경로 [ /project/path/index.jsp ]
	request.getContextPath();  // 프로젝트의 경로값만 가져옴 [ /project ]
	request.getRequestURL();   // 프로토콜, 호스트를 포함한 전체 요청경로 [ http://localhost:8080/project/path/index.jsp ]
	request.getServletPath();  // 파일 경로명 [ /path/index.jsp ]	
	*/
	
	
	String URL = String.format("%s://%s:%s%s?%s", request.getScheme(), request.getServerName(),
			request.getServerPort(), request.getAttribute("javax.servlet.forward.request_uri"), strParam);
	
	
	
	application.setAttribute("curPageUrl", URL);
	//System.out.println(URL);
	
%>