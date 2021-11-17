<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">


	function CheckEmail(str){ <!--email check 정규식-->
			var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
				if(!reg_email.test(str)){
   					return false;
				}else {
  				 return true;
				}
				}
	

	function idCheck(){ //ID중복체크
			var id= $("#id").val();
			$("#id").focus();
			
		$.ajax({
			url : "ajaxIdCheck.do",
			type : "post",
			data : {chkid : id},
			dataType : "text",
			success : function(data){
				if(data == '0'){
					alert(id + "사용가능한 아이디입니다.");
					$("#idchk").val("Yes");
					$("#password").focus();
				}else{
					alert(id + "는 이미 사용중인 아이디입니다.");
					$("#id").val="";
					$("#id").focus();
				}
			},
			error : function(){
				
			}
			
		});
		
	}
	
	function formCheck(){
		if($("#idchk").val() != 'Yes'){
			alert("아이디 중복체크를 해주세요.");
			return false;
		}
		
		if($("#password").val() != $("#passwordChk").val()){
			alert("패스워드가 일치하지 않습니다.");
			$("#password").val("");
			$("#passwordChk").val("");
		$("$password").focus();
		return false;
		}
		$("#frm").submit();
			
	}
	
</script>
</head>
<body>
	<jsp:include page="../home/header.jsp"></jsp:include>
	<div align="center">
		 <form id="frm" action="memberJoin.do" method="post">
			<h1>JOIN US !</h1>
			<table border="1">
				<tr>
					<th>* ID</th>
					<td><input type="email" id="id" name="id" required="required"
						placeholder="email 입력하세요" size="15"> &nbsp;&nbsp;
						<button type="button" id="idchk" onclick="idCheck()" value="No">중복체크</button></td>
				</tr>


				<tr>
					<th>* PASSWORD</th>
					<td><input type="password" id="password" name="password"
						required="required" size="30"></td>
				</tr>

				<tr>
					<th>* PASSWORD CHECK</th>
					<td><input type="password" id="passwordChk" name="passwordChk"
						required="required" size="30"></td>
				</tr>

				<tr>
					<th>NAME</th>
					<td><input type="text" id="name" name="name" size="30"></td>
				</tr>

				<tr>
					<th>TEL</th>
					<td><input type="text" id="tel" name="tel" size="30"></td>
				</tr>

				<tr>
					<th>ADDRESS</th>
					<td><input type="text" id="address" name="address" size="60"></td>
				</tr>
			</table>
			<br> <input type=button onclick="formCheck()"  value="JOIN">&nbsp;&nbsp;&nbsp;
			<input type="reset" onclick="" value="BACK">
		</form>
	</div>
</body>
</html>