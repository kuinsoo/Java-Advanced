<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %><%--
  Created by IntelliJ IDEA.
  User: pc06
  Date: 2018-08-24
  Time: 오전 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mem_search.jsp</title>
    <link rel="stylesheet" href="mem_search.css" />
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript">

        var str= "";
        var rep= "";
        function rbAction(){
            $(".cls_Out").fadeOut("fast");
            var f = document.getElementsByName("rb");
            for (var i= 0; i< f.length; i++){
                if(f[0].checked){
                    str = document.getElementsByName("at")[0].innerHTML;
                    rep = str.replace("성별","지역");
                    document.getElementsByName("at")[0].innerHTML = rep;

                    str = document.getElementsByName("at")[1].innerHTML;
                    rep = str.replace("회원아이디","지역상품");
                    document.getElementsByName("at")[1].innerHTML = rep;

                    str = document.getElementsByName("at")[2].innerHTML;
                    rep = str.replace("회원명","총구매량");
                    document.getElementsByName("at")[2].innerHTML = rep;

                } else if (f[1].checked){
                    str = document.getElementsByName("at")[0].innerHTML;
                    rep = str.replace("지역","성별");
                    document.getElementsByName("at")[0].innerHTML = rep;

                     str = document.getElementsByName("at")[1].innerHTML;
                     rep = str.replace("회원아이디","지역상품");
                    document.getElementsByName("at")[1].innerHTML = rep;

                    str = document.getElementsByName("at")[2].innerHTML;
                    rep = str.replace("회원명","총구매량");
                    document.getElementsByName("at")[2].innerHTML = rep;

                } else {
                    str = document.getElementsByName("at")[0].innerHTML;
                    rep = str.replace("성별","지역");
                    document.getElementsByName("at")[0].innerHTML = rep;

                    str = document.getElementsByName("at")[1].innerHTML;
                    rep = str.replace("지역상품","회원아이디");
                    document.getElementsByName("at")[1].innerHTML = rep;

                    str = document.getElementsByName("at")[2].innerHTML;
                    rep = str.replace("총구매량","회원명");
                    document.getElementsByName("at")[2].innerHTML = rep;
                }


                if(f[i].checked){
                $(".cls_" + f[i].value).fadeToggle('slow');
                }
            }



        }

        $(document).ready(function () {
            $(".table_even tr:odd").css("background", "#ffffea");
            $(".table_even tr:even").css("background", "#ffffcf");
            $(".table_even th").css("background", "#dbf9fd");
        });
    </script>
</head>
<body>
<h1>지역별 회원 정보</h1>
<hr />
<%
    /*
        아래 요청항목에 해당하는 정보를 조회해주세요
        요청항목에 대해서는 페이지를 기획하여 개발해 주시면 됩니다.
        (페이지 수량은 제한을 두지 않습니다.)

        요청항목: 회원 지역별 회원정보,
                    회원 지역별 선호하는 상품분류정보,
                    회원 성별 선호하는 상품분류정보

        위 요청항목을 표현 할 항목(필드)들은 각자 기획해 주시면됩니다.
    */

    Connection   connection   =   null;
    Statement    statement   =   null;
    ResultSet resultSet   =   null;
    int sum  = 0;
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kuinsoo", "0728");

        StringBuffer sql = new StringBuffer();
        sql.append(" select substr(mem_add1,0,2) as local, MEM_ID, MEM_NAME from MEMBER order by 1, 3 ");

        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql.toString());

%>
    <%-- jsp 영역 --%>
<form name="fm" method="post">
    <table class="table_even">
        <tr>
            <td colspan="3">
                <input type="radio" name="rb" value="rbLocal" onclick="rbAction()" /> 지역
                <label><input type="radio" name="rb" value="rbGender" onclick="rbAction()" /> 성별 </label>
                <label><input type="radio" name="rb" value="rbList" onclick="rbAction()" checked="checked" /> 리스트 </label>
            </td>
        </tr>
        <tr>
            <th name="at">지역</th>
            <th name="at">회원아이디</th>
            <th name="at">회원명</th>
        </tr>

    <%-- 끝 --%>
