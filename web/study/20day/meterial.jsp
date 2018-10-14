<%--
  Created by IntelliJ IDEA.
  User: pc06
  Date: 2018-08-10
  Time: 오전 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>meterial</title>
    <meta name="viewport" content="	user_scalable=no,
								initial-scale=1,
								maximum-scale=1" />
    <style type="text/css">

        /* 스마트 폰일때.. */
        @media screen and (max-width: 767px) {
            body {
                background: #f5f6f7;
            }
        }
        /* 태블릿 PC 일때.. */
        @media screen and (min-width:768px ) and (max-width: 959px){
            body {
                background: #f5f6f7;
            }
        }
        /* 데스크 PC 일때...*/
        @media screen and (min-width: 960px) "WebContent/PDFS/ch08_반응형 웹.pdf"{
            body {
                background: #f5f6f7;
            }
        }

    </style>

    <script>

        function goSignup() {
            location.href = "./signup.jsp"
        }

        function goLogin() {
            var popupX = (window.screen.width / 2) - (470 / 2);
            // 만들 팝업창 좌우 크기의 1/2 만큼 보정값으로 빼주었음

            var popupY= (window.screen.height /2) - (360 / 2);
            // 만들 팝업창 상하 크기의 1/2 만큼 보정값으로 빼주었음
            var popUrl = "./login.jsp"

            var popOption = "width=470, height=360, top=" + popupY + ",left=" + popupX + ", " +
                "resizable=no, scrollbars=no, status=no;";    //팝업창 옵션(optoin)

            window.open(popUrl,"",popOption);
        }
    </script>
    <link rel="stylesheet" href="index.css" />
</head>
<body>
<%-- <a href="<%url%>"></a> --%>
<div id="top">
    <input class="button_top" type="button" name="login" value="로그인" onclick="goLogin()" />
    <input class="button_top" type="button" name="signup" value="회원가입" onclick="goSignup()" />
</div>
<div id="header"> 재료별 </div>

<div class="div_center">
    <ul id="menu">
        <li><a href="./thema.jsp">테마별　　　│</a></li>
        <li><a href="./world.jsp">　나라별　　　│</a></li>
        <li><a href="./meterial.jsp">　재료별　　　│</a></li>
        <li><a href="./cooking.jsp">　요리별</a></li>
    </ul>
</div>

<div class="div_menubar">
    <<img class="img_10" src="./image/menubar.png" alt="메뉴바" />
</div>
<%
    if( true ) { %>
<div id="product_container">
    <div id="products">
        <div class="product"> <img class="img_100" src="./image/meterial1.png" /></div>
        <div class="product"> <img class="img_100" src="./image/meterial2.png" /></div>
        <div class="product"> <img class="img_100" src="./image/meterial3.png" /></div>
        <div class="product"> <img class="img_100" src="./image/menu3.png" /></div>
    </div>
</div>
<% } %>
</body>
</html>
