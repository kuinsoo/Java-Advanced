<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <% request.setCharacterEncoding("EUC-KR"); %>
 <%
 
 	//목록에서 던저주는 파라메터 받기.. 
 	String mem_id = request.getParameter("meme_id");
 
 	// DB 조회 해요
 	Connection 	conn = null;
 	Statement 	stmt = null;
 	ResultSet	rs 	 = null;
 	// 1. 드라이버 연결
 	try{
 	Class.forName("oracle.jdbc.driver.OracleDriver");
	
 	// 2. 연결
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kuinsoo", "0728"); 
	
 	// 3. 구문객체
 	stmt = conn.createStatement();
 	// 4. 결과얻기
 	String sql = " select mem_id, mem_pass, mem_name, mem_bir, \n";
 		   sql +=" mem_regno1 || '-' || mem_regno2 as mem_regno, \n";
 		   sql +=" mem_add1 || ' ' || mem_add2 as mem_add \n";
 		   sql +=" from member \n";
 		   sql +=" where mem_id= '" + "l001" + "' ";
 			sql += " order by 3";
 	System.out.println("Sql => " + sql);
 	rs = stmt.executeQuery(sql);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원관리 :: 회원 상세정보 조회</title>
</head>
<body>
	<h3>회원 상세정보 조회 페이지</h3>
	<hr />
<%	// 5. 출력
 	while(rs.next()){
  	
 %>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><%=rs.getString("mem_id")%></td>
			<td>패스워드</td>
			<td><%=rs.getString("mem_pass")%></td>
		</tr>
		
		<tr>
			<td>이름</td>
			<td><%=rs.getString("mem_name")%></td>
			<td>생년월일</td>
			<td><%=rs.getString("mem_bir")%></td>
		</tr>
		
		<tr>
			<td></td>
			<td colspan="3"> <%=rs.getString("mem_reg")%></td>
		</tr>
		
		<tr>
			<td></td>
			<td colspan="3"> <%=rs.getString("mem_add")%></td>
		</tr>
	</table>
<%	
 	} 
} catch (Exception e) {
		
	} finally {
	// 6. 자원 해제
		if(rs != null){
			rs.close();
		}
		if(stmt!=null){
			stmt.close();
		}
		if(conn!=null){
			conn.close();
		}
	} %>
</body>
</html>