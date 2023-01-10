<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Encoding -->
<meta charset="UTF-8">
<!-- CSS -->
<link rel="stylesheet" href="css/style.css">
</head>

<script type="text/javascript">
function check() {
	var id = document.getElementById("id").value;
	var pw = document.getElementById("pw").value;
	
	if (id == "" || pw == "") {
		alert("input text is NULL");
		return false;
	};
};
</script>

<body>
	
	<div>
		<form id="loginForm" name="loginForm" method="post" action="/login.dox" onsubmit="return check()">
			<div>${check }</div>
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" id="id" name="id" placeholder="Enter your ID"></td>
				</tr>
				
				<tr>
					<th>PW</th>
					<td><input type="password" id="pw" name="pw" placeholder="Enter your Password"></td>
				</tr>
			</table>
			<button type="submit">Login</button>
		</form>
	</div>

</body>
</html>
