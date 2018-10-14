<%--
  Created by IntelliJ IDEA.
  User: Mr.KKu
  Date: 2018-08-22
  Time: 오전 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>base_table_fade.jsp</title>
    <link rel="stylesheet" href="tableStyle.css" />
    <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
    <script type="text/javascript">

        //신규 회원 가입 페이지로 가기..
        function goInserForm() {
            /*	페이지 전환 a태그의 href 링크와 유사
            아래 location방식은 무조건 get방식으로 전달
            파라메터가 없으면 .. 그냥 페이지 이름만 작성
            */
            location.href = "./mem_insertForm.jsp";
        }

        function deleteMember() {
            var chkBox = document.getElementsByName("check");
            for(var i = 0; i < chkBox.length; i++) {
                if(chkBox[i].checked == true){
                    alert (chkBox[i].value);
                    location.href = "./mem_delete.jsp?mem_id=" + chkBox[i].value;
                }
            }
        }

        var isTrue = false;
        function checkAll() {
            isTrue = !isTrue;

            var chkBox = document.getElementsByName("check");
            if( isTrue == true ){
                for(var i = 0; i < chkBox.length; i++) {
                    chkBox[i].checked = true;
                }
            } else {
                for(var i = 0; i < chkBox.length; i++) {
                    chkBox[i].checked = false;
                }
            }
        };

        function isCheck() {
            /* var chkBox = document.getElementsByName("check");
            for(var i = 0; i < chkBox.length; i++) {
                if(chkBox[i].checked == true)
                    alert (chkBox[i].value);
            }  */
        }

        function fadeTest() {
            $('.fadeTest').fadeToggle('slow');
        }

        function fadeSelect(id) {
            /* alert(".fadeSelect" + id); */
            $(".fadeClose").fadeOut('fast');
            $("#fadeSelect" + id).fadeToggle('slow');

        }




    </script>

</head>
<body>
<h3>회원목록</h3>
<hr />
<%
    //out.println("회원 목록을 출력하세요.");
    //out.println("<p> JSP에서도 태그를 <br />생성 할 수 \n있습니다.</p>");
    //System.out.println("<p> JSP에서도 태그를 <br />생성 할 수 \n있습니다.</p>");
    Connection conn = null;
    Statement stmt1 = null;
    Statement stmt2 = null;
    Statement stmt3 = null;
    ResultSet rs1	 = null;
    ResultSet rs2	 = null;
    ResultSet rs3	 = null;
    try{
        // 1. 드라이버 연결...
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // 2. 커넥션 얻기..
        conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kuinsoo", "0728");
        // 3. 구문객체(SQL문장 넘겨받기) 얻기
        stmt1 = conn.createStatement();
        stmt2 = conn.createStatement();
        stmt3 = conn.createStatement();
        // 4. 결과물 얻기

        String  sql1  = " select MEM_ID,MEM_NAME ";
                sql1 += " from member ";
                sql1 += " order by mem_name asc ";

       String   sql = " select MEM_ID,MEM_NAME,PROD_ID,PROD_NAME,BUYER_ID,BUYER_NAME ";
                sql += " from MEMBER, PROD,BUYER,CART ";
                sql += " where MEM_ID = CART_MEMBER ";
                sql += " and   CART_PROD = PROD_ID ";
                sql += " and   PROD_BUYER = BUYER_ID ";
                sql += " ORDER by MEM_NAME asc ";
  /*      String  sql2  = " select CART_NO,PROD_NAME ";
                sql2 += " from CART, prod, MEMBER ";
                sql2 += " where CART_PROD = PROD_ID ";
                sql2 += " and mem_id = CART_MEMBER ";
                sql2 += " and MEM_ID = '"+ "a001" + "' ";
                sql2 += " ORDER by CART_NO asc ";*/



        System.out.println("SQL ==> " + sql);
        rs1 = stmt1.executeQuery(sql);


%>

<!-- 회원 목록 리스트 테이블 -->

<table class="bluetop" border="1">
    <tr>
        <th><input id="isCheck" type="checkbox" name="check" value="c000" onclick="checkAll()" /></th>
        <th>아이디</th>
        <th>이름</th>
    </tr>


    <%
        // 5. 출력하기

        while(rs1.next()){	//행을 하나씩 불러와준다.

    %>
    <tr>
        <td><input type="checkbox" name="check" value=<%=rs1.getString("mem_id")%> onclick="isCheck()" /></td>
        <td>
            <button id=<%= rs1.getString("mem_id")%> value=<%= rs1.getString("mem_id") %>
                    onclick="fadeSelect('<%= rs1.getString("mem_id")%>')" > <%=rs1.getString("mem_id")%> </button>
        </td>
        <td><%=rs1.getString("mem_name")%></td>
    </tr>
    <%--<tr id="<%="fadeSelect" + rs1.getString("mem_id")%>" class="fadeClose"  style="display: none">--%>
        <%--<td></td>--%>
        <%--<td>--%>
            <%--<%= rs1.getString("CART_NO")%><br />--%>
            <%--<button id=<%= rs1.getString("PROD_NAME")%> value=<%= rs1.getString("PROD_NAME")%>--%>
                    <%--onclick="fadeSelect2('<%= rs1.getString("PROD_NAME")%>')" > <%= rs1.getString("PROD_NAME")%> </button> <br />--%>
        <%--</td>--%>
    <%--</tr>--%>

    <%--<tr id="<%="fadeSelect" + rs1.getString("PROD_NAME") %>"  style="display: none">--%>
        <%--<td></td>--%>
        <%--<td >--%>
    <%--<% String sql3  = " select BUYER_ID, BUYER_NAME ";--%>
                <%--sql3 += " from BUYER , PROD ";--%>
                <%--sql3 += " where BUYER_ID = PROD_BUYER ";--%>
                <%--sql3 += " and  PROD_NAME = " + rs2.getString("PROD_NAME") + " ";--%>
                <%--sql3 += " ORDER by BUYER_ID asc ";--%>
        <%--rs3 = stmt3.executeQuery(sql3);--%>
        <%--while (rs3.next()){--%>
    <%--%>--%>

            <%--<%= rs3.getString("BUYER_ID")%><br />--%>
            <%--<%= rs3.getString("BUYER_NAME")%><br />--%>
    <%--</tr>--%>
    <%--<% } %>--%>
        <%--</td>--%>



    <%
                /* 		out.print ("<pre>");
                out.print ("아이디 : " + rs.getString("mem_id"));
                out.print ("		");
                out.print ("이  름 : " + rs.getString("mem_name"));
                out.print ("		");
                out.print ("주민번호1: " + rs.getString("mem_regno1"));
                out.print ("		");
                out.print ("주민번호2: " + rs.getString("mem_regno2"));
                out.print ("		");
                out.print ("주소1:  " + rs.getString("mem_add1"));
                out.print ("		");
                out.print ("주소2: " + rs.getString("mem_add1"));

                out.print ("</pre>"); */

            // 6. 자원 반남하기

            }
        } catch(Exception e) {
            System.out.println("DBTest.jsp -오류발생 :" + e);
            out.print("DBTest.jsp - 오류발생:" + e);
        }finally {
            if(rs1!=null) {
                rs1.close();
            }
            if(rs2!=null) {
                rs2.close();
            }
            if(rs3!=null) {
                rs3.close();
            }
            if(stmt1 != null ) {
                stmt1.close();
            }
            if(stmt2 != null ) {
                stmt2.close();
            }
            if(stmt3 != null ) {
                stmt3.close();
            }
            if(conn != null ) {
                conn.close();
            }
        }
    %>

</table>

</body>
</html>