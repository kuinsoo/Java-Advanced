<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr.KKu
  Date: 2018-08-23
  Time: 오전 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dashboard.jsp</title>
    <link rel="stylesheet" href="dashboard.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js" ></script>
    <script type="text/javascript">

    </script>
</head>
<body>
    <%
        Connection connection   =   null;
        Statement   statement   =   null;
        ResultSet   resultSet   =   null;
        int sum  = 0;
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kuinsoo", "0728");


        StringBuffer  sql = new StringBuffer();
        sql.append(" select MEM_ID,");

        sql.append(" MEM_NAME,");
        sql.append(" nvl(sum(PROD_SALE * CART_QTY),0)  as salesum ");
        sql.append(" from MEMBER left outer join CART on (MEM_ID = CART_MEMBER)");
        sql.append(" left outer join PROD on (CART_PROD = PROD_ID)");
        sql.append(" group by MEM_ID, MEM_NAME");
        sql.append(" ORDER BY MEM_NAME asc, MEM_ID asc");

        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql.toString());
    %>
    <h1>통계화면</h1>
    <hr />

    <table id="tb_dashboarder">
        <tr id="tr_header">
            <th>회원아이디</th>
            <th>회원이름</th>
            <th>지출총액</th>
        </tr>
        <%
            while(resultSet.next()){
        %>
        <tr id="tr_container">
            <td><%= resultSet.getString("mem_id")%></td>
            <td><%= resultSet.getString("mem_name")%></td>
            <td><%= resultSet.getString("salesum") %></td>
            <% sum += Integer.parseInt(resultSet.getString("salesum"));%>
        </tr>
        <%
            }
        %>
        <tr id="tr_footer">
            <td colspan="2">총　　합</td>
            <td><%= sum%></td>
        </tr>
    </table>
<%
    }catch (Exception e) {
    System.out.println("SQLException : " + e);
    } finally {
        try {
            if(connection != null){connection.close();}
            if(statement != null){statement.close();}
            if(resultSet != null){resultSet.close();}
        }catch (Exception e2) {
            System.out.println("close : " + e2);
        }
    }

%>
</body>
</html>
