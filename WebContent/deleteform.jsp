<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String no = request.getParameter("no");
	String password = request.getParameter("pwd");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function check(){
		if(document.check_form.ps.value != document.check_form.password.value){
			alert("비밀번호가 틀렸습니다");
			return false;
		}else{
			document.check_form.submit();
		}
	}
</script>
<title>방명록</title>
</head>
<body>
	<form name="check_form" method="post" action="delete.jsp" >
	<input type='hidden' name="no" value="<%=no%>">
	<input type='hidden' name="ps" value="<%=password%>">
	<table>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="password"></td>
			<td><input type="button" value="확인" onclick="check()"></td>
			<td><a href="/guestbook/index.jsp">메인으로 돌아가기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>