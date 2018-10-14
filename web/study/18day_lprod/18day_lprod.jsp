<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% String str1 = request.getParameter("lprod_cd"); %>
 <% String str2 = request.getParameter("prod_cd"); %>
 
 <% String lprod_cd = "all";
 if(request.getParameter("lprod_cd") != null ){
	 lprod_cd = request.getParameter("lprod_cd");
 }
 	String prod_cd = "all";
 	if(request.getParameter("prod_cd") != null) {
 		prod_cd = request.getParameter("prod_cd");
 	}
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./tableStyle.css" />
<script type="text/javascript">

	function goLprod(){
		var f = document.fm;
		alert(f.lprod_cd.value);
		f.action = "./18day_lprod.jsp"
		f.submit();
		
	}
	
	function goProd() {
		var f = document.fm;
		alert(f.prod_cd.value);
		f.action = "./18day_lprod.jsp"
		f.submit();
	}


</script>
</head>
<body>
	<h3>구매내역조회하기</h3>
	<hr />
	
	
	
<%
	Connection	conn = null;
	Statement	stmt1 = null;
	Statement	stmt2 = null;
	Statement	stmt3 = null;
	ResultSet	rs1	 = null;
	ResultSet	rs2	 = null;
	ResultSet	rs3	 = null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kuinsoo", "0728");
		stmt1 = conn.createStatement();
		stmt2 = conn.createStatement();
		stmt3 = conn.createStatement();
		String 	sql1 ="";
		String 	sql2 ="";
		String 	sql3 ="";
		
		sql1 = " select * from lprod ";
		System.out.println("SQL ==> " + sql1);
		rs1 = stmt1.executeQuery(sql1);
%>


	<form name="fm" action="post">
		<table class="table_buttons" >
			<tr>
				<td>
				<select name="lprod_cd" onchange="goLprod()">
					<option value="all">:::상품분류 선택:::</option>
					<%
					String lprod_cd_selected = "";
					while(rs1.next()){ 
					if(rs1.getString("lprod_gu").equals(lprod_cd)) {
						lprod_cd_selected = "selected";
					}else {
						lprod_cd_selected = "";
					}
					%>
					
					<option value="<%=rs1.getString("lprod_gu") %>" <%= lprod_cd_selected %>> <%=rs1.getString("lprod_nm") %></option>
		
					<%		}%>
		
				</select>
				<select name="prod_cd" onchange="goProd()">
					<option value="all" >:::상품 선택:::</option> 
				 	<%	sql2 = " select prod_name from lprod , prod where lprod_gu = prod_lgu and prod_lgu = '" + str1 + "'"; 
					if(!lprod_cd.equals("all") && lprod_cd != null){	
				 		rs2 = stmt2.executeQuery(sql2);
					}
						String prod_cd_selected ="";
						while(rs2.next()){
							if(rs2.getString("prod_name").equals(prod_cd)){
								prod_cd_selected = "selected";
							} else {
								prod_cd_selected ="";
							}
					%>
					<option value="<%=rs2.getString("prod_name") %>" <%=prod_cd_selected %>><%=rs2.getString("prod_name") %> </option>
					<% } %> 
					
				</select>	
				</td>
			</tr>	
		</table>
	</form>
	
	<table class="bluetop" >
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>취미</th>
			<th>구매상품명</th>
			<th>비고</th>
		</tr>
	
	
<% 
	if(!prod_cd.equals("all") && request.getParameter("prod_cd") != null) {
	sql3 = " select mem_id ";
	sql3+= "     ,   mem_name ";
	sql3+= "     ,   mem_like ";
	sql3+= "     ,   prod_name ";
	sql3+= " from member ,cart,prod ";
	sql3+= " where mem_id = cart_member ";
	sql3+= " and   cart_prod = prod_id ";
	sql3+= " and   prod_lgu = '" + lprod_cd + "' ";
	sql3+= " and   prod_name = '" + prod_cd + "' ";
	
	rs3 = stmt3.executeQuery(sql3);
	
	while(rs3.next()){
%>
		<tr>
			<td><%= rs3.getString("mem_id")%></td>
			<td><%= rs3.getString("mem_name")%></td>
			<td><%= rs3.getString("mem_like")%></td>
			<td><%= rs3.getString("prod_name")%></td>
			<td></td>
		</tr>


<%
	}
	}
	} catch(Exception e) {
			System.out.println("DBTest.jsp - 오류발생 :" + e);
			out.println("DBTest.jsp - 오류발생 :" + e);
		}finally {
			if(rs1!=null) {
				rs1.close();
			}
			if(rs2!=null) {
				rs2.close();
			}
			if(stmt1 != null ) {
				stmt1.close();
			}
			if(stmt2 != null ) {
				stmt2.close();
			}
			if(conn != null ) {
				conn.close();
			}
		}
%>
	</table>
</body>
</html>