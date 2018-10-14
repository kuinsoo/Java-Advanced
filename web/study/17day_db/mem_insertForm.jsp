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
   		
   		/*�ٸ����*/
   		// var mem_id = document.getElementById("mem_id").value;
   		var mem_id = f.mem_id.value;
   		if(mem_id == "" || f.mem_id.length == 0){
   			alert("���̵� �Է����ּ���");
   			f.mem_id.focus();
   			return;
   		}
   		
   		var mem_pass = f.mem_pass.value;
   		if(mem_pass == "" || f.mem_pass.length == 0){
   			alert("�н����带 �Է����ּ���");
   			f.mem_pass.focus();
   			return;
   		}
   		
   		var mem_name = f.mem_name.value;
   		if(mem_name == "" || f.mem_name.length == 0){
   			alert("�̸��� �Է����ּ���");
   			f.mem_name.focus();
   			return;
   		}
   		
   		var mem_regno1 = f.mem_regno1.value;
   		if(mem_regno1 == "" || f.mem_regno1.length == 0){
   			alert("�ּҸ� �Է����ּ���");
   			f.mem_regno1.focus();
   			return;
   		}
   		
   		var mem_regno2 = f.mem_regno2.value;
   		if(mem_regno2 == "" || f.mem_regno2.length == 0){
   			alert("�ּҸ� �Է����ּ���");
   			f.mem_regno2.focus();
   			return;
   		}
   		
   		var mem_bir = f.mem_bir.value;
   		if(mem_bir == "" || f.mem_bir.length == 0){
   			alert("��������� �Է����ּ���");
   			f.mem_bir.focus();
   			return;
   		}
   		
   		var mem_zip = f.mem_zip.value;
   		if(mem_zip == "" || f.mem_zip.length == 0){
   			alert("�����ȣ�� �Է����ּ���");
   			f.mem_zip.focus();
   			return;
   		}
   		
   		var mem_add1 = f.mem_add1.value;
   		if(mem_add1 == "" || f.mem_add1.length == 0){
   			alert("�ּҸ� �Է����ּ���");
   			f.mem_add1.focus();
   			return;
   		}
   		
   		var mem_add2 = f.mem_add2.value;
   		if(mem_add2 == "" || f.mem_add2.length == 0){
   			alert("�ּҸ� �Է����ּ���");
   			f.mem_add2.focus();
   			return;
   		}
   		
   		var mem_hometel = f.mem_hometel.value;
   		if(mem_hometel == "" || f.mem_hometel.length == 0){
   			alert("����ȭ��ȣ�� �Է����ּ���");
   			f.mem_hometel.focus();
   			return;
   		}
   		
   		var mem_comtel = f.mem_comtel.value;
   		if(mem_comtel == "" || f.mem_comtel.length == 0){
   			alert("ȸ����ȭ��ȣ�� �Է����ּ���");
   			f.mem_comtel.focus();
   			return;
   		}
   		
   		var mem_hp = f.mem_hp.value;
   		if(mem_hp == "" || f.mem_hp.length == 0){
   			alert("�޴�����ȣ�� �Է����ּ���");
   			f.mem_hp.focus();
   			return;
   		}
   		
   		var mem_mail = f.mem_mail.value;
   		if(mem_mail == "" || f.mem_mail.length == 0){
   			alert("�̸����� �Է����ּ���");
   			f.mem_mail.focus();
   			return;
   		}
   		
   		var mem_job = f.mem_job.value;
   		if(mem_job == "" || f.mem_job.length == 0){
   			alert("������ �Է����ּ���");
   			f.mem_job.focus();
   			return;
   		}
   		
   		var mem_like = f.mem_like.value;
   		if(mem_like == "" || f.mem_like.length == 0){
   			alert("��̸� �Է����ּ���");
   			f.mem_like.focus();
   			return;
   		}
   		
   		var mem_memorial = f.mem_memorial.value;
   		if(mem_memorial == "" || f.mem_memorial.length == 0){
   			alert("������� �Է����ּ���");
   			f.mem_memorial.focus();
   			return;
   		}
   		
   		var mem_memorialdate = f.mem_memorialdate.value;
   		if(mem_memorialdate == "" || f.mem_memorialdate.length == 0){
   			alert("������ڸ� �Է����ּ���");
   			f.mem_memorialdate.focus();
   			return;
   		}
   		
   		var mem_mileage = f.mem_mileage.value;
   		if(mem_mileage == "" || f.mem_mileage.length == 0){
   			alert("���ϸ����� �Է����ּ���");
   			f.mem_mileage.focus();
   			return;
   		}
   		
   		var mem_delete = f.mem_delete.value;
   		if(mem_delete == "" || f.mem_delete.length == 0){
   			alert("�������θ� �Է����ּ���");
   			f.mem_delete.focus();
   			return;
   		}
   		f.action = "./mem_insert.jsp";
   		f.submit();
   	}
	
	function goList() {
		var gl = document.f;
		history.go(-1);		// �ڷΰ��� 
	}
	
	
	</script>
