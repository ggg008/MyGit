<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ page import="java.util.ArrayList"%>
<%@ page import="model1.BoardTO"%>


<%	
	ArrayList<BoardTO> boardLists = (ArrayList<BoardTO>)request.getAttribute("boardList");

	StringBuffer sb = new StringBuffer();

	int totalRecord = boardLists.size();

	for (BoardTO to : boardLists) {
		String seq = to.getSeq();
		String subject = to.getSubject();
		String writer = to.getWriter();
		String wdate = to.getWdate();
		int wgap = to.getWgap();
		String hit = to.getHit();

		sb.append("<tr>");
		sb.append("	<td>&nbsp;</td>");
		sb.append("	<td>" + seq + "</td>");
		sb.append("	<td class='left'>");
		sb.append("		<a href='./controller?action=view&seq=" + seq + "'>" + subject + "</a>");
		if (wgap == 0) {
			sb.append("		&nbsp;<img src='./images/icon_hot.gif' alt='HOT'>");
		}
		sb.append("	</td>");
		sb.append("	<td>" + writer + "</td>");
		sb.append("	<td>" + wdate + "</td>");
		sb.append("	<td>" + hit + "</td>");
		sb.append("	<td>&nbsp;</td>");
		sb.append("</tr>");

	}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/board_list.css">
</head>

<body>
	<!-- 상단 디자인 -->
	<div class="con_title">
		<h3>게시판</h3>
		<p>
			HOME &gt; 게시판 &gt; <strong>게시판</strong>
		</p>
	</div>
	<div class="con_txt">
		<div class="contents_sub">
			<div class="board_top">
				<div class="bold">
					총 <span class="txt_orange"><%=totalRecord%></span>건
				</div>
			</div>

			<!--게시판-->
			<div class="board">
				<table>
					<tr>
						<th width="3%">&nbsp;</th>
						<th width="5%">번호</th>
						<th>제목</th>
						<th width="10%">글쓴이</th>
						<th width="17%">등록일</th>
						<th width="5%">조회</th>
						<th width="3%">&nbsp;</th>
					</tr>

					<%=sb%>
					<!-- 					
					<tr>
						<td>&nbsp;</td>
						<td>1</td>
						<td class="left"><a href="board_view1.jsp">adfas</a>&nbsp;<img
							src="./images/icon_hot.gif" alt="HOT"></td>
						<td>asdfa</td>
						<td>2017-01-31</td>
						<td>6</td>
						<td>&nbsp;</td>
					</tr>
					 -->
				</table>
			</div>
			<!--//게시판-->

			<div class="align_right">
				<button type="button" class="btn_write btn_txt01"
					style="cursor: pointer;" onclick="location.href='./controller?action=write'">쓰기</button>
			</div>
		</div>
	</div>
	<!--//하단 디자인 -->

</body>
</html>
