﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/board_view.css">
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
	
	<div class="contents_sub">	
	<!--게시판-->
		<div class="board_view">
			<table>
			<tr>
				<th width="10%">제목</th>
				<td width="60%"> 제주 올레길 좋아요</td>
				<th width="10%">등록일</th>
				<td width="20%">2016.03.02 21:11</td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td>여행자</td>
				<th>조회</th>
				<td>345</td>
			</tr>
			<tr>
				<td colspan="4" height="200" valign="top" style="padding:20px; line-height:160%">
					<div id="bbs_file_wrap">
						<div>
							<img src="./upload/607927_1.jpg" width="900" onerror="" /><br />
						</div>
					</div>
					시간이 되면 또 걷고 싶은 길이네요
				</td>
			</tr>			
			</table>
			
			<table>
			<tr>
				<td class="coment_re" >
					<strong>54545</strong> (2016.09.19 02:00)
					<div class="coment_re_txt">
						Test
					</div>
				</td>
				<td class="coment_re" width="20%" align="right">
					<input type="password" name="cpassword1" placeholder="비밀번호" class="coment_input pR10" />
					<input type="button" value="삭제" class="btn_comment btn_txt01" style="cursor: pointer;" />
				</td>
			</tr>
			<tr>
				<td class="coment_re">
					<strong>하오리</strong> (2016.09.19 07:54)
					<div class="coment_re_txt">
						우리는 민족 중흥의 역사적 사명을 띄고 이 땅에 태어났다. 조상의 빛난 얼을 오늘에 되살려
					</div>
				</td>
				<td class="coment_re" width="20%" align="right">
					<input type="password" name="cpassword2" placeholder="비밀번호" class="coment_input pR10" />
					<input type="button" value="삭제" class="btn_comment btn_txt01" style="cursor: pointer;" />
				</td>
			</tr>
			</table>

			<form action="" method="post" name="cfrm">
			<table>
			<tr>
				<td width="94%" class="coment_re">
					글쓴이 <input type="text" name="cwriter" maxlength="5" class="coment_input" />&nbsp;&nbsp;
					비밀번호 <input type="password" name="cpassword" class="coment_input pR10" />&nbsp;&nbsp;
				</td>
				<td width="6%" class="bg01"></td>
			</tr>
			<tr>
				<td class="bg01">
					<textarea name="ccontent" cols="" rows="" class="coment_input_text"></textarea>
				</td>
				<td align="right" class="bg01">
					<input type="button" value="댓글등록" class="btn_comment_write btn_txt01" />
				</td>
			</tr>
			</table>
			</form>
		</div>
		<div class="btn_area">
			<div class="align_left">			
				<input type="button" value="목록" type="button" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_list1.do'" />
			</div>
			<div class="align_right">
				<input type="button" value="수정" type="button" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_modify1.do'" />
				<input type="button" value="삭제" type="button" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_delete1.do'" />
				<input type="button" value="쓰기" type="button" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='board_write1.do'" />
			</div>	
		</div>
		<!--//게시판-->
	</div>
<!-- 하단 디자인 -->
</div>

</body>
</html>