<%
    while(resultSet.next()) {
%>
    <%-- jsp 영역 --%>
        <tr class="cls_rbList cls_Out"  >
            <td><%= resultSet.getString("local")%></td>
            <td><%= resultSet.getString("MEM_ID")%></td>
            <td><%= resultSet.getString("MEM_NAME")%></td>
        </tr>
    <%-- 끝 --%>
<%
    }
    sql.setLength(0);
    sql.append("SELECT B.MEM_ADD , B.LPROD_NM , A.MAXCNT\n" );
    sql.append( "FROM(\n" );
    sql.append( "    SELECT MEM_ADD, MAX(CNT) AS MAXCNT\n" );
    sql.append( "    FROM (\n" );
    sql.append( "         SELECT SUBSTR(MEM_ADD1 , 0 , 2) AS MEM_ADD , LPROD_NM,\n" );
    sql.append( "                COUNT(LPROD_NM) AS CNT\n" );
    sql.append( "         FROM LPROD, PROD , CART , MEMBER\n" );
    sql.append( "         WHERE LPROD_GU = PROD_LGU\n" );
    sql.append( "           AND PROD_ID = CART_PROD\n" );
    sql.append( "           AND CART_MEMBER = MEM_ID\n" );
    sql.append( "         GROUP BY SUBSTR(MEM_ADD1 ,0,2) , LPROD_NM\n" );
    sql.append( "         ORDER BY MEM_ADD ASC\n" );
    sql.append( "         )\n" );
    sql.append( "    GROUP BY MEM_ADD\n" );
    sql.append( "    ) A,\n" );
    sql.append( "    (\n" );
    sql.append( "    SELECT SUBSTR(MEM_ADD1 , 0 ,2) AS MEM_ADD, LPROD_NM, COUNT(LPROD_NM) AS CNT\n" );
    sql.append( "    FROM LPROD , PROD , CART , MEMBER\n" );
    sql.append( "    WHERE LPROD_GU = PROD_LGU\n" );
    sql.append( "      AND PROD_ID = CART_PROD\n" );
    sql.append( "      AND CART_MEMBER = MEM_ID\n" );
    sql.append( "    GROUP BY SUBSTR(MEM_ADD1 , 0 ,2), LPROD_NM\n" );
    sql.append( "    ORDER BY MEM_ADD ASC\n" );
    sql.append( "    ) B\n" );
    sql.append( "WHERE A.MEM_ADD = B.MEM_ADD\n" );
    sql.append( "  AND A.MAXCNT = B.CNT");

    statement=null;
    resultSet=null;
    statement = connection.createStatement();
    resultSet = statement.executeQuery(sql.toString());

    while(resultSet.next()){
%>
    <%-- jsp 영역 --%>
        <tr class="cls_rbLocal cls_Out" style="display: none" >
            <td><%= resultSet.getString("MEM_ADD")%></td>
            <td><%= resultSet.getString("LPROD_NM")%></td>
            <td><%= resultSet.getString("MAXCNT")%></td>
        </tr>

    <%-- 끝 --%>

<% } %>
<%
    sql.setLength(0);
    sql.append("Select Decode(B.mem_sex, '1', '남성', '여성') as mem_sex, B.lprod_nm, A.maxCnt\n" );
        sql.append( "From (\n" );
        sql.append( "     Select mem_sex, max(cnt) as maxCnt\n" );
        sql.append( "     From (\n" );
        sql.append( "          Select substr(mem_regno2, 0, 1) as mem_sex, lprod_nm,\n" );
        sql.append( "                 count(lprod_nm) as cnt\n" );
        sql.append( "          From lprod, prod, cart, member\n" );
        sql.append( "          where lprod_gu = prod_lgu\n" );
        sql.append( "            And prod_id = cart_prod\n" );
        sql.append( "            And cart_member = mem_id\n" );
        sql.append( "          Group By substr(mem_regno2, 0, 1), lprod_nm\n" );
        sql.append( "          Order By mem_sex asc\n" );
        sql.append( "          )\n" );
        sql.append( "     Group By mem_sex\n" );
        sql.append( "     ) A,\n" );
        sql.append( "     (\n" );
        sql.append( "     Select substr(mem_regno2, 0, 1) as mem_sex, lprod_nm,\n" );
        sql.append( "            count(lprod_nm) as cnt\n" );
        sql.append( "     From lprod, prod, cart, member\n" );
        sql.append( "     where lprod_gu = prod_lgu\n" );
        sql.append( "       And prod_id = cart_prod\n" );
        sql.append( "       And cart_member = mem_id\n" );
        sql.append( "     Group By substr(mem_regno2, 0, 1), lprod_nm\n" );
        sql.append( "     Order By mem_sex asc\n" );
        sql.append( "     ) B\n" );
        sql.append( "Where A.mem_sex = B.mem_sex\n" );
        sql.append( "  And A.maxCnt = B.cnt");
        statement=null;
        resultSet=null;
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql.toString());
        while (resultSet.next()) {
%>

        <%-- jsp 영역 --%>
        <tr class="cls_rbGender cls_Out" style="display: none" >
            <td><%= resultSet.getString("mem_sex")%></td>
            <td><%= resultSet.getString("lprod_nm")%></td>
            <td><%= resultSet.getString("maxCnt")%></td>
        </tr>

        <%-- 끝 --%>
<% } %>
    </table>
</form>
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
