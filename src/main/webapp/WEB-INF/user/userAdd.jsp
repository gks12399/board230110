<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- Encoding -->
<meta charset="UTF-8">
<!-- CSS -->
<link rel="stylesheet" href="css/style.css">
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

</head>

<script type="text/javascript">
var idFlag = false;
var id = document.getElementById("id").value;
var pw = document.getElementById("pw").value;
var reg = /^[a-zA-Z0-9]{4,10}$/;

function checkId(){
	
	if(!reg.test(id)){
   		alert("Not use ID");
		idFlag = false;
		return false;
	}
	else{
		$.ajax({
		   	type : 'post',
		   	url : '/findId.dox',
		   	data : { id : id } , 
			   	
		   	success : function(cnt) {
		   		if (cnt == 0) {
		   			alert("Success");
		   			idFlag = true;
		   			return false;
		   		} 
		   		else {
		   			alert("Already Id");
		   			idFlag = false;
		           	return false;
		       	}
		   	}, 
		   	error : function() {
		   		alert("AjaxError");
		   		idFlag = false;
		   		return false;
		   	}
		});
	}
};

function check(){
	
	if (id == "" || pw == "") {
		alert("input text is NULL");
		return false;
	}
	else {
		if (idFlag == false) {
			alert("Required ID check");
			return false;
		}
		else {
			
			if(!reg.test(pw)){
				alert("Not use Password");
				return false;
			}
			else {
				document.userAddForm.submit();
			}
		}
	}
};
</script>

<body>
	
	<div>
		<form id="userAddForm" name="userAddForm" method="post" action="/userAdd.dox" onsubmit="return check()">
			<table>
				<tr>
					<th>ID</th>
					<td>
						<input type="text" id="id" name="id" required="required" placeholder="Enter your ID">
						<button onclick="checkId()">IDcheck</button>
					</td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="text" id="pw" name="pw" required="required" placeholder="Enter your Password"></td>
				</tr>
			</table>
			<button type="submit">Submit</button>
		</form>
	</div>

</body>
</html>
