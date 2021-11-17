<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
<script src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function authorEdit(str){
		var id=str;
		//ajax로 처리하자...
	}
</script>
</head>
<body>
<jsp:include page="../home/header.jsp"/>
	<div align="center">
		<div><h1>멤 버 목 록</h1></div>
		<div>
			<table border="1">
				<tr>
					<th width="200"> 아이디</th>
					<th width="150"> 이 름</th>
					<th width="200"> 연락처</th>
					<th width="400"> 주 소</th>
					<th width="100"> 권 한</th>
					<th width="100"> 권 한 수 정</th>
					
				</tr>
				<c:forEach items="${members }" var="member">
												<!-- ㄴ한 행을 member라고 읽겠다 -->
					<tr>
						<td align="center">${member.id }</td>
						<td align="center">${member.name }</td>
						<td align="center">${member.tel }</td>
						<td align="center">${member.address }</td>
						<td align="center">
							<select id="author" name="author">
							<c:if test="${member.author eq 'ADMIN' }">
									<option value="ADMIN" selected="selected">ADMIN</option>
									<option value="USER">USER</option>
							</c:if>
							
								<c:if test="${member.author eq 'USER' }">
									<option value="ADMIN">ADMIN</option>
									<option value="USER" selected="selected">USER</option>
									
							</c:if>
								
							</select> 	
							</td>
						<td align="center">
							<button type="button" onclick="authorEdit('${member.id }')">변 경</button> 
						</td>
					</tr>
				</c:forEach>
				
			</table><br>
				<div>
				<button type="button" onclick="location.href='home.do'">홈으로</button>
				</div>
				 
		</div>
		<%-- <c:forEach items="${members }" var="member">
			<!-- 			ㄴ한 행을 member.id/member.name이런식으로 읽게됨. 
			id,password,name은 VO객체 있는 변수명과 동일해야함. -->
			<!-- 이 안의 부분의 반복하는 것 -->
			${member.id } : ${member.password } : ${member.name }<br>
			
		</c:forEach> --%>
	</div>
</body>
</html>