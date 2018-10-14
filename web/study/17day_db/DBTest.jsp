<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <% request.setCharacterEncoding("EUC-KR"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>DBTest</title>
<link rel="stylesheet" href="./tableStyle.css" />
</head>
<body>
	<h3>회원 목록</h3>
	<hr />
<%
	//out.println("회원 목록을 출력하세요.");
	//out.println("<p> JSP에서도 태그를 <br />생성 할 수 \n있습니다.</p>");
	//System.out.println("<p> JSP에서도 태그를 <br />생성 할 수 \n있습니다.</p>");
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

	<table border="1">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td >주민등록번호</td>
			<td >주소</td>
		</tr>


<%
		// 5. 출력하기
		
		while(rs.next()){	//행을 하나씩 불러와준다.
			int i = 0;
%>
		<tr>
			<td><%=rs.getString("mem_id")%></td>
			<td><a href="./mem_view.jsp"><%=rs.getString("mem_name")%> </a></td>
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
		out.println("DBTest.jsp - 오류발생 :" + e);
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
	</table>
</body>
</html>