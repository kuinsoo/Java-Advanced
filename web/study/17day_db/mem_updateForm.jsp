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
	<h3>회원정보수정 페이지</h3>
	<hr />
<%
	
	//out.println("회원 목록을 출력하세요.");
	//out.println("<p> JSP에서도 태그를 <br />생성 할 수 \n있습니다.</p>");
	//System.out.println("<p> JSP에서도 태그를 <br />생성 할 수 \n있습니다.</p>");
	Connection	conn = null;
	Statement	stmt = null;
	ResultSet	rs	 = null;
	try{
		// 1. 드라이버 연결..
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. 커넥션 얻기..
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kuinsoo", "0728");
		// 3. 구문객체(SQL문장 넘겨받기) 얻기
		stmt = conn.createStatement();
		// 4. 결과물 얻기
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
      <!-- member 테이블에 있는 컬럼들을 확인해서 입력페이지를 만들어 주세요
          날짜 타입은 그냥 text로 하면됩니다.

          선택이 필요한 값들이 있으면 선택 태그를 이용하세요
     -->
      					
	 패스워드: 			<input type="password" 	name="mem_pass" 		value="<%=rs.getString	("mem_pass" 		)%>"><br/>
	 이름: 				<input type="text" 		name="mem_name" 		value="<%=rs.getString	("mem_name" 		)%>"><br/>
     주민번호 앞자리: 	<input type="text" 		name="mem_regno1" 		value="<%=rs.getString	("mem_regno1" 		)%>"><br/>
     주민번호 뒷자리: 	<input type="text" 		name="mem_regno2" 		value="<%=rs.getString	("mem_regno2" 		)%>"><br/>
     생년월일 : 		<input type="date" 		name="mem_bir" 			value="<%=rs.getDate	("mem_bir" 			)%>"><br/>
     우편번호 : 		<input type="text" 		name="mem_zip" 			value="<%=rs.getString	("mem_zip" 			)%>"><br/>
	 주소1 : 			<input type="text" 		name="mem_add1" 		value="<%=rs.getString	("mem_add1" 		)%>"><br/>
	 주소2 : 			<input type="text" 		name="mem_add2" 		value="<%=rs.getString	("mem_add2" 		)%>"><br/>
	 집전화 : 			<input type="text" 		name="mem_hometel" 		value="<%=rs.getString	("mem_hometel" 		)%>"><br/>
	 회사전화 : 		<input type="text" 		name="mem_comtel" 		value="<%=rs.getString	("mem_comtel" 		)%>"><br/>
     휴대폰번호 : 		<input type="text" 		name="mem_hp" 			value="<%=rs.getString	("mem_hp" 			)%>"><br/>
     이메일 : 			<input type="text" 		name="mem_mail" 		value="<%=rs.getString	("mem_mail" 		)%>"><br/>
     직업 : 			<input type="text" 		name="mem_job"			value="<%=rs.getString	("mem_job"			)%>"><br/>
     취미 : 			<input type="text"		name="mem_like" 		value="<%=rs.getString	("mem_like" 		)%>"><br/>
     기념일명  : 		<input type="text" 		name="mem_memorial" 	value="<%=rs.getString	("mem_memorial" 	)%>"><br/>
     기념일날짜 : 		<input type="date" 		name="mem_memorialday" 	value="<%=rs.getDate	("mem_memorialday"	)%>"><br/>
     마일리지 : 		<input type="number" 	name="mem_mileage" 		value="<%=rs.getInt		("mem_mileage" 		)%>"><br/>
     삭제여부 : 		<input type="text" 		name="mem_delete" 		value="<%=rs.getString	("mem_delete" 		)%>"><br/>
   
 	<!-- <input type="submit" 	name="submit" 		value="검색하기"> -->
	 <table class="table_buttons">
		 <tr>
		 	<td><input class="buttons" type="button" name="button"	 value="목록가기" onclick= "goList()" /></td>
		 </tr>
	 </table>
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