﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/board_list.css">
</head>

<body>
<!-- 상단 디자인 -->
<div class="con_title">
	<h3>게시판</h3>
	<p>HOME &gt; 게시판 &gt; <strong>게시판</strong></p>
</div>
<div class="con_txt">
	<div class="contents_sub">
		<div class="board_top">
			<div class="bold">
				<p>총 <span class="txt_orange">1</span>건</p>
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
			<tr>
				<td>&nbsp;</td>
				<td>1</td>
				<td class="left"><a href="board_view1.jsp">adfas</a>&nbsp;<img src="../../images/icon_hot.gif" alt="HOT"></td>
				<td>asdfa</td>
				<td>2017.01.31 09:57</td>
				<td>6</td>
				<td><img src="../../images/icon_file.gif" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td>2</td>
				<td class="left"><a href="board_view1.jsp">adfas</a>&nbsp;<img src="../../images/icon_hot.gif" alt="HOT"></td>
				<td>asdfa</td>
				<td>2017.01.31 09:57</td>
				<td>6</td>
				<td><img src="../../images/icon_file.gif" /></td>
			</tr>
			</table>
		</div>
		<!--//게시판-->
		
		<div class="align_right">
			<button type="button" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='board_write1.jsp'">쓰기</button>
		</div>

		<!--페이지넘버-->
		<div class="paginate_regular">
			<div align="absmiddle">
				<span><a>&lt;&lt;</a></span>
				&nbsp;
				<span><a>&lt;</a></span>
				&nbsp;&nbsp;
				<span><a>[1]</a></span>
				<span><a href="board_list1.jsp">2</a></span>
				<span><a href="board_list1.jsp">3</a></span>
				&nbsp;&nbsp;
				<span><a>&gt;</a></span>
				&nbsp;
				<span><a>&gt;&gt;</a></span>
			</div>
		</div>
		<!--//페이지넘버-->
	</div>
</div>
<!--//하단 디자인 -->

</body>
</html>
