<%@ page language="java" contentType="text/plain; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.NamingException"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.DriverManager"%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>


<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	JSONArray jsonArray = new JSONArray();
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup("java:comp/env"); //톰캣 환경설정에 접근
		DataSource dataSource = (DataSource) envCtx.lookup("jdbc/mariadbUbuntu"); //커넥션 풀링(Datasource) 접근(context.xml 이용)

		conn = dataSource.getConnection();//풀링에서 커넥션 가져옴

		//out.println("연결성공\n"); error

		String sql = "SELECT seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, datediff(now(), wdate) wgap, hit FROM board1 ORDER BY seq DESC"; // evernote
		pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);// 갯수를
		pstmt = conn.prepareStatement(sql);

		rs = pstmt.executeQuery();
		
		while (rs.next()) {
			
			JSONObject jobj = new JSONObject();
			jobj.put("seq", rs.getString("seq"));
			jobj.put("subject", rs.getString("subject"));
			jobj.put("writer", rs.getString("writer"));
			jobj.put("wdate", rs.getString("wdate"));
			jobj.put("hit", rs.getString("hit"));
			jobj.put("wgap", rs.getString("wgap"));
			jsonArray.add(jobj);
		}

		out.println(jsonArray);

	} catch (NamingException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}
%>

