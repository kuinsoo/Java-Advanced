<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <% request.setCharacterEncoding("EUC-KR"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>mem_insertForm</title>
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
      <!-- member 테이블에 있는 컬럼들을 확인해서 입력페이지를 만들어 주세요
          날짜 타입은 그냥 text로 하면됩니다.

          선택이 필요한 값들이 있으면 선택 태그를 이용하세요
     -->
	 아이디: 			<input type="text" 		name="mem_id" 			value="z001">  				<br/>
	 패스워드: 			<input type="password" 	name="mem_pass" 		value="aa001pwd">  			<br/>
	 이름: 				<input type="text" 		name="mem_name" 		value="홍길동">  			<br/>
     주민번호 앞자리: 	<input type="text" 		name="mem_regno1" 		value="123456">  			<br/>
     주민번호 뒷자리: 	<input type="text" 		name="mem_regno2" 		value="123456">  			<br/>
     생년월일 : 		<input type="date" 		name="mem_bir" 			value="1986-07-28">  		<br/>
     우편번호 : 		<input type="text" 		name="mem_zip" 			value="55555">  			<br/>
	 주소1 : 			<input type="text" 		name="mem_add1" 		value="대전광역시 중구">  	<br/>
	 주소2 : 			<input type="text" 		name="mem_add2" 		value="정림동 금성백조">  	<br/>
	 집전화 : 			<input type="text" 		name="mem_hometel" 		value="010-9947-0728">  	<br/>
	 회사전화 : 		<input type="text" 		name="mem_comtel" 		value="010-9947-0728">  	<br/>
     휴대폰번호 : 		<input type="text" 		name="mem_hp" 			value="010-9947-0728">  	<br/>
     이메일 : 			<input type="text" 		name="mem_mail" 		value="kkuinsoo@gmail.com"> <br/>
     직업 : 			<input type="text" 		name="mem_job"			value="TheDeveloper">		<br/>
     취미 : 			<input type="text"		name="mem_like" 		value="코딩">				<br/>
     기념일명  : 		<input type="text" 		name="mem_memorial" 	value="기념일">  			<br/>
     기념일날짜 : 		<input type="date" 		name="mem_memorialdate" value="2013-09-15">			<br/>
     마일리지 : 		<input type="number" 	name="mem_mileage" 		value="50000">				<br/>
     삭제여부 : 		<input type="text" 		name="mem_delete" 		value="N"> 					<br/>
     <!-- <input type="submit" 	name="submit" 		value="검색하기"> -->
     <input type="button" name="button" value="회원가입" onclick="goInsert()" />
     <input type="reset" name="reset" value="취소" />
     <input type="button" value="입력취소"  onclick="goList()" />
    </form>
</body>
</html>