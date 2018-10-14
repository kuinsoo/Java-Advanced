<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
<title>mem_update</title>
<script type="text/javascript">
	
	function goList() {
		history.go(-1);
	} 

</script>
</head>
<body>
	<h3>수정</h3>
	<hr />

<%
	Connection	conn = null;
	Statement	stmt = null;
	PreparedStatement pstm = null;
	ResultSet	rs	 = null;
	try{
		// 1. 드라이버 연결..
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. 커넥션 얻기..
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kuinsoo", "0728");
		// 3. 구문객체(SQL문장 넘겨받기) 얻기
		stmt = conn.createStatement();
	
	
%>   
	
	아이디: 		 <%= request.getParameter("mem_id" 			)%><br />
	패스워드: 		 <%= request.getParameter("mem_pass" 		)%><br />
	이름: 			 <%= request.getParameter("mem_name" 		)%><br />
	주민번호 앞자리: <%= request.getParameter("mem_regno1" 		)%><br />
	주민번호 뒷자리: <%= request.getParameter("mem_regno2" 		)%><br />
	생년월일 : 		 <%= request.getParameter("mem_bir" 		)%><br />
	우편번호 : 		 <%= request.getParameter("mem_zip" 		)%><br />
	주소1 : 		 <%= request.getParameter("mem_add1" 		)%><br />
	주소2 : 		 <%= request.getParameter("mem_add2" 		)%><br />
	집전화 : 		 <%= request.getParameter("mem_hometel" 	)%><br />
	회사전화 : 		 <%= request.getParameter("mem_comtel" 		)%><br />
	휴대폰번호 : 	 <%= request.getParameter("mem_hp" 			)%><br />
	이메일 : 		 <%= request.getParameter("mem_mail" 		)%><br />
	직업 : 			 <%= request.getParameter("mem_job"			)%><br />
	취미 : 			 <%= request.getParameter("mem_like" 		)%><br />
	기념일명  : 	 <%= request.getParameter("mem_memorial" 	)%><br />
	기념일날짜 : 	 <%= request.getParameter("mem_memorialdate")%><br />
	마일리지 : 		 <%= request.getParameter("mem_mileage" 	)%><br />
	삭제여부 : 		 <%= request.getParameter("mem_delete" 		)%><br />
	
	
<%
		/* String sql2 = "delete from member where mem_id = 'z001'"; 
		stmt.executeUpdate(sql2); */
 
		String mem_id			= request.getParameter("mem_id" 			)	;
		String mem_pass 		= request.getParameter("mem_pass" 		)      ;
		String mem_name 		= request.getParameter("mem_name" 		)      ;
		String mem_regno1 		= request.getParameter("mem_regno1" 		)  ;
		String mem_regno2 		= request.getParameter("mem_regno2" 		)  ;
		String mem_bir          = request.getParameter("mem_bir" 		)      ;
		String mem_zip          = request.getParameter("mem_zip" 		)      ;
		String mem_add1 		= request.getParameter("mem_add1" 		)      ;
		String mem_add2 		= request.getParameter("mem_add2" 		)      ;
		String mem_hometel      = request.getParameter("mem_hometel" 	)      ;
		String mem_comtel 		= request.getParameter("mem_comtel" 		)  ;
		String mem_hp 			= request.getParameter("mem_hp" 			)  ;
		String mem_mail 		= request.getParameter("mem_mail" 		)      ;
		String mem_job			= request.getParameter("mem_job"			)  ;
		String mem_like		    = request.getParameter("mem_like" 		)      ;
		String mem_memorial 	= request.getParameter("mem_memorial" 	)      ;
		String mem_memorialdate = request.getParameter("mem_memorialdate")     ;
		String mem_mileage	    = request.getParameter("mem_mileage" 	)      ;
		String mem_delete 		= request.getParameter("mem_delete" 		)  ;
	
		String sql = "";
		sql += " Insert Into member ( ";
		sql += " mem_id,mem_pass,mem_name,mem_regno1,mem_regno2,mem_bir,mem_zip,mem_add1,mem_add2,mem_hometel, ";
        sql += " mem_comtel,mem_hp,mem_mail,mem_job,mem_like,mem_memorial,mem_memorialday,mem_mileage,mem_delete ";
		sql += " ) values ( ";
		sql += " '" + mem_id + "' ,'" + mem_pass + "','" + mem_name + "','" + mem_regno1 + "','" + mem_regno2 + "','" + mem_bir + "','" + mem_zip + "','" + mem_add1 + "','" ; 
		sql += " " + mem_add2 + "','" + mem_hometel + "','" + mem_comtel + "','" + mem_hp + "','" + mem_mail + "','" + mem_job + "','" + mem_like + "','";
		sql += " " + mem_memorial + "','" + mem_memorialdate + "','" + mem_mileage + "','" + mem_delete + "' ";
		sql += " ) ";
		
		out.print(sql); 
		System.out.println("SQL ==> " + sql);
		if(stmt.executeUpdate(sql) < 1) {
		%>
			<script type="text/javascript">
			alert("실패 하였습니다.");
			</script>
		<%
		} else {
		%>
			<script type="text/javascript">
			alert("등록 성공하였습니다.");
			</script>
		<%
		}
		
		
		String sql1  = "select * from member where mem_id = 'z001'";
		System.out.println("SQL ==> " + sql1);
		rs = stmt.executeQuery(sql1);
		
		while(rs.next()) {
			out.print(rs.getString	("mem_id" 			));
			out.print(rs.getString	("mem_pass" 		));
			out.print(rs.getString	("mem_name" 		));
			out.print(rs.getString	("mem_regno1" 		));
			out.print(rs.getString	("mem_regno2" 		));
			out.print(rs.getDate	("mem_bir" 			));
			out.print(rs.getString	("mem_zip" 			));
			out.print(rs.getString	("mem_add1" 		));
			out.print(rs.getString	("mem_add2" 		));
			out.print(rs.getString	("mem_hometel" 		));
			out.print(rs.getString	("mem_comtel" 		));
			out.print(rs.getString	("mem_hp" 			));
			out.print(rs.getString	("mem_mail" 		));
			out.print(rs.getString	("mem_job"			));
			out.print(rs.getString	("mem_like" 		));
			out.print(rs.getString	("mem_memorial" 	));
			out.print(rs.getDate	("mem_memorialdate"	));
			out.print(rs.getInt		("mem_mileage" 		));
			out.print(rs.getString	("mem_delete" 		));
		}
		
	}catch (Exception e) {
		System.out.println ("오류발생" + e);
	} finally {
		try {
		if( rs != null ){
			rs.close();
		}
		if( stmt != null ){
			stmt.close();
		}
		if(conn != null) {
			conn.close();
		}
		}catch (Exception e) {
			
		}
	}
	%>
</body>
</html>