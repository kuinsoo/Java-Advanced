<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <% request.setCharacterEncoding("EUC-KR"); %>
 <%
 
 	//��Ͽ��� �����ִ� �Ķ���� �ޱ�.. 
 	String mem_id = request.getParameter("meme_id");
 
 	// DB ��ȸ �ؿ�
 	Connection 	conn = null;
 	Statement 	stmt = null;
 	ResultSet	rs 	 = null;
 	// 1. ����̹� ����
 	try{
 	Class.forName("oracle.jdbc.driver.OracleDriver");
	
 	// 2. ����
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","kuinsoo", "0728"); 
	
 	// 3. ������ü
 	stmt = conn.createStatement();
 	// 4. ������
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
<title>ȸ������ :: ȸ�� ������ ��ȸ</title>
</head>
<body>
	<h3>ȸ�� ������ ��ȸ ������</h3>
	<hr />
<%	// 5. ���
 	while(rs.next()){
  	
 %>
	<table border="1">
		<tr>
			<td>���̵�</td>
			<td><%=rs.getString("mem_id")%></td>
			<td>�н�����</td>
			<td><%=rs.getString("mem_pass")%></td>
		</tr>
		
		<tr>
			<td>�̸�</td>
			<td><%=rs.getString("mem_name")%></td>
			<td>�������</td>
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
	// 6. �ڿ� ����
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