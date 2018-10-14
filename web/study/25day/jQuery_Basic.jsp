<%--
  Created by IntelliJ IDEA.
  User: pc06
  Date: 2018-08-21
  Time: 오전 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jQuery_Basic</title>
    <script src="https://code.jquery.com/jquery-3.1.1.js" ></script>
    <script type="text/javascript">
        // jQuery 실행
        $(document).ready(function () {
           /* 기능 정의
                jQuery 를 이용해서 스타일 변경하기 =>  $(선택자).css("key", "value");  *1개 씩표현
                                 *1개 이상 스타일  => $(선택자).css({key : "value" , key : "value"});
           */
           // 이런
           $("h1").css({background:"yellow" , color:"white"});
        });
    </script>
</head>
<body>
    <h1>Header-1</h1>
    <h1>Header-2</h1>
    <h1>Header-3</h1>
</body>
</html>
