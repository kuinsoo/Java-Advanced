<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<% request.getParameter("mem_id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>mem_delete</title>
<script type="text/javascript">
	
	function goList() {
		history.go(-1);
	} 

</script>
</head>
<body>
<h3>삭제하기</h3>
	<hr />
<% 
	Connection	conn = null;
	Statement	stmt = null;
	ResultSet	rs	 = null;
	String mem_id = request.getParameter("mem_id");
	try{
		// 1. 드라이버 연결..
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. 커넥션 얻기..
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kuinsoo", "0728");
		// 3. 구문객체(SQL문장 넘겨받기) 얻기
		stmt = conn.createStatement();
		// 4. 결과물 얻기
		String sql = " Delete From member Where mem_id = '" + mem_id + "'";
				
		System.out.println("SQL ==> " + sql);
		int i = stmt.executeUpdate(sql);
		
		if( i > 0) {
%>
			<script type="text/javascript">
				alert("성공");
				location.href = "./mem_list.jsp";
			</script> 
<%
		} else if ( i == 0 )
		{
%>
			<script type="text/javascript">
				alert("찾을 수 없는 아이디 입니다.");
				location.href = "./mem_list.jsp";
			</script> 

<%
		} else {
%>
			<script type="text/javascript">
			alert("실패");
			location.href = "./mem_list.jsp";
			</script> 
<%
		}
%>
	
	<!-- 삭제 하기
	1. 삭제 구현..
	2. 삭제가 성공하면 -> 	"삭제 성공 " 메시지 보여주기..
	
			실패하면 -> 	"실패하였습니다" 메시지 보여주고, 뒤로가기.. -->
		
	<form name="fm" method="get" >
	 
	 || <input type="button" name="button"	 value="목록가기" onclick= "goList()" /> ||
	</form>
<%
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
</body>
</html>