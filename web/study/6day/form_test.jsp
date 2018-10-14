<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form name="fm" action = "form_request.jsp" method = "get">

   <h1>회원 로그인을 해주세요.</h1>
   <hr/>
   
   <p>아이디: <input type = "text" name = "mem_id" value =""/>
   </p>
   
   
   <p>아이디: <input type = "password" name = "mem_pw" value =""/>
   </p>
   <hr/>
   
   <p>
      <input type = "submit" value = "로그인하기.."/>
   </p>
   

</form>

</body>
</html>