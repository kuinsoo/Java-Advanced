<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <% request.setCharacterEncoding("EUC-KR"); %>
 <%
 
 	//��Ͽ��� �����ִ� �Ķ���� �ޱ�.. 
 	String mem_id = request.getParameter("mem_id");
 
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
 		   sql +=" where mem_id= '" + mem_id + "' ";
 			sql += " order by 3";
 	System.out.println("Sql => " + sql);
 	rs = stmt.executeQuery(sql);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ������ :: ȸ�� ������ ��ȸ</title>
<link rel="stylesheet" href="./tableStyle.css" />
<script type="text/javascript">

 	function goList() {
		history.go(-1);
	} 
 	
	function goUpdateFrom_get(mem_id) {
		alert(mem_id);
		location.href = "./mem_updateForm.jsp?mem_id=" + mem_id;
	}
	
	
	function goUpdateFrom_post() {
		var f = document.fm;
		f.action = "./mem_updateForm.jsp?mem_id=" + mem_id;
		f.submit();
	}
			
	function goDelete_get(mem_id) {
	
		alert(mem_id);
		location.href = "./mem_delete.jsp?mem_id=" + mem_id;
	} 

	function goDelete_post(mem_id) {
		var f = document.fm;
		alert(mem_id);
		location.href = "./mem_delete.jsp?mem_id=" + mem_id;
		f.action = "./mem_delete.jsp?mem_id="+mem_id;
		f.submit();
	} 
</script>
</head>
<body>

<!-- Post ��� -->
<form name="fm" action="post">
	<input type="hidden" name="mem_id" value="<%=mem_id %>"   />
</form>


	<h3>ȸ����������ȸ������</h3>
	<hr />
	
<%	// 5. ���
 	while(rs.next()){
  	
 %>
 	<table class="table_buttons">
		<tr>
	 <td><input class="buttons" type="button" 	name="button"	 value="��ϰ���" 		onclick= "goList()" /></td>
	 <td><input class="buttons"	type="button"	name="update"	 value="�����ϱ�(get)" 	onclick= "goUpdateFrom_get('<%=mem_id %>')" />	</td>
	 <td><input class="buttons" type="button"	name="delete"	 value="�����ϱ�(get)" 	onclick= "goDelete_get('<%=mem_id %>')"  />		</td>
	 <td><input class="buttons" type="button"	name="update"	 value="�����ϱ�(post)" onclick= "goUpdateFrom_post('<%=mem_id %>')" />	</td> 
	 <td><input class="buttons" type="button"	name="delete"	 value="�����ϱ�(post)" onclick= "goDelete_post('<%=mem_id %>')"  />	</td>
	 	</tr>
	</table>
 
	<table class="bluetop" border="1">
		<tr>
			<th>���̵�							</th>
			<td><%=rs.getString("mem_id")%>		</td>
			<th>�н�����						</th>
			<td><%=rs.getString("mem_pass")%>	</td>
		</tr>
		
		<tr>
			<th>�̡�����</th>
			<td><%=rs.getString("mem_name")%></td>
			<th>�������</th>
			<td><%=rs.getDate("mem_bir")%></td>
		</tr>
		
		<tr>
			<th>�ֹι�ȣ</th>
			<td colspan="3"> <%=rs.getString("mem_regno")%></td>
		</tr>
		
		<tr>
			<th>�֡�����</th>
			<td colspan="3"> <%=rs.getString("mem_add")%></td>
		</tr>
	</table>

	<!-- ��ư ����� -->
	<!-- 
		* ��� ���ó���� 4���� (CRUD) �������� ����ϴ�.
		- �Է�(C), ����(U), ����(D), ��ȸ(R) - ��� ,�󼼺���
		- 	2		2		 1			2
		
		* ��� �̺�Ʈ -> �Է� �̺�Ʈ, �󼼺��� �̺�Ʈ 
		* �󼼺��⿡�� �̺�Ʈ -> ���� �̺�Ʈ, ���� �̺�Ʈ
		
		1. ��ϰ���(�ڷΰ���)
		2. �����ϱ�	: mem_updateForm.jsp
						mem_update.jsp
		3. �����ϱ�	:	mem_delete.jsp
	 -->

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