<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String isLogin = request.getParameter("isLogin");
%>

<script type="text/javascript">
	window.onload = function() {

		var sid = document.getElementById('searchId');
		var spw = document.getElementById('searchPasswd');

		if (sid != null) {
			sid.onclick = function() {
				//alert('searchId()');
				searchWinOpen();
			};
		}

		if (spw != null) {
			spw.onclick = function() {
				//alert('searchPasswd()');
				searchWinOpen();
			};
		}
	};

	function frmsubmit() {
		var iid = document.getElementById('input_id');
		var ipw = document.getElementById('input_pw');
		//alert('frmsubmit()' + iid.value + ipw.value);
		
		if(iid.value == ''){
			alert('아이디를 입력하셔야 합니다');
			return false;
		} else if(ipw.value == ''){
			alert('패스워드를 입력하셔야 합니다');
			return false;
		}

		return true;
	};
	
	//document.getElementById('search').onclick = function() {
	function searchWinOpen() {
		open( 'member_search.do', 'win', 'top=100,left=100,width=640,height=170' );
	};
	
	
</script>


<c:set var="il" value="<%=isLogin%>" />
<c:choose>
	<c:when test="${ il }">
		<!-- 로그인 후 -->
		<div class="con_title">
			<table align="right" >
				<tr>
					<td>
						<form action="./logout.do" method="post">
							<input type="hidden" name="curPageUrl"
								value=${ curPageUrl }>
							<p style="margin: 0px; text-align: right">
								<b>${ sessionScope.album_loginUser.name }</b>님 환영합니다.<input type="submit"
									value="로그아웃" class="btn_write btn_txt01"
									style="cursor: pointer;">
							</p>
						</form>
					</td>
					<td>&nbsp;</td>										
					<td>
						<form action="./member_modify1.do" method="post">
							<input type="hidden" name="curPageUrl"
								value="<%=(String) application.getAttribute("curPageUrl")%>">
							<p style="margin: 0px; text-align: right">
								<input type="submit" value="회원수정" class="btn_write btn_txt01"
									style="cursor: pointer;" />
							</p>
						</form>
					</td>
				</tr>
			</table>
		</div>
	</c:when>

	<c:otherwise>
		<!-- 로그인 전 -->
		<div class="con_title">
			<form action="./login.do" method="post" onsubmit="return frmsubmit()">
				<input type="hidden" name="curPageUrl"
					value="<%=(String) application.getAttribute("curPageUrl")%>">
				<p style="margin: -2px; text-align: right">
				<!-- 
					<a id="searchId" onmouseover="" style="cursor: pointer;"> 아이디 </a> ˙ 
				 -->	
					<a id="searchPasswd" onmouseover="" style="cursor: pointer;"> 아이디 · 비밀번호 찾기 </a>
					&nbsp;&nbsp;|&nbsp;&nbsp; <a href="member_write1.do">회원 가입</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" id="input_id" name="id"
						class="board_login_input" maxlength="5" placeholder="아이디" /> <input
						type="password" id="input_pw" name="password" class="board_login_input"
						placeholder="비밀번호" /> <input type="submit" value="로 그 인"
						class="btn_write btn_txt01" style="cursor: pointer;" />
				</p>
			</form>
		</div>
	</c:otherwise>
</c:choose>
