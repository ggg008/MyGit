<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>parse</title>
<script type="text/javascript" src="../js/jquery-3.4.1.js"></script>
<script type="text/javascript">
	//변수를 선언합니다
	var xml = '';
	xml += '<friends>';
	xml += '<friend>';
	xml += '<name>연하진</name>';
	xml += '<language>Ruby</language>';
	xml += '</friend>';
	xml += '<friend>';
	xml += '<name>윤명월</name>';
	xml += '<language>Basic</language>';
	xml += '</friend>';
	xml += '<friend>';
	xml += '<name>윤하린</name>';
	xml += '<language>C#</language>';
	xml += '</friend>';
	xml += '</friends>';

	$(document).ready(function() {

		// 변수를 선언합니다
		var xmlDoc = $.parseXML(xml);

		$(xmlDoc).find('friend').each(function(index) {
			//변수를 선언합니다.
			var output = '';
			output += '<div>';
			output += '<h1>' + $(this).find('name').text() + '</h1>';
			output += '<p>' + $(this).find('language').text() + '</p>';
			output += '</div>';
			//출력합니다
			document.body.innerHTML += output;
		});

	});
</script>
</head>
<body>
</body>
</html>
