﻿<%@page import="com.album.model.AlbumMemberTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Object userObj = session.getAttribute("album_loginUser");
	Object mailObj = userObj != null ? ((AlbumMemberTO) userObj).getMail() : null; 
	
	String userMail1 = "";
	String userMail2 = "";
	
	if(mailObj != null && ((String) mailObj).contains("@")){
		userMail1 = ((String) mailObj).split("@")[0];
		userMail2 = ((String) mailObj).split("@")[1];
		
		System.out.println(userMail1);
		System.out.println(userMail2);
	}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/board_write.css">
<script type="text/javascript">
	
	function frmsubmit() {
		var info = document.getElementById('info');
		var iid = document.getElementById('input_id');
		var iwriter = document.getElementById('input_writer');
		var ipw = document.getElementById('input_pw');
		var imail1 = document.getElementById('input_mail1');
		var imail2 = document.getElementById('input_mail2');
		//alert('frmsubmit()' + iid.value + ipw.value);
		
		if (info.checked == false) {
			alert('동의하셔야 합니다.');
			return false;
		} else if(iid.value == ''){
			alert('아이디를 입력하셔야 합니다');
			return false;
		} else if(iwriter.value == ''){
			alert('이름을 입력하셔야 합니다');
			return false;
		} else if(ipw.value == ''){
			alert('패스워드를 입력하셔야 합니다');
			return false;
		} else if(imail1.value == '' || imail2.value == ''){
			alert('이메일을 입력하셔야 합니다');
			return false;
		} 

		return true;
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
	<form action="./member_modify1_ok.do" method="post" name="frm" onsubmit="return frmsubmit()">
		<div class="contents_sub">
		<!--게시판-->
			<div class="board_write">
				<table>
				<!-- 
				<tr>
					<th class="top">아이디</th>
					<td class="top" colspan="3"><input type="text" name="id" value="" class="board_write_input_100" /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td colspan="3"><input type="text" name="writer" value="" class="board_write_input" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td colspan="3"><input type="password" name="password" value="" class="board_write_input_100"/></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td colspan="3"><input type="text" name="mail1" value="" class="board_write_input_100"/> @ <input type="text" name="mail2" value="" class="board_write_input_100"/></td>
				</tr>
				 -->
				<tr>
					<th class="top">아이디</th>
					<td class="top" colspan="3"><input type="text" id="input_id" name="id" value="asd" class="board_write_input_100" readonly="readonly" /></td>
				</tr>
				<tr>
					<th>이름</th>
					<td colspan="3"><input type="text" id="input_writer" name="writer" value="${ sessionScope.album_loginUser.name }" class="board_write_input"/></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td colspan="3"><input type="text" id="input_pw" name="password" value="123" class="board_write_input_100"  readonly="readonly" /></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td colspan="3"><input type="text" id="input_mail1" name="mail1" value="<%= userMail1 %>" class="board_write_input_100" /> @ <input type="text" name="mail2" value="<%= userMail2 %>" class="board_write_input_100"  /></td>
				</tr>
				</table>
				
				<table>	
				<tr>
					<br />
					<td style="text-align:left;border:1px solid #e0e0e0;background-color:f9f9f9;padding:5px">
						<div style="padding-top:7px;padding-bottom:5px;font-weight:bold;padding-left:7px;font-family: Gulim,Tahoma,verdana;">※ 개인정보 수집 및 이용에 관한 안내</div>
						<div style="padding-left:10px;">
							<div style="width:97%;height:95px;font-size:11px;letter-spacing: -0.1em;border:1px solid #c5c5c5;background-color:#fff;padding-left:14px;padding-top:7px;"> 
								 1. 수집 개인정보 항목 : 회사명, 담당자명, 메일 주소, 전화번호, 홈페이지 주소, 팩스번호, 주소 <br />
								 2. 개인정보의 수집 및 이용목적 : 제휴신청에 따른 본인확인 및 원활한 의사소통 경로 확보 <br />
								 3. 개인정보의 이용기간 : 모든 검토가 완료된 후 3개월간 이용자의 조회를 위하여 보관하며, 이후 해당정보를 지체 없이 파기합니다. <br />
								 4. 그 밖의 사항은 개인정보취급방침을 준수합니다.
							</div>
						</div>
						<div style="padding-top:7px;padding-left:5px;padding-bottom:7px;font-family: Gulim,Tahoma,verdana;">
							<input type="checkbox" id="info" value="1" class="input_radio"> 개인정보 수집 및 이용에 대해 동의합니다.
						</div>
					</td>
				</tr>
				</table>
			</div>

			<div class="btn_area">
				<div class="align_left">			
					<input type="button" value="목록" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='list.do'" />
				</div>
				<div class="align_right">			
					<input type="submit" value="등록" class="btn_write btn_txt01" style="cursor: pointer;" />					
				</div>	
			</div>	
			<!--//게시판-->
		</div>
	</form>
</div>
<!-- 하단 디자인 -->

</body>
</html>
