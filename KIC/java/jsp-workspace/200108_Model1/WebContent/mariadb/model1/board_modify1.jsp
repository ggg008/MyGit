﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="model1.BoardTO"%>
<%@page import="model1.BoardDAO"%>

<%
	request.setCharacterEncoding("utf-8");

	String seq = request.getParameter("seq");

	BoardDAO dao = new BoardDAO();
	BoardTO to = new BoardTO();
	to.setSeq(request.getParameter("seq"));
	to = dao.boardModify(to);
	
	String writer = to.getWriter();
	String subject = to.getSubject();
	String content = to.getContent();
	String mail[] = to.getMail().equals("") ? to.getMail().split("@") : new String[]{"", ""};
	
%>	

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/board_write.css">

<script type="text/javascript">
	window.onload = function() {
		document.getElementById("submit1").onclick = function() {
			if (document.frm.password.value.trim() == '') {
				alert('비밀번호를 입력하셔야 합니다.');
				return false;
			}
			document.frm.submit();
		};

	}
</script>

</head>

<body>
<!-- 상단 디자인 -->
<div class="con_title">
	<h3>게시판</h3>
	<p>HOME &gt; 게시판 &gt; <strong>게시판</strong></p>
</div>
<div class="con_txt">
	<form action="board_modify1_ok.jsp" method="post" name="frm">	
		<input type="hidden" name="seq" value="<%=seq%>"><!-- 숨겨서 보내기 -->
		<div class="contents_sub">	
			<!--게시판-->
			<div class="board_write">
				<table>
				<tr>
					<th class="top">글쓴이</th>
					<td class="top" colspan="3"><input type="text" name="writer" value="<%= writer %>" class="board_view_input_mail" maxlength="5" readonly/></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3"><input type="text" name="subject" value="<%= subject %>" class="board_view_input" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td colspan="3"><input type="password" name="password" value="" class="board_view_input_mail"/></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3"><textarea name="content" class="board_editor_area"><%= content %></textarea></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td colspan="3"><input type="text" name="mail1" value="<%= mail[0] %>" class="board_view_input_mail"/> @ <input type="text" name="mail2" value="<%= mail[1] %>" class="board_view_input_mail"/></td>
				</tr>
				</table>
			</div>
			
			<div class="btn_area">
				<div class="align_left">
					<button type="button" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_list1.jsp'">목록</button>
					<button type="button" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_view1.jsp?seq=<%= seq %>'">보기</button>
				</div>
				<div class="align_right">
					<button type="button" id="submit1" class="btn_write btn_txt01" style="cursor: pointer;">수정</button>
				</div>
			</div>
			<!--//게시판-->
		</div>
	</form>
</div>
<!-- 하단 디자인 -->

</body>
</html>
