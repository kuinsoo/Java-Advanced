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
	<h3>ȸ�� ���</h3>
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
			<td>���̵�</td>
			<td>�̸�</td>
			<td >�ֹε�Ϲ�ȣ</td>
			<td >�ּ�</td>
		</tr>


<%
		// 5. ����ϱ�
		
		while(rs.next()){	//���� �ϳ��� �ҷ����ش�.
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
			out.print ("���̵� : " + rs.getString("mem_id"));
			out.print ("		");
			out.print ("��  �� : " + rs.getString("mem_name"));
			out.print ("		");
			out.print ("�ֹι�ȣ1: " + rs.getString("mem_regno1"));
			out.print ("		");
			out.print ("�ֹι�ȣ2: " + rs.getString("mem_regno2"));
			out.print ("		");
			out.print ("�ּ�1:  " + rs.getString("mem_add1"));
			out.print ("		");
			out.print ("�ּ�2: " + rs.getString("mem_add1"));
			
			out.print ("</pre>"); */
		}
		// 6. �ڿ� �ݳ��ϱ�
		
		
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
	</table>
</body>
</html>