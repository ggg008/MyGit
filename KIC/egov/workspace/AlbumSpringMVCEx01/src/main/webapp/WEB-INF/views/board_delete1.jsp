<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/board_write.css">
<script type="text/javascript">
	window.onload = function() {
		document.getElementById('search').onclick = function() {
			alert( 'search()' );	
		};		
	};
</script>
</head>

<body>
<!-- 상단 디자인 -->
<div class="contents1"> 
	<div class="con_title"> 
		<p style="margin: 0px; text-align: right">
			<img style="vertical-align: middle" alt="" src="./images/home_icon.gif" /> &gt; 커뮤니티 &gt; <strong>여행지리뷰</strong>
		</p>
	</div>
	
	<!-- 로그인 시작 -->
	<form action="board_list1_login_ok.do" method="">
		<div class="con_title"> 
			<p style="margin: 0px; text-align: right">
				아이디 : <input type="text" name="id" class="board_login_input" maxlength="5"/>
				비밀번호 : <input type="password" name="password" class="board_login_input"/>
				&nbsp;
				<input type="submit" value="로 그 인" class="btn_write btn_txt01" style="cursor: pointer;" />
				<input type="button" value="회원 가입" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='member_write1.do'" />
				&nbsp;
				<input type="button" id="search" value="찾     기" class="btn_write btn_txt01" style="cursor: pointer;" /> 		
			</p>
		</div>
	</form>
	<!-- 로그인 끝 -->
	
	<form action="" method="post" name="">
		<div class="contents_sub">
		<!--게시판-->
			<div class="board_write">
				<table>
				<tr>
					<th class="top">글쓴이</th>
					<td class="top" colspan="3"><input type="text" name="writer" value="" class="board_write_input_100" maxlength="5" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3"><input type="text" name="subject" value="" class="board_write_input" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td colspan="3"><input type="password" name="password" value="" class="board_write_input_100"/></td>
				</tr>
				</table>
			</div>

			<div class="btn_area">
				<div class="align_left">			
					<input type="button" value="목록" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_list1.do'" />
					<input type="button" value="보기" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_view1.do'" />
				</div>
				<div class="align_right">			
					<input type="button" value="삭제" class="btn_write btn_txt01" style="cursor: pointer;" />					
				</div>	
			</div>	
			<!--//게시판-->
		</div>
	</form>
</div>
<!-- 하단 디자인 -->

</body>
</html>
