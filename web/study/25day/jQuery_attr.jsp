<%--
  Created by IntelliJ IDEA.
  User: pc06
  Date: 2018-08-21
  Time: 오전 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jQuery_attr.jsp</title>
    <script src="https://code.jquery.com/jquery-3.3.1.js"> </script>
    <script type="text/javascript">
        $(document).ready(function () {
            var src = $('script').attr('src');
            alert(src);
        })
    </script>
</head>
<body>
    <h2>setAttr or getAttr</h2>
    <p>
        setAttr(key, value)
        <hr />
        getAttr(key)
    </p>
</body>
</html>
