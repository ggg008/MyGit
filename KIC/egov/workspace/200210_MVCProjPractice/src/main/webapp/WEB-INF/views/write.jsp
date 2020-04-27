<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Write</title>
</head>
<body>
write.jsp
<form action="write_ok.do" method="get"> <!-- 이름이 있는 값만 보냄 -->
DATA-GET : <input type="text" name="data">
<input type="submit" value="submit">
</form>

<br><br>

<form action="write_ok.do" method="post">
DATA-POST : <input type="text" name="data">
<input type="submit" value="submit">
</form>

</body>
</html>