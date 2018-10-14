<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% request.setCharacterEncoding("EUC-KR"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>mem_insertForm</title>
<link rel="stylesheet" href="./tableStyle.css" />
<script type="text/javascript">
	function goInsert() {
   		var f = document.f;
   		
   		/*다른방식*/
   		// var mem_id = document.getElementById("mem_id").value;
   		var mem_id = f.mem_id.value;
   		if(mem_id == "" || f.mem_id.length == 0){
   			alert("아이디를 입력해주세요");
   			f.mem_id.focus();
   			return;
   		}
   		
   		var mem_pass = f.mem_pass.value;
   		if(mem_pass == "" || f.mem_pass.length == 0){
   			alert("패스워드를 입력해주세요");
   			f.mem_pass.focus();
   			return;
   		}
   		
   		var mem_name = f.mem_name.value;
   		if(mem_name == "" || f.mem_name.length == 0){
   			alert("이름을 입력해주세요");
   			f.mem_name.focus();
   			return;
   		}
   		
   		var mem_regno1 = f.mem_regno1.value;
   		if(mem_regno1 == "" || f.mem_regno1.length == 0){
   			alert("주소를 입력해주세요");
   			f.mem_regno1.focus();
   			return;
   		}
   		
   		var mem_regno2 = f.mem_regno2.value;
   		if(mem_regno2 == "" || f.mem_regno2.length == 0){
   			alert("주소를 입력해주세요");
   			f.mem_regno2.focus();
   			return;
   		}
   		
   		var mem_bir = f.mem_bir.value;
   		if(mem_bir == "" || f.mem_bir.length == 0){
   			alert("생년월일을 입력해주세요");
   			f.mem_bir.focus();
   			return;
   		}
   		
   		var mem_zip = f.mem_zip.value;
   		if(mem_zip == "" || f.mem_zip.length == 0){
   			alert("우편번호를 입력해주세요");
   			f.mem_zip.focus();
   			return;
   		}
   		
   		var mem_add1 = f.mem_add1.value;
   		if(mem_add1 == "" || f.mem_add1.length == 0){
   			alert("주소를 입력해주세요");
   			f.mem_add1.focus();
   			return;
   		}
   		
   		var mem_add2 = f.mem_add2.value;
   		if(mem_add2 == "" || f.mem_add2.length == 0){
   			alert("주소를 입력해주세요");
   			f.mem_add2.focus();
   			return;
   		}
   		
   		var mem_hometel = f.mem_hometel.value;
   		if(mem_hometel == "" || f.mem_hometel.length == 0){
   			alert("집전화번호를 입력해주세요");
   			f.mem_hometel.focus();
   			return;
   		}
   		
   		var mem_comtel = f.mem_comtel.value;
   		if(mem_comtel == "" || f.mem_comtel.length == 0){
   			alert("회사전화번호를 입력해주세요");
   			f.mem_comtel.focus();
   			return;
   		}
   		
   		var mem_hp = f.mem_hp.value;
   		if(mem_hp == "" || f.mem_hp.length == 0){
   			alert("휴대폰번호를 입력해주세요");
   			f.mem_hp.focus();
   			return;
   		}
   		
   		var mem_mail = f.mem_mail.value;
   		if(mem_mail == "" || f.mem_mail.length == 0){
   			alert("이메일을 입력해주세요");
   			f.mem_mail.focus();
   			return;
   		}
   		
   		var mem_job = f.mem_job.value;
   		if(mem_job == "" || f.mem_job.length == 0){
   			alert("직업을 입력해주세요");
   			f.mem_job.focus();
   			return;
   		}
   		
   		var mem_like = f.mem_like.value;
   		if(mem_like == "" || f.mem_like.length == 0){
   			alert("취미를 입력해주세요");
   			f.mem_like.focus();
   			return;
   		}
   		
   		var mem_memorial = f.mem_memorial.value;
   		if(mem_memorial == "" || f.mem_memorial.length == 0){
   			alert("기념일을 입력해주세요");
   			f.mem_memorial.focus();
   			return;
   		}
   		
   		var mem_memorialdate = f.mem_memorialdate.value;
   		if(mem_memorialdate == "" || f.mem_memorialdate.length == 0){
   			alert("기념일자를 입력해주세요");
   			f.mem_memorialdate.focus();
   			return;
   		}
   		
   		var mem_mileage = f.mem_mileage.value;
   		if(mem_mileage == "" || f.mem_mileage.length == 0){
   			alert("마일리지를 입력해주세요");
   			f.mem_mileage.focus();
   			return;
   		}
   		
   		var mem_delete = f.mem_delete.value;
   		if(mem_delete == "" || f.mem_delete.length == 0){
   			alert("삭제여부를 입력해주세요");
   			f.mem_delete.focus();
   			return;
   		}
   		f.action = "./mem_insert.jsp";
   		f.submit();
   	}
	
	function goList() {
		var gl = document.f;
		history.go(-1);		// 뒤로가기 
	}
	
	
	</script>
</head>
<body>
	<h3>회원 신규 가입 페이지</h3>
	<hr />
		
	<form name="f" method="post">
	<table class="table_buttons">
		
		
		
	      <!-- member 테이블에 있는 컬럼들을 확인해서 입력페이지를 만들어 주세요
	          날짜 타입은 그냥 text로 하면됩니다.
	
	          선택이 필요한 값들이 있으면 선택 태그를 이용하세요
	     -->
	    <tr>
			<td>아이디</td> 			<td class="td_left"><input type="text" 		name="mem_id" 			value="">	</td>
		</tr>
		<tr>
			<td>패스워드</td> 			<td class="td_left"><input type="password" 	name="mem_pass" 		value="">	</td>
		</tr>
		<tr>
		 	<td>이름</td> 				<td class="td_left"><input type="text" 		name="mem_name" 		value="">	</td>
	    </tr>
	    <tr>
	     	<td>주민번호 앞자리</td>	<td class="td_left"><input type="text" 		name="mem_regno1" 		value="">	</td>
	    </tr>
	   
	    <tr>
	     	<td>주민번호 뒷자리</td>	<td class="td_left"><input type="text" 		name="mem_regno2" 		value="">	</td>
	     </tr>	
	     
	     <tr>
	     	<td>생년월일</td>			<td class="td_left"><input type="date" 		name="mem_bir" 			value="">	</td>
	     </tr> 	
	     
	     <tr>
	     	<td>우편번호</td>			<td class="td_left"><input type="text" 		name="mem_zip" 			value="">	</td>	
		 </tr>
		 
		 <tr>
		 	<td>주소1</td>				<td class="td_left"><input type="text" 		name="mem_add1" 		value="">	</td>
		 </tr>	
		 
		 <tr>
		 	<td>주소2</td>				<td class="td_left"><input type="text" 		name="mem_add2" 		value="">	</td>
		 </tr>  	
		 
		 <tr>
		 	<td>집전화</td>				<td class="td_left"><input type="text" 		name="mem_hometel" 		value="">	</td>
		 </tr>  	
		 
		 <tr>
		 	<td>회사전화</td>			<td class="td_left"><input type="text" 		name="mem_comtel" 		value="">	</td>
		 </tr>  
		 
		 <tr>	
	     	<td>휴대폰번호</td> 		<td class="td_left"><input type="text" 		name="mem_hp" 			value="">	</td>
	     </tr>
	     <tr>  	
	     	<td>이메일</td> 			<td class="td_left"><input type="text" 		name="mem_mail" 		value="">	</td>	
	     </tr>
	     <tr>
	     	<td>직업</td>				<td class="td_left"><input type="text" 		name="mem_job"			value="">	</td>	
	     </tr>
	     <tr>
	     	<td>취미</td>				<td class="td_left"><input type="text"		name="mem_like" 		value="">	</td>	
	     </tr>
	     <tr>
	     	<td>기념일명</td>			<td class="td_left"><input type="text" 		name="mem_memorial" 	value="">	</td>	
	     </tr>
	     <tr>
	     	<td>기념일날짜</td>			<td class="td_left"><input type="date" 		name="mem_memorialdate" value="">	</td>	
	     </tr>
	     <tr>
	     	<td>마일리지</td>			<td class="td_left"><input type="number" 	name="mem_mileage" 		value="">	</td>	
	     </tr>
	     <tr>
	     	<td>삭제여부</td>			<td class="td_left"><input type="text" 		name="mem_delete" 		value="">	</td>	
	     </tr>
	     <!-- <input type="submit" 	name="submit" 		value="검색하기"> -->
   		
   	 </table>
   	 <table class="table_buttons" >
	   	 <tr>
		     <td><input class="buttons" type="button" name="button" value="회원가입" onclick="goInsert()" /></td>
		     <td><input class="buttons" type="reset" name="reset" value="취소" /></td>
		     <td><input class="buttons" type="button" value="입력취소"  onclick="goList()" /></td>
     	</tr>
	 </table>
    </form>
</body>
</html>