</head>
<body>
	<h3>ȸ�� �ű� ���� ������</h3>
	<hr />
		
	<form name="f" method="post">
	<table class="table_buttons">
		
		
		
	      <!-- member ���̺� �ִ� �÷����� Ȯ���ؼ� �Է��������� ����� �ּ���
	          ��¥ Ÿ���� �׳� text�� �ϸ�˴ϴ�.
	
	          ������ �ʿ��� ������ ������ ���� �±׸� �̿��ϼ���
	     -->
	    <tr>
			<td>���̵�</td> 			<td class="td_left"><input type="text" 		name="mem_id" 			value="">	</td>
		</tr>
		<tr>
			<td>�н�����</td> 			<td class="td_left"><input type="password" 	name="mem_pass" 		value="">	</td>
		</tr>
		<tr>
		 	<td>�̸�</td> 				<td class="td_left"><input type="text" 		name="mem_name" 		value="">	</td>
	    </tr>
	    <tr>
	     	<td>�ֹι�ȣ ���ڸ�</td>	<td class="td_left"><input type="text" 		name="mem_regno1" 		value="">	</td>
	    </tr>
	   
	    <tr>
	     	<td>�ֹι�ȣ ���ڸ�</td>	<td class="td_left"><input type="text" 		name="mem_regno2" 		value="">	</td>
	     </tr>	
	     
	     <tr>
	     	<td>�������</td>			<td class="td_left"><input type="date" 		name="mem_bir" 			value="">	</td>
	     </tr> 	
	     
	     <tr>
	     	<td>�����ȣ</td>			<td class="td_left"><input type="text" 		name="mem_zip" 			value="">	</td>	
		 </tr>
		 
		 <tr>
		 	<td>�ּ�1</td>				<td class="td_left"><input type="text" 		name="mem_add1" 		value="">	</td>
		 </tr>	
		 
		 <tr>
		 	<td>�ּ�2</td>				<td class="td_left"><input type="text" 		name="mem_add2" 		value="">	</td>
		 </tr>  	
		 
		 <tr>
		 	<td>����ȭ</td>				<td class="td_left"><input type="text" 		name="mem_hometel" 		value="">	</td>
		 </tr>  	
		 
		 <tr>
		 	<td>ȸ����ȭ</td>			<td class="td_left"><input type="text" 		name="mem_comtel" 		value="">	</td>
		 </tr>  
		 
		 <tr>	
	     	<td>�޴�����ȣ</td> 		<td class="td_left"><input type="text" 		name="mem_hp" 			value="">	</td>
	     </tr>
	     <tr>  	
	     	<td>�̸���</td> 			<td class="td_left"><input type="text" 		name="mem_mail" 		value="">	</td>	
	     </tr>
	     <tr>
	     	<td>����</td>				<td class="td_left"><input type="text" 		name="mem_job"			value="">	</td>	
	     </tr>
	     <tr>
	     	<td>���</td>				<td class="td_left"><input type="text"		name="mem_like" 		value="">	</td>	
	     </tr>
	     <tr>
	     	<td>����ϸ�</td>			<td class="td_left"><input type="text" 		name="mem_memorial" 	value="">	</td>	
	     </tr>
	     <tr>
	     	<td>����ϳ�¥</td>			<td class="td_left"><input type="date" 		name="mem_memorialdate" value="">	</td>	
	     </tr>
	     <tr>
	     	<td>���ϸ���</td>			<td class="td_left"><input type="number" 	name="mem_mileage" 		value="">	</td>	
	     </tr>
	     <tr>
	     	<td>��������</td>			<td class="td_left"><input type="text" 		name="mem_delete" 		value="">	</td>	
	     </tr>
	     <!-- <input type="submit" 	name="submit" 		value="�˻��ϱ�"> -->
   		
   	 </table>
   	 <table class="table_buttons" >
	   	 <tr>
		     <td><input class="buttons" type="button" name="button" value="ȸ������" onclick="goInsert()" /></td>
		     <td><input class="buttons" type="reset" name="reset" value="���" /></td>
		     <td><input class="buttons" type="button" value="�Է����"  onclick="goList()" /></td>
     	</tr>
	 </table>
    </form>
</body>
</html>