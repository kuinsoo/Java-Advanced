<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>데이터 받기</h1>
	<hr />
	
	<%
		String mem_id = "test";
		String mem_pw = "testpw";
		
		mem_id = request.getParameter("mem_id");
		mem_pw = request.getParameter("mem_pw");
	
		if(mem_id.equals("a001")) {
			
	%>
	
	
	
	아이디 : <%= mem_id %>
	<br />
	패스워드 : <%= mem_pw %>
	
	<%
		}else {
			
		out.println("<script>alert('아이디/패스워드 확인해주세요!'); </script>");	
	}
	%>
	 
</body>
</html>