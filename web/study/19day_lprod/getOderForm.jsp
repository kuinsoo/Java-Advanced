<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./tableStyle.css" />
<title>Insert title here</title>

</head>
<body>
	<h3>회원내역조회</h3>
	<hr />
	<table class="table_buttons">
		<tr>
			<td>
			<input class="buttons" type = "button" value="전체조회" onclick="wiewAllMembers()" />
			</td>
			<td>
			<input class="buttons" type = "button" value="회원조회" onclick="wiewMembers()" />
			</td>
		</tr>	
	</table>
</body>
</html>