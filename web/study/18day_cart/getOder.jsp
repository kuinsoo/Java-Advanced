<%@page import="javax.swing.JOptionPane"%>
<%@page import="javax.swing.JPanel"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String str = ""; 
 if(request.getParameter("search") ==null){
	 str = "select_allmembers";
 } else if ( request.getParameter("search") !=null){
	 str = request.getParameter("search");
 };
 %>
<% request.setCharacterEncoding("UTF-8"); %>
<% boolean isSql = false; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getOder</title>
<link rel="stylesheet" href="./tableStyle.css" />
<script type="text/javascript">

	
	function wiewMembers() {
		var f = document.fm;
		alert(f.search.value);

		f.action = "./getOder.jsp";
		f.submit();
	}
	
	function chageLangSelect() {

	}

</script>
</head>
<body>
	<h3>회원전체주문내역조회</h3>
	<hr />
<form name="fm" action="post">
	<table class="table_buttons" border = "1">
		<tr>
			<td>
			<select name="search">
				<option value="select_allmembers" <%= str.equals("select_allmembers") ? "selected" : "" %> >전체조회</option>
				<option value="select_member" <%= str.equals("select_member") ? "selected" : "" %> >회원조회</option>
			</select>
			<input class="buttons" type = "button" value="조회" onclick="wiewMembers()" />
			</td>
		</tr>	
	</table>
</form>
<%
	Connection	conn = null;
	Statement	stmt = null;
	ResultSet	rs	 = null;
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kuinsoo", "0728");
		stmt = conn.createStatement();
		String 	sql ="";
		if(str.equals("select_allmembers")){
			sql =  " Select  mem_id";
			sql += "     ,   mem_name";
			sql += "     ,   mem_add1 || ' '  || mem_add2 as mem_addr";
			sql += "     ,   nvl(cart_prod, '주문없음') as cart_prod";
			sql += "     ,   sum(nvl(cart_qty, 0)) as cart_qty";
			sql += " from member left join cart on (mem_id = cart_member(+))";
			sql += " Group by mem_id,mem_name,mem_add1 || ' ' || mem_add2 ,cart_prod";
			sql += " Order by mem_id asc, cart_prod asc";
		} else if (str == null){
			sql =  " Select  mem_id";
			sql += "     ,   mem_name";
			sql += "     ,   mem_add1 || ' '  || mem_add2 as mem_addr";
			sql += "     ,   nvl(cart_prod, '주문없음') as cart_prod";
			sql += "     ,   sum(nvl(cart_qty, 0)) as cart_qty";
			sql += " from member left join cart on (mem_id = cart_member(+))";
			sql += " where mem_id = 'a001' ";
			sql += " Group by mem_id,mem_name,mem_add1 || ' ' || mem_add2 ,cart_prod";
			sql += " Order by mem_id asc, cart_prod asc";
		} else {
			sql = " select mem_id";
			sql += "     ,   mem_name";
			sql += "     ,   mem_add1 || ' '  || mem_add2 as mem_addr";
			sql += "     ,   nvl(cart_prod, '주문없음') as cart_prod";
			sql += "     ,   sum(nvl(cart_qty, 0)) as cart_qty";
			sql += " from member, cart";
			sql += " where mem_id = cart_member";
			sql += " group by mem_id, mem_name, mem_add1 || ' '  || mem_add2 , cart_prod";
			sql += " order by mem_name asc, cart_prod asc";
		}
		System.out.println("SQL ==> " + sql);
		rs = stmt.executeQuery(sql);
%>
	<table class="bluetop" >
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>주소</th>
			<th>상품코드</th>
			<th>총주문건수</th>
			<th>비고</th>
		</tr>
<%	while(rs.next()){
	
%>
		<tr>
			<td><%=rs.getString("mem_id")%></td>
			<td><%=rs.getString("mem_name")%></td>
			<td><%=rs.getString("mem_addr")%></td>
			<td><%=rs.getString("cart_prod")%></td>
			<td><%=rs.getString("cart_qty")%></td>
			<td></td>
		</tr>
		
<%
	}
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