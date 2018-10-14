<%--
  Created by IntelliJ IDEA.
  User: pc06
  Date: 2018-08-23
  Time: 오후 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>max_orders.jsp</title>
</head>
<body>
    <%
        /*
            제일 많이 판매된 인기 상품에 대한 상품정보를 조회하려고 합니다.
            판매상품아이디, 상품명, 상품판매가격, 최고판갯수를 표혀냏 주세요.
            (제일 많이 판매된 갯수가 여러개인 경우 모두 표현해주세요.`)
        */
    %>

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

            sql.append(" select  PROD_ID,prod_name,PROD_SALE,sum(CART_QTY) as sums");
            sql.append(" from CART, PROD");
            sql.append(" where CART_PROD = PROD_ID");
            sql.append(" group by PROD_ID,prod_name,PROD_SALE");
            sql.append(" order by sums desc");

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql.toString());
    %>
    <h1>통계화면</h1>
    <hr />

    <table id="tb_dashboarder">
        <tr id="tr_header">
            <th>판매상품아아디</th>
            <th>상품명</th>
            <th>상품판매가격</th>
            <th>최고판매갯수</th>
        </tr>
        <%
            while(resultSet.next()){
        %>
        <tr id="tr_container">
            <td><%= resultSet.getString("PROD_ID")%></td>
            <td><%= resultSet.getString("prod_name")%></td>
            <td><%= resultSet.getString("PROD_SALE") %></td>
            <td><%= resultSet.getString("CART_QTY") %></td>
        </tr>
        <%
            }
        %>
  <%--      <tr id="tr_footer">
            <td colspan="2">총　　합</td>
            <td><%= sum%></td>
        </tr>--%>
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

</body>
</html>
