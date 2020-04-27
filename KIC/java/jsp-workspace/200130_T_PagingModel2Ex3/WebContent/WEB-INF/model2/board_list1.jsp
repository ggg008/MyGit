<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model1.BoardTO" %>
<%@ page import="model1.BoardListTO" %>
<%@ page import="java.util.ArrayList" %>  

<%
	BoardListTO listTO = (BoardListTO)request.getAttribute( "listTO" );

	int cpage = listTO.getCpage();

	int recordPerPage = listTO.getRecordPerPage();
	int totalRecord = listTO.getTotalRecord();
	int totalPage = listTO.getTotalPage();
	int blockPerPage = listTO.getBlockPerPage();
	
	int startBlock = listTO.getStartBlock();
	int endBlock = listTO.getEndBlock();
	
	ArrayList<BoardTO> boardLists = listTO.getBoardLists();
	
	StringBuffer sbHtml = new StringBuffer();

	for( BoardTO to : boardLists ) {
		String seq = to.getSeq();
		String subject = to.getSubject();
		String writer = to.getWriter();
		String wdate = to.getWdate();
		String hit = to.getHit();
		int wgap = to.getWgap();
			
		sbHtml.append( "<tr>" );
		sbHtml.append( "	<td>&nbsp;</td>" );
		sbHtml.append( "	<td>" + seq + "</td>" );
		sbHtml.append( "	<td class='left'>" );
		sbHtml.append( "		<a href='./view.do?cpage=" + cpage + "&seq=" + seq + "'>" + subject + "</a>" );
		if(wgap == 0) {
			sbHtml.append( "		&nbsp;<img src='./images/icon_hot.gif' alt='HOT'>" );
		}
		sbHtml.append( "	</td>" );
		sbHtml.append( "	<td>" + writer + "</td>" );
		sbHtml.append( "	<td>" + wdate + "</td>" );
		sbHtml.append( "	<td>" + hit + "</td>" );
		sbHtml.append( "	<td>&nbsp;</td>" );
		sbHtml.append( "</tr>" );
	}
%>	

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/board_list.css">
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
			<div class="bold">총 <span class="txt_orange"><%=totalRecord %></span>건</div>
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
<!-- 시작 -->
<%=sbHtml %>
<!-- 끝 -->
			</table>
		</div>	
		<!--//게시판-->

		<div class="align_right">
			<button type="button" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='./write.do?cpage=<%=cpage %>'">쓰기</button>
		</div>
		<!--페이지넘버-->
		<div class="paginate_regular">
			<div align="absmiddle">
<%
	if( startBlock == 1 ) {
		out.println( "<span>&lt;&lt;</span>" );	
	} else {
		out.println( "<span><a href='./list.do?cpage=" + (startBlock - blockPerPage) + "'>&lt;&lt;</a></span>" );
	}
	out.println( "&nbsp;" );

	if( cpage == 1 ) {
		out.println( "<span><a>&lt;</a></span>");
	} else {
		out.println( "<span><a href='./list.do?cpage=" + (cpage-1) + "'>&lt;</a></span>");
	}
	
	out.println( "&nbsp;&nbsp;" );
	
	for(int i=startBlock; i<=endBlock ; i++) {
		if( cpage == i ) {
			out.println( "<span style='color:red;'><a>[" + i + "]</a></span>" ); 	
		} else {
			out.println( "<span><a href='./list.do?cpage=" + i + "'>" + i + "</a></span>" );
		}
	}
	
	out.println( "&nbsp;&nbsp;" );
	
	if( cpage == totalPage ) {
		out.println( "<span><a>&gt;</a></span>");
	} else {
		out.println( "<span><a href='./list.do?cpage=" + (cpage+1) + "'>&gt;</a></span>");
	}

	out.println( "&nbsp;" );
	if( endBlock == totalPage ) {
		out.println( "<span><a>&gt;&gt;</a></span>" );
	} else {
		out.println( "<span><a href='./list.do?cpage=" + ( startBlock + blockPerPage ) + "'>&gt;&gt;</a></span>" );
}
%>			
			</div>
		</div>
		<!--//페이지넘버-->
	</div>
</div>
<!--//하단 디자인 -->

</body>
</html>
