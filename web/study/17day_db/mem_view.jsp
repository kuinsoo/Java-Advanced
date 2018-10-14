<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <% request.setCharacterEncoding("EUC-KR"); %>
 <%
 
 	//목록에서 던저주는 파라메터 받기.. 
 	String mem_id = request.getParameter("mem_id");
 
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
 		   sql +=" where mem_id= '" + mem_id + "' ";
 			sql += " order by 3";
 	System.out.println("Sql => " + sql);
 	rs = stmt.executeQuery(sql);
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원관리 :: 회원 상세정보 조회</title>
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

<!-- Post 방식 -->
<form name="fm" action="post">
	<input type="hidden" name="mem_id" value="<%=mem_id %>"   />
</form>


	<h3>회원상세정보조회페이지</h3>
	<hr />
	
<%	// 5. 출력
 	while(rs.next()){
  	
 %>
 	<table class="table_buttons">
		<tr>
	 <td><input class="buttons" type="button" 	name="button"	 value="목록가기" 		onclick= "goList()" /></td>
	 <td><input class="buttons"	type="button"	name="update"	 value="수정하기(get)" 	onclick= "goUpdateFrom_get('<%=mem_id %>')" />	</td>
	 <td><input class="buttons" type="button"	name="delete"	 value="삭제하기(get)" 	onclick= "goDelete_get('<%=mem_id %>')"  />		</td>
	 <td><input class="buttons" type="button"	name="update"	 value="수정하기(post)" onclick= "goUpdateFrom_post('<%=mem_id %>')" />	</td> 
	 <td><input class="buttons" type="button"	name="delete"	 value="삭제하기(post)" onclick= "goDelete_post('<%=mem_id %>')"  />	</td>
	 	</tr>
	</table>
 
	<table class="bluetop" border="1">
		<tr>
			<th>아이디							</th>
			<td><%=rs.getString("mem_id")%>		</td>
			<th>패스워드						</th>
			<td><%=rs.getString("mem_pass")%>	</td>
		</tr>
		
		<tr>
			<th>이　　름</th>
			<td><%=rs.getString("mem_name")%></td>
			<th>생년월일</th>
			<td><%=rs.getDate("mem_bir")%></td>
		</tr>
		
		<tr>
			<th>주민번호</th>
			<td colspan="3"> <%=rs.getString("mem_regno")%></td>
		</tr>
		
		<tr>
			<th>주　　소</th>
			<td colspan="3"> <%=rs.getString("mem_add")%></td>
		</tr>
	</table>

	<!-- 버튼 만들기 -->
	<!-- 
		* 모든 기능처리는 4가지 (CRUD) 관점에서 만듭니다.
		- 입력(C), 수정(U), 삭제(D), 조회(R) - 목록 ,상세보기
		- 	2		2		 1			2
		
		* 목록 이벤트 -> 입력 이벤트, 상세보기 이벤트 
		* 상세보기에서 이벤트 -> 수정 이벤트, 삭제 이벤트
		
		1. 목록가기(뒤로가기)
		2. 수정하기	: mem_updateForm.jsp
						mem_update.jsp
		3. 삭제하기	:	mem_delete.jsp
	 -->

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