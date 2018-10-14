<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
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
    <script type="text/javascript">

        function signUp() {
            var f = document.fm;


            // var mem_id = document.getElementById("mem_id").value;
            var mem_id = f.mem_id.value;
            if(mem_id == "" || f.mem_id.length == 0) {
                alert("아이디를 입력해주세요");
                f.mem_id.focus();
                return;
            }
            var mem_pass = f.mem_pass.value;
            if(mem_pass == "" || f.mem_pass.length == 0){
                alert("패스워드를 입력해주세요");
                f.mem_pass.focus();
                return;
            }

            var mem_name = f.mem_name.value;
            if(mem_name == "" || f.mem_name.length == 0){
                alert("이름을 입력해주세요");
                f.mem_name.focus();
                return;
            }

            var mem_regno1 = f.mem_regno1.value;
            if(mem_regno1 == "" || f.mem_regno1.length == 0){
                alert("주소를 입력해주세요");
                f.mem_regno1.focus();
                return;
            }

            var mem_regno2 = f.mem_regno2.value;
            if(mem_regno2 == "" || f.mem_regno2.length == 0){
                alert("주소를 입력해주세요");
                f.mem_regno2.focus();
                return;
            }

            var mem_bir = f.mem_bir.value;
            if(mem_bir == "" || f.mem_bir.length == 0){
                alert("생년월일을 입력해주세요");
                f.mem_bir.focus();
                return;
            }

            var mem_zip = f.mem_zip.value;
            if(mem_zip == "" || f.mem_zip.length == 0){
                alert("우편번호를 입력해주세요");
                f.mem_zip.focus();
                return;
            }

            var mem_add1 = f.mem_add1.value;
            if(mem_add1 == "" || f.mem_add1.length == 0){
                alert("주소를 입력해주세요");
                f.mem_add1.focus();
                return;
            }

            var mem_add2 = f.mem_add2.value;
            if(mem_add2 == "" || f.mem_add2.length == 0){
                alert("주소를 입력해주세요");
                f.mem_add2.focus();
                return;
            }

            var mem_hometel = f.mem_hometel.value;
            if(mem_hometel == "" || f.mem_hometel.length == 0){
                alert("집전화번호를 입력해주세요");
                f.mem_hometel.focus();
                return;
            }

            var mem_comtel = f.mem_comtel.value;
            if(mem_comtel == "" || f.mem_comtel.length == 0){
                alert("회사전화번호를 입력해주세요");
                f.mem_comtel.focus();
                return;
            }

            var mem_hp = f.mem_hp.value;
            if(mem_hp == "" || f.mem_hp.length == 0){
                alert("휴대폰번호를 입력해주세요");
                f.mem_hp.focus();
                return;
            }

            var mem_mail = f.mem_mail.value;
            if(mem_mail == "" || f.mem_mail.length == 0){
                alert("이메일을 입력해주세요");
                f.mem_mail.focus();
                return;
            }

            var mem_job = f.mem_job.value;
            if(mem_job == "" || f.mem_job.length == 0){
                alert("직업을 입력해주세요");
                f.mem_job.focus();
                return;
            }

            var mem_like = f.mem_like.value;
            if(mem_like == "" || f.mem_like.length == 0){
                alert("취미를 입력해주세요");
                f.mem_like.focus();
                return;
            }

            var mem_memorial = f.mem_memorial.value;
            if(mem_memorial == "" || f.mem_memorial.length == 0){
                alert("기념일을 입력해주세요");
                f.mem_memorial.focus();
                return;
            }

            var mem_memorialdate = f.mem_memorialdate.value;
            if(mem_memorialdate == "" || f.mem_memorialdate.length == 0){
                alert("기념일자를 입력해주세요");
                f.mem_memorialdate.focus();
                return;
            }

            var mem_mileage = f.mem_mileage.value;
            if(mem_mileage == "" || f.mem_mileage.length == 0){
                alert("마일리지를 입력해주세요");
                f.mem_mileage.focus();
                return;
            }

            var mem_delete = f.mem_delete.value;
            if(mem_delete == "" || f.mem_delete.length == 0){
                alert("삭제여부를 입력해주세요");
                f.mem_delete.focus();
                return;
            }

            f.action = "./signup_com.jsp";
            f.submit();
        }

        function goBack() {history.go(-1);}

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
            <input type="button" value="가입하기"  class="button_a" onclick="signUp()" />
        </div>

    <div id="div_reset_signup" >
        <input class="button_ab"	type="reset" 		name="reset_signup" 		value="초기화">
        <input class="button_ab"	type="button" 		name="return_button" 		value="돌아가기"
               onclick=" goBack() ">
    </div>
    </form>


</body>
</html>
