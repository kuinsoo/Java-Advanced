<%--
  Created by IntelliJ IDEA.
  User: pc06
  Date: 2018-08-30
  Time: 오전 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>click_event.jsp</title>
    <script src="https://code.jquery.com/jquery-3.3.1.js" ></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $("h2").css("background", "red");
            $("h2").click(function clickWWW(){
                alert('구인수');
            });

        });
    </script>
</head>
<body>
    <%--    jQuery 클릭이벤트를 만들어 만들어 주세요
            아래 h2이 클릭이 되면 ,,,
            "클릭되었습니다" 창이 뜨게 해주세요
     --%>
    <h2 >클릭해주세요</h2>
</body>
</html>
