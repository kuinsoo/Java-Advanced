<%--
  Created by IntelliJ IDEA.
  User: pc06
  Date: 2018-08-09
  Time: 오후 3:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signup</title>
    <link rel="stylesheet" href="signup.css" />
    <script>
        function goBack() {history.go(-1);}
        function signUp() {location = "./"}
    </script>
</head>
<body >
    <h1>회원가입</h1>
    <form name="fm" action="post">
        <div>
            <h4>아이디</h4>
            <input class="inputStyle"	type="text" 		name="mem_id" 			value="">
            <h4>비밀번호</h4>
            <input class="inputStyle"	type="password" 	name="mem_pass" 		value="">
            <h4>이름</h4>
            <input class="inputStyle"	type="text" 		name="mem_name" 		value="">
            <h4>주민번호</h4>
            <input class="inputStyle inputStyle2"	type="text" 		name="mem_regno1" 		value="">
            <input class="inputStyle inputStyle2"	type="text" 		name="mem_regno2" 		value="">
            <h4>생일</h4>
            <input class="inputStyle"	type="date" 		name="mem_bir" 			value="">
            <h4>우편번호</h4>
            <input class="inputStyle"	type="text" 		name="mem_zip" 			value="">
            <h4>주소</h4>
            <input class="inputStyle inputStyle2"	type="text" 		name="mem_add1" 		value="">
            <input class="inputStyle inputStyle2"	type="text" 		name="mem_add2" 		value="">
            <h4>집전화번호</h4>
            <input class="inputStyle"	type="text" 		name="mem_hometel" 		value="">
            <h4>회사전화번호</h4>
            <input class="inputStyle"	type="text" 		name="mem_comtel" 		value="">
            <h4>핸드폰번호</h4>
            <input class="inputStyle"	type="text" 		name="mem_hp" 			value="">
            <h4>이메일</h4>
            <input class="inputStyle"	type="text" 		name="mem_mail" 		value="">
            <h4>직업</h4>
            <input class="inputStyle"	type="text" 		name="mem_job"			value="">
            <h4>취미</h4>
            <input class="inputStyle"	type="text"			name="mem_like" 		value="">
            <h4>기념일</h4>
            <input class="inputStyle"	type="text" 		name="mem_memorial" 	value="">
            <h4>기념일날짜</h4>
            <input class="inputStyle"	type="date" 		name="mem_memorialdate" value="">
            <h4>마일리지</h4>
            <input class="inputStyle"	type="number" 		name="mem_mileage" 		value="">
            <h4>삭제여부</h4>
            <input class="inputStyle"	type="text" 		name="mem_delete" 		value="">
            <br />
            <input type="button" value="가입하기"  class="button_a" onclick="signUp()"/>
        </div>

    <div id="div_reset_signup" >
        <input class="button_ab"	type="reset" 		name="reset_signup" 		value="초기화">
        <input class="button_ab"	type="button" 		name="return_button" 		value="돌아가기"
               onclick=" goBack() ">
    </div>
    </form>


</body>
</html>
