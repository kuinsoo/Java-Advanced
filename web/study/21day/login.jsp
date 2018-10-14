<%--
  Created by IntelliJ IDEA.
  User: SYSTEM
  Date: 2018-08-10
  Time: 오전 5:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <link href="login.css" rel="stylesheet" />
    <script>
        function goIndex() {

            // var requestValue = document.getElementById("mem_id").value;                   // 전송 파라미터 값
            // var theURL = "/servlet/servlet.ExampleCloseUrl?requestValue="+requestValue; // 전송 URL

            // 호출 한 부모 페이지에서 URL 호출
            opener.window.location = "./index.jsp";
            // 호출 한 뒤 현재 팝업 창 닫기 이벤트
            close();
        }

        function closePopup() {
            // 호출 한 부모 페이지에서 URL 호출
            opener.window.location = "./index.jsp";
            // 호출 한 뒤 현재 팝업 창 닫기 이벤트
            close();
        }
    </script>

</head>
<body>
    <h1>로그인페이지입니다</h1>
    <form name="fm" action="post">
        <div>
            <h4>아이디</h4>
            <input class="inputStyle"	type="text" 		name="mem_id" 			value="">
            <h4>비밀번호</h4>
            <input class="inputStyle"	type="password" 	name="mem_pass" 		value="">
            <br />
            <input class="button_a" type="button" value="가입하기"   onclick="goIndex()"/>
            <input class="button_b" type="button" value="취소하기"   onclick="closePopup()"/>
        </div>
    </form>

</body>
</html>
