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



            var isFade = false;
            var isId = "";
        function fadeSelect(id) {
            if(id != isId){
                isFade = false;
            }
            isFade = !isFade;
            if(isFade) {
                $(".fadeSelectClose").fadeOut('fast');
                $(".fadeSelect" + id).fadeToggle('fast');
                isId = id;
            }else {
                $(".fadeSelectClose").fadeOut('fast');
            }


        }

        function fadeSelect2(name) {


          $(".fadeSelect2" + name).fadeToggle('slow');
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

        System.out.println("SQL ==> " + sql1);
        rs1 = stmt1.executeQuery(sql1);

%>

<!-- 회원 목록 리스트 테이블 -->

<table class="bluetop" border="1">
    <tr>
        <th style="width: 1px"><input id="isCheck" type="checkbox" name="check" value="c000" onclick="checkAll()" /></th>
        <th style="width: 210px">아이디</th>
        <th style="width: 120px">이름</th>
    </tr>


    <%
        // 5. 출력하기

        while(rs1.next()){	//행을 하나씩 불러와준다.

    %>
    <tr>
        <td><input type="checkbox" name="check" value=<%=rs1.getString("mem_id")%> onclick="isCheck()" /></td>
        <td>
            <button onclick="fadeSelect('<%= rs1.getString("mem_id")%>')" > <%=rs1.getString("mem_id")%> </button>
        </td>
        <td><%=rs1.getString("mem_name")%></td>
    </tr>

        <%
            String sql2  = " select distinct PROD_NAME,prod_id,PROD_BUYER";
            sql2 += " from CART, prod, MEMBER ";
            sql2 += " where CART_PROD = PROD_ID ";
            sql2 += " and mem_id = CART_MEMBER ";
            sql2 += " and mem_id = '" + rs1.getString("mem_id") + "' " ;
            sql2 += " ORDER by PROD_NAME asc ";
            rs2 = stmt2.executeQuery(sql2);
            String str = "";
            while (rs2.next()){
        %>
    <tr class="<%="fadeSelect" + rs1.getString("mem_id")%> fadeSelectClose" style="display: none">

    <td style="background: #f3faee;"></td>
    <td>
            <%= rs2.getString("prod_id")%><br />
            <button onclick="fadeSelect2('<%= rs2.getString("PROD_BUYER") + rs2.getString("prod_id")%>')" > <%= rs2.getString("PROD_NAME")%> </button> <br />
    </td>
    <td>
        <div class="<%="fadeSelect2" + rs2.getString("PROD_BUYER")+rs2.getString("prod_id")%> fadeSelectClose" style="display: none">
        <%
            String   sql3  = " select distinct BUYER_ID,BUYER_NAME ";
            sql3 += " from  MEMBER, PROD,BUYER,CART ";
            sql3 += " where MEM_ID = CART_MEMBER  ";
            sql3 += " and   CART_PROD = PROD_ID ";
            sql3 += " and   PROD_BUYER = BUYER_ID ";
            sql3 += " and mem_id = '" + rs1.getString("mem_id") + "' " ;
            sql3 += " and BUYER_ID = '" + rs2.getString("PROD_BUYER") + "' " ;
            sql3 += " and prod_name = '" + rs2.getString("PROD_NAME") + "' ";
            sql3 += " ORDER by buyer_id asc " ;
            rs3 = stmt3.executeQuery(sql3);
          rs3.next();
        %>
            <%= rs3.getString("BUYER_ID")%><br />
            <%= rs3.getString("BUYER_NAME")%> <br />
        </div>
    </td>

    </tr>
        <%  }%>


<%--    <tr class="<%="fadeSelect2" + rs2.getString("PROD_NAME") %>"  style="display: none">
        <td >

            <%= rs3.getString("BUYER_ID")%><br />
            <%= rs3.getString("BUYER_NAME")%><br />
        </td>
    </tr>
            <% } %>--%>




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