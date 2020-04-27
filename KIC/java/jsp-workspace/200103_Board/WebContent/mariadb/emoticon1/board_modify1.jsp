<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- pool 추가된 부분(DriverManager대신 사용) -->
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.NamingException"%>
<%@ page import="javax.sql.DataSource"%>
<!--  -->
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.SQLException"%>

<%
	request.setCharacterEncoding("utf-8");

	String cpage = request.getParameter("cpage");
	String seq = request.getParameter("seq");

	String writer = "";
	String subject = "";
	String content = "";
	String mail[] = null;
	String emot = "";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	try {

		Context initCtx = new InitialContext();//톰캣 환경설정에 접근
		Context envCtx = (Context) initCtx.lookup("java:comp/env");//커넥션 풀링 접근(context 이용하여)
		DataSource dataSource = (DataSource) envCtx.lookup("jdbc/mariadb");

		conn = dataSource.getConnection();//풀링에서 커넥션 가져옴

		String sql = "SELECT writer, subject, content, mail, emot FROM emot_board1 WHERE seq = ?";//가능하면 *쓰지말고 다쓸것 
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, seq);

		rs = pstmt.executeQuery();

		if (rs.next()) {
			writer = rs.getString("writer");
			subject = rs.getString("subject");
			content = rs.getString("content");
			mail = !rs.getString("mail").equals("") ? rs.getString("mail").split("@") : null;
			emot = rs.getString("emot");

		}

	} catch (NamingException e) {
		System.out.println(e.getClass().getName() + " : " + e.getMessage());
	} catch (SQLException e) {
		System.out.println(e.getClass().getName() + " : " + e.getMessage());
	} finally {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
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
<link rel="stylesheet" type="text/css" href="../../css/board_write.css">
<script type="text/javascript">
	window.onload = function() {
		var selEmot = '<%=emot%>';
		var emots = document.frm.getElementsByClassName('input_radio');
		for (var i = 0; i < emots.length; ++i) {
			console.log(selEmot);
			emots[i].checked = (emots[i].value == selEmot);
		}
	};

	function frmsubmit() {
		if (document.getElementById("pass1").value.trim() == '') { /* 낱개는 아이디를 붙여 접근 */
			alert('비밀번호를 입력하셔야 합니다.');
			return false;
		}
	};
</script>

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
		<form action="board_modify1_ok.jsp" method="post" name="frm"
			onsubmit="return frmsubmit()">
			<input type="hidden" name="seq" value="<%=seq%>"> <input
				type="hidden" name="cpage" value="<%=cpage%>">
			<!-- 숨겨서 보내기 -->
			<div class="contents_sub">
				<!--게시판-->
				<div class="board_write">
					<table>
						<tr>
							<th class="top">글쓴이</th>
							<td class="top" colspan="3"><input type="text" name="writer"
								value="<%=writer%>" class="board_view_input_mail" maxlength="5"
								readonly /></td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="3"><input type="text" name="subject"
								value="<%=subject%>" class="board_view_input" /></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td colspan="3"><input type="password" id="pass1"
								name="password" value="" class="board_view_input_mail" /></td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3"><textarea name="content"
									class="board_editor_area"><%=content%></textarea></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td colspan="3"><input type="text" name="mail1"
								value="<%=mail[0]%>" class="board_view_input_mail" /> @ <input
								type="text" name="mail2" value="<%=mail[1]%>"
								class="board_view_input_mail" /></td>
						</tr>
						<tr>
							<th>이모티콘</th>
							<td colspan="3" align="center">
								<table>
									<tr>
										<td><img src="../../images/emoticon/emot01.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot01" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot02.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot02" class="input_radio" checked="checked" /></td>
										<td><img src="../../images/emoticon/emot03.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot03" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot04.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot04" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot05.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot05" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot06.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot06" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot07.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot07" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot08.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot08" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot09.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot09" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot10.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot10" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot11.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot11" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot12.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot12" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot13.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot13" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot14.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot14" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot15.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot15" class="input_radio" /></td>
									</tr>
									<tr>
										<td><img src="../../images/emoticon/emot16.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot16" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot17.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot17" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot18.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot18" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot19.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot19" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot20.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot20" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot21.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot21" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot22.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot22" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot23.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot23" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot24.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot24" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot25.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot25" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot26.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot26" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot27.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot27" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot28.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot28" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot29.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot29" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot30.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot30" class="input_radio" /></td>
									</tr>
									<tr>
										<td><img src="../../images/emoticon/emot31.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot31" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot32.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot32" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot33.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot33" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot34.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot34" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot35.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot35" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot36.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot36" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot37.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot37" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot38.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot38" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot39.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot39" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot40.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot40" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot41.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot41" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot42.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot42" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot43.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot43" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot44.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot44" class="input_radio" /></td>
										<td><img src="../../images/emoticon/emot45.png"
											width="25" /><br /> <input type="radio" name="emot"
											value="emot45" class="input_radio" /></td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</div>

				<div class="btn_area">
					<div class="align_left">
						<button type="button" class="btn_list btn_txt02"
							style="cursor: pointer;"
							onclick="location.href='board_list1.jsp?cpage=<%=cpage%>'">목록</button>
						<button type="button" class="btn_list btn_txt02"
							style="cursor: pointer;"
							onclick="location.href='board_view1.jsp?cpage=<%=cpage%>&seq=<%=seq%>'">보기</button>
					</div>
					<div class="align_right">
						<button type="submit" class="btn_write btn_txt01"
							style="cursor: pointer;">수정</button>
					</div>
				</div>
				<!--//게시판-->
			</div>
		</form>
	</div>
	<!-- 하단 디자인 -->

</body>
</html>
