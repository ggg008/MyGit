<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<title><%= request.getServletPath() %></title>



<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script> <!-- 라이브러리 순서 다를시 에러 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
	// $(document).ready() : jQuery 시작점 == main
	$(document).ready(function() {
		//내용
	})	
 

 

 
 	console.log('- 서버 :  <%=application.getServerInfo() %>');
	console.log('- 서블릿 :<%= application.getMajorVersion() %>.<%= application.getMinorVersion() %>');
 	console.log('- JSP : <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %> '); 
	
</script>
</head>

<!-- 
https://www.w3schools.com/bootstrap4/bootstrap_scrollspy.asp
-->

<body>



	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="#section1">Section 1</a>
			</li>			
			<li class="nav-item">
				<a class="nav-link" href="#section2">Section 2</a>
			</li>			
			<li class="nav-item">
				<a class="nav-link" href="#section3">Section 3</a>
			</li>			
			<li class="nav-item dropdown">
				<a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
					Section 4
				</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#section41">Link 1</a>
					<a class="dropdown-item" href="#section42">Link 2</a>
				</div>
			</li>		
		</ul>
	</nav>



	<div id="section1" class="container-fluid bg-success"
		style="padding-top: 70px; padding-bottom: 70px">
		<h1>Section 1</h1>
		<p>Try to scroll this section and look at the navigation bar while
			scrolling! Try to scroll this section and look at the navigation bar
			while scrolling!</p>
		<p>Try to scroll this section and look at the navigation bar while
			scrolling! Try to scroll this section and look at the navigation bar
			while scrolling!</p>
	</div>
	<div id="section2" class="container-fluid bg-warning"
		style="padding-top: 70px; padding-bottom: 70px">
		<h1>Section 2</h1>
		<p>Try to scroll this section and look at the navigation bar while
			scrolling! Try to scroll this section and look at the navigation bar
			while scrolling!</p>
		<p>Try to scroll this section and look at the navigation bar while
			scrolling! Try to scroll this section and look at the navigation bar
			while scrolling!</p>
	</div>
	<div id="section3" class="container-fluid bg-secondary"
		style="padding-top: 70px; padding-bottom: 70px">
		<h1>Section 3</h1>
		<p>Try to scroll this section and look at the navigation bar while
			scrolling! Try to scroll this section and look at the navigation bar
			while scrolling!</p>
		<p>Try to scroll this section and look at the navigation bar while
			scrolling! Try to scroll this section and look at the navigation bar
			while scrolling!</p>
	</div>
	<div id="section41" class="container-fluid bg-danger"
		style="padding-top: 70px; padding-bottom: 70px">
		<h1>Section 4 Submenu 1</h1>
		<p>Try to scroll this section and look at the navigation bar while
			scrolling! Try to scroll this section and look at the navigation bar
			while scrolling!</p>
		<p>Try to scroll this section and look at the navigation bar while
			scrolling! Try to scroll this section and look at the navigation bar
			while scrolling!</p>
	</div>
	<div id="section42" class="container-fluid bg-info"
		style="padding-top: 70px; padding-bottom: 70px">
		<h1>Section 4 Submenu 2</h1>
		<p>Try to scroll this section and look at the navigation bar while
			scrolling! Try to scroll this section and look at the navigation bar
			while scrolling!</p>
		<p>Try to scroll this section and look at the navigation bar while
			scrolling! Try to scroll this section and look at the navigation bar
			while scrolling!</p>
	</div>

</body>
</html>

