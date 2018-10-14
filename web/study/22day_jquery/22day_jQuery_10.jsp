<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %><%--
  ~ Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
  ~ Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
  ~ Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
  ~ Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
  ~ Vestibulum commodo. Ut rhoncus gravida arcu.
  --%>

<%--
  Created by IntelliJ IDEA.
  User: Mr.KKu
  Date: 2018-08-16
  Time: 오후 12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>22day_jQuery_10.jsp</title>
    <link rel="stylesheet" href="./tableStyle.css" />
    <script type="text/javascript" src="jquery-3.3.1.js"></script>
    <script type="text/javascript">

        $(document).ready(function () {

            $(".bluetop tr:even").css("background","#F9F6E0");
            $(".bluetop tr:odd").css("background","#ecefe3");
        });

    </script>
</head>
<body>
<h3>회원목록</h3>
<hr />
<%
    Connection	conn = null;
    Statement	stmt = null;
    ResultSet	rs	 = null;
    try{
        // 1. 드라이버 연결..
        Class.forName("oracle.jdbc.driver.OracleDriver");
        // 2. 커넥션 얻기..
        conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kuinsoo", "0728");
        // 3. 구문객체(SQL문장 넘겨받기) 얻기
        stmt = conn.createStatement();
        // 4. 결과물 얻기
        String sql = " select mem_id, mem_name, ";
        sql += " (mem_regno1 || '-' || mem_regno2) as mem_regno, ";
        sql += " (mem_add1 || ' ' || mem_add2) as mem_add ";
        sql += " from member ";
        sql += " order by 2 ";

        System.out.println("SQL ==> " + sql);
        rs = stmt.executeQuery(sql);
%>
<!-- 신규 회원가입 버튼 테이블 -->
<table class="table_buttons">
    <tr>
        <td>
            <%--<input class="buttons" type = "button" value="신규회원가입" onclick="goInserForm()" />--%>
        </td>
    </tr>
</table>
<!-- 회원 목록 리스트 테이블 -->
<table class="bluetop" >
    <tr>
        <th>아이디			</th>
        <th>이름			</th>
        <th>주민등록번호	</th>
        <th>주소			</th>
    </tr>
 <%
		// 5. 출력하기

		while(rs.next()){	//행을 하나씩 불러와준다.
			int i = 0;
%>
    <tr>
        <td><%=rs.getString("mem_id")%></td>
        <td><a href="./mem_view.jsp?mem_id=<%=rs.getString("mem_id")%>"><%=rs.getString("mem_name")%> </a></td>
        <td ><%=rs.getString("mem_regno")%></td>
        <td ><%=rs.getString("mem_add")%></td>
    </tr>
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
		}
		// 6. 자원 반남하기


	} catch(Exception e) {
		System.out.println("DBTest.jsp - 오류발생 :" + e);

	}finally {
		if(rs!=null) {
			rs.close();
		}
		if(stmt != null ) {
			stmt.close();
		}
		if(conn != null ) {
			conn.close();
		}
	}
%>
</body>
</html>
