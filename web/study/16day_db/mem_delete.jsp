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
<h3>�����ϱ�</h3>
	<hr />
<% 
	Connection	conn = null;
	Statement	stmt = null;
	ResultSet	rs	 = null;
	String mem_id = request.getParameter("mem_id");
	try{
		// 1. ����̹� ����..
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. Ŀ�ؼ� ���..
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kuinsoo", "0728");
		// 3. ������ü(SQL���� �Ѱܹޱ�) ���
		stmt = conn.createStatement();
		// 4. ����� ���
		String sql = " Delete From member Where mem_id = '" + mem_id + "'";
				
		System.out.println("SQL ==> " + sql);
		int i = stmt.executeUpdate(sql);
		
		if( i > 0) {
%>
			<script type="text/javascript">
				alert("����");
				location.href = "./mem_list.jsp";
			</script> 
<%
		} else if ( i == 0 )
		{
%>
			<script type="text/javascript">
				alert("ã�� �� ���� ���̵� �Դϴ�.");
				location.href = "./mem_list.jsp";
			</script> 

<%
		} else {
%>
			<script type="text/javascript">
			alert("����");
			location.href = "./mem_list.jsp";
			</script> 
<%
		}
%>
	
	<!-- ���� �ϱ�
	1. ���� ����..
	2. ������ �����ϸ� -> 	"���� ���� " �޽��� �����ֱ�..
	
			�����ϸ� -> 	"�����Ͽ����ϴ�" �޽��� �����ְ�, �ڷΰ���.. -->
		
	<form name="fm" method="get" >
	 
	 || <input type="button" name="button"	 value="��ϰ���" onclick= "goList()" /> ||
	</form>
<%
		} catch(Exception e) {
		System.out.println("DBTest.jsp - �����߻� :" + e);
		out.println("DBTest.jsp - �����߻� :" + e);
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