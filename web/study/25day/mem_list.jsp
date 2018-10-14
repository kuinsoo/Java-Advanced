<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>DBTest</title>
	<link rel="stylesheet" href="tableStyle.css" />
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript">

	// �ű� ȸ�� ���� �������� ����..
	function goInserForm() {
		/*	������ ��ȯ a�±��� href ��ũ�� ����
			�Ʒ� location����� ������ get������� ����
			�Ķ���Ͱ� ������ .. �׳� ������ �̸��� �ۼ�
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

    function fadeTest() {
		$('.fadeTest').fadeToggle('slow');
	}


	

</script>

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

		String sql = " select mem_id, mem_name, MEM_MILEAGE,MEM_MEMORIAL,MEM_MEMORIALDAY, ";
				sql += " (mem_regno1 || '-' || mem_regno2) as mem_regno, ";
				sql += " (mem_add1 || ' ' || mem_add2) as mem_add ";
				sql += " from member ";
				sql += " order by 2 ";
				
		System.out.println("SQL ==> " + sql);
		rs = stmt.executeQuery(sql);
%>
	<!-- �ű� ȸ������ ��ư ���̺� -->

		<table class="bluetop" border="1">
			<tr>

				<td style="float: right">
					<input  type = "button" value="ȸ������"  onclick="deleteMember()" />
					<input type = "button" value="�ű�ȸ������" onclick="goInserForm()" />
					<input type="button" value="ȸ������ �����" onclick="fadeTest()" />
			<!--���� [�ű�ȸ������]��ư�� Ŭ���ϸ�
				mem_inserForm.jsp �������� ������ ó�����ּ���..
				�ڹٽ�ũ��Ʈ �Լ��� ȣ���Ͽ� �̵�...
				�Լ� �̸���goInserForm �Դϴ�.  -->
				</td>

			</tr>
		</table>
	
	<!-- ȸ�� ��� ����Ʈ ���̺� -->

	<table class="bluetop" border="1">
		<tr>
			<th><input id="isCheck" type="checkbox" name="check" value="c000" onclick="checkAll()" /></th>
			<th>���̵�</th>
			<th>�̸�</th>
			<th >�ֹε�Ϲ�ȣ</th>
			<th >�ּ�</th>
		</tr>


<%
		// 5. ����ϱ�
		
		while(rs.next()){	//���� �ϳ��� �ҷ����ش�.
		int i = 0;
%>
		<tr>
		<td><input type="checkbox" name="check" value=<%=rs.getString("mem_id")%> onclick="isCheck()" /></td>
			<td><%=rs.getString("mem_id")%></td>
			<td><a href="./mem_view.jsp?mem_id=<%=rs.getString("mem_id")%>"><%=rs.getString("mem_name")%> </a></td>
			<td ><%=rs.getString("mem_regno")%></td>
			<td ><%=rs.getString("mem_add")%></td>
		</tr>
		<tr class="fadeTest"  style="display: none">

			<td colspan="5">
				����ϸ� : <%= rs.getString("MEM_MEMORIAL")%><br />
				����� : <%= rs.getString("MEM_MEMORIALDAY")%><br />
				���ϸ��� : <%= rs.getString("mem_mileage") %>

			</td>
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
		out.print("DBTest.jsp - �����߻� :" + e);
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