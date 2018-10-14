<%--
  ~ Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
  ~ Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
  ~ Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
  ~ Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
  ~ Vestibulum commodo. Ut rhoncus gravida arcu.
  --%>

<%--
  Created by IntelliJ IDEA.
  User: pc06
  Date: 2018-08-16
  Time: 오후 8:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>22day_jQuery_Test</title>
    <script type="text/javascript" src="jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(function () {
            alert("오늘 복습 실화?");
        });
        $().ready(function () {
            $("h2").css({color:"pink", textAlign:"center"});
            $("hr").css({border:"1px solid #8d80cc"});
            $("h4").css("textAlign","center")
                .filter(":even").css("color","green").end()
                .filter(":odd").css("color","brown");

        });
    </script>
</head>
<body>
    <h2>22day_jQuery_Test</h2>
    <hr />

    <h4>행복해요^^</h4>
    <h4>언제나 난 가능해요 ^^</h4>
    <h4>일상도 행복하게 생각해요.</h4>
    <h4>코딩은 즐거워요 ^^</h4>
    <h4>자격증도 붙을꺼에요 ^^</h4>
    <h4>인생은 ! </h4>
    <h4>꾸</h4>
    <h4>인</h4>
    <h4>수</h4>


</body>
</html>
