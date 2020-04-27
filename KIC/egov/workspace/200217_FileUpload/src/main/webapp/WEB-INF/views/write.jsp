<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Write</title>
<script type="text/javascript">
	window.onload = function () 
	{
		/* 
		document.getElementById('uploadBtn2').onclick = function() {
			alert('uploadBtn1');
		};
		 */
	};
	
	function inputUploadBtn() {
		var uploadPath = document.getElementById('uploadPath1').value;
		//var pathElement = document.getElementById('uploadPath1').value.split('.');
		//확장자 분리 : 일차원적인 방법(확장자가 없는 파일일 경우엔? ex : 리눅스)
		
		//alert('입력 : ' + pathElement[pathElement.length - 1]);
		
		
		if(uploadPath.value == ''){
			alert('파일 이름을 입력하셔야 합니다');
			return false;
		} else {
			var ext = document.getElementById('uploadPath1').value.split('.');
			ext = ext[ext.length - 1];
			if( ext != 'jpg' && ext != 'png' && ext != 'gif') {
				alert('이미지 파일을 입력하셔야 합니다');
				return false;
			}
		}
			
		document.frm.submit();	
		
	};	
	
	
</script>

</head>
<body>
write.jsp
<form action="write_ok.do" method="get" > <!-- 이름이 있는 값만 보냄 -->
DATA-GET : <input type="text" name="data">
<input type="submit" value="submit">
</form>

<br><br>

<form action="write_ok.do" method="post" name="frm" enctype="multipart/form-data">
FILE : <input type="file" id="uploadPath1" name="upload"> <!-- name은 subContorller의 파라메터 명과 매핑 -->
<input type="button" value="BTN" onclick="return inputUploadBtn()">
</form>

</body>
</html>