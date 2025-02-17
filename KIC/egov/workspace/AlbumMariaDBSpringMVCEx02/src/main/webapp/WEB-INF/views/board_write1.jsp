﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String cpage = (String)request.getAttribute( "cpage" );
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
window.onload = function() {
	document.getElementById('boardsubmit').onclick = function() {
		if(document.boardfrm.info.checked == false) {
			alert('동의를 하셔야 합니다.');
			return false;
		}
		if(document.boardfrm.writer.value.trim() == "") {
			alert('이름을 입력하셔야 합니다.');
			return false;				
		}
		if(document.boardfrm.password.value.trim() == "") {
			alert('비밀번호를 입력하셔야 합니다.');
			return false;				
		}
		if(document.boardfrm.subject.value.trim() == "") {
			alert('제목을 입력하셔야 합니다.');
			return false;				
		}
		if(document.boardfrm.upload.value.trim() == "") {
			alert('파일 이름을 입력하셔야 합니다.');
			return false;				
		} else {
			var ext = document.boardfrm.upload.value.split('.');
			if( ext[ext.length-1] != 'jpg' && ext[ext.length-1] != 'jpeg' && ext[ext.length-1] != 'gif' && ext[ext.length-1] != 'png' ) {
				alert('이미지 파일을 입력하셔야 합니다.');
				return false;
			}
		}
		
		document.boardfrm.submit();
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

	<form action="board_write1_ok.do" method="post" name="boardfrm" enctype="multipart/form-data">
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
				<tr>
					<th>내용</th>
					<td colspan="3">
						<textarea name="content" class="board_editor_area"></textarea>
					</td>
				</tr>
				<tr>
					<th>파일첨부</th>
					<td colspan="3"><input type="file" name="upload" value="" class="board_write_input" /></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td colspan="3"><input type="text" name="mail1" value="" class="board_write_input_100"/> @ <input type="text" name="mail2" value="" class="board_write_input_100"/></td>
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
							<input type="checkbox" name="info" value="1" class="input_radio"> 개인정보 수집 및 이용에 대해 동의합니다.
						</div>
					</td>
				</tr>
				</table>
			</div>

			<div class="btn_area">
				<div class="align_left">			
					<input type="button" value="목록" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='board_list1.do?cpage=<%=cpage %>'" />
				</div>
				<div class="align_right">			
					<input type="button" value="등록" id="boardsubmit" class="btn_write btn_txt01" style="cursor: pointer;" />					
				</div>	
			</div>	
			<!--//게시판-->
		</div>
	</form>
</div>
<!-- 하단 디자인 -->

</body>
</html>
