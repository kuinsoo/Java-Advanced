<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <% request.setCharacterEncoding("EUC-KR"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>mem_updateForm</title>
<link rel="stylesheet" href="./tableStyle.css" />
<script type="text/javascript">
	
	function goList() {
		history.go(-1);
	} 

</script>
</head>
<body>
	<h3>ȸ���������� ������</h3>
	<hr />
<%
	
	//out.println("ȸ�� ����� ����ϼ���.");
	//out.println("<p> JSP������ �±׸� <br />���� �� �� \n�ֽ��ϴ�.</p>");
	//System.out.println("<p> JSP������ �±׸� <br />���� �� �� \n�ֽ��ϴ�.</p>");
	Connection	conn = null;
	Statement	stmt = null;
	ResultSet	rs	 = null;
	try{
		// 1. ����̹� ����..
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. Ŀ�ؼ� ���..
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kuinsoo", "0728");
		// 3. ������ü(SQL���� �Ѱܹޱ�) ���
		stmt = conn.createStatement();
		// 4. ����� ���
	 	String mem_id 			= request.getParameter("mem_id"			);
		String mem_pass 		= request.getParameter("mem_pass" 		);
		String mem_name 		= request.getParameter("mem_name" 		);
		String mem_regno1 		= request.getParameter("mem_regno1" 	);
		String mem_regno2 		= request.getParameter("mem_regno2" 	);
		String mem_bir          = request.getParameter("mem_bir" 		);
		String mem_zip          = request.getParameter("mem_zip" 		);
		String mem_add1 		= request.getParameter("mem_add1" 		);
		String mem_add2 		= request.getParameter("mem_add2" 		);
		String mem_hometel      = request.getParameter("mem_hometel" 	);
		String mem_comtel 		= request.getParameter("mem_comtel" 	);
		String mem_hp 			= request.getParameter("mem_hp" 		);
		String mem_mail 		= request.getParameter("mem_mail" 		);
		String mem_job			= request.getParameter("mem_job"		);
		String mem_like		    = request.getParameter("mem_like" 		);
		String mem_memorial 	= request.getParameter("mem_memorial" 	);
		String mem_memorialday 	= request.getParameter("mem_memorialday");
		String mem_mileage	    = request.getParameter("mem_mileage" 	);
		String mem_delete 		= request.getParameter("mem_delete" 	);
		
		String sql = "";
			sql += " Select * From member";
				
		System.out.println("SQL ==> " + sql);
		rs = stmt.executeQuery(sql);
		rs.next();
		rs.getString("mem_id");
		
%>	
	
	<form name="fm" method="get" >
      <!-- member ���̺� �ִ� �÷����� Ȯ���ؼ� �Է��������� ����� �ּ���
          ��¥ Ÿ���� �׳� text�� �ϸ�˴ϴ�.

          ������ �ʿ��� ������ ������ ���� �±׸� �̿��ϼ���
     -->
      					
	 �н�����: 			<input type="password" 	name="mem_pass" 		value="<%=rs.getString	("mem_pass" 		)%>"><br/>
	 �̸�: 				<input type="text" 		name="mem_name" 		value="<%=rs.getString	("mem_name" 		)%>"><br/>
     �ֹι�ȣ ���ڸ�: 	<input type="text" 		name="mem_regno1" 		value="<%=rs.getString	("mem_regno1" 		)%>"><br/>
     �ֹι�ȣ ���ڸ�: 	<input type="text" 		name="mem_regno2" 		value="<%=rs.getString	("mem_regno2" 		)%>"><br/>
     ������� : 		<input type="date" 		name="mem_bir" 			value="<%=rs.getDate	("mem_bir" 			)%>"><br/>
     �����ȣ : 		<input type="text" 		name="mem_zip" 			value="<%=rs.getString	("mem_zip" 			)%>"><br/>
	 �ּ�1 : 			<input type="text" 		name="mem_add1" 		value="<%=rs.getString	("mem_add1" 		)%>"><br/>
	 �ּ�2 : 			<input type="text" 		name="mem_add2" 		value="<%=rs.getString	("mem_add2" 		)%>"><br/>
	 ����ȭ : 			<input type="text" 		name="mem_hometel" 		value="<%=rs.getString	("mem_hometel" 		)%>"><br/>
	 ȸ����ȭ : 		<input type="text" 		name="mem_comtel" 		value="<%=rs.getString	("mem_comtel" 		)%>"><br/>
     �޴�����ȣ : 		<input type="text" 		name="mem_hp" 			value="<%=rs.getString	("mem_hp" 			)%>"><br/>
     �̸��� : 			<input type="text" 		name="mem_mail" 		value="<%=rs.getString	("mem_mail" 		)%>"><br/>
     ���� : 			<input type="text" 		name="mem_job"			value="<%=rs.getString	("mem_job"			)%>"><br/>
     ��� : 			<input type="text"		name="mem_like" 		value="<%=rs.getString	("mem_like" 		)%>"><br/>
     ����ϸ�  : 		<input type="text" 		name="mem_memorial" 	value="<%=rs.getString	("mem_memorial" 	)%>"><br/>
     ����ϳ�¥ : 		<input type="date" 		name="mem_memorialday" 	value="<%=rs.getDate	("mem_memorialday"	)%>"><br/>
     ���ϸ��� : 		<input type="number" 	name="mem_mileage" 		value="<%=rs.getInt		("mem_mileage" 		)%>"><br/>
     �������� : 		<input type="text" 		name="mem_delete" 		value="<%=rs.getString	("mem_delete" 		)%>"><br/>
   
 	<!-- <input type="submit" 	name="submit" 		value="�˻��ϱ�"> -->
	 <table class="table_buttons">
		 <tr>
		 	<td><input class="buttons" type="button" name="button"	 value="��ϰ���" onclick= "goList()" /></td>
		 </tr>
	 </table>
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