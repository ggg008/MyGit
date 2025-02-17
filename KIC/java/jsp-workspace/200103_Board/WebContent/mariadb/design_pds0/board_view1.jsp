<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="../../css/board_view.css">
</head>

<body>
<!-- 상단 디자인 -->
<div class="con_title">
	<h3>게시판</h3>
	<p>HOME &gt; 게시판 &gt; <strong>게시판</strong></p>
</div>
<div class="con_txt">
	<div class="contents_sub">
		<!--게시판-->
		<div class="board_view">
			<table>
			<tr>
				<th width="10%">제목</th>
				<td width="60%">제목입니다.</td>
				<th width="10%">등록일</th>
				<td width="20%">2017.01.31 09:57</td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td>작성자(test@test.com)</td>
				<th>조회</th>
				<td>3</td>
			</tr>
			<tr>
				<th>첨부 파일</th>
				<td>test.txt(1024 Kbyte)</td>
				<th></th>
				<td></td>
			</tr>
			<tr>
				<td colspan="4" height="200" valign="top" style="padding: 20px; line-height: 160%">내용입니다.</td>
			</tr>
			</table>
		</div>

		<div class="btn_area">
			<div class="align_left">
				<button type="button" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_list1.jsp'">목록</button>
			</div>
			<div class="align_right">
				<button type="button" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_modify1.jsp'">수정</button>
				<button type="button" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_delete1.jsp'">삭제</button>
				<button type="button" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='board_write1.jsp'">쓰기</button>
			</div>
		</div>
		<!--//게시판-->
	</div>
</div>
<!-- 하단 디자인 -->

</body>
</html>
