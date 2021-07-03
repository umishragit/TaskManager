<%@include file="jspf/header.jspf" %>
<%@include file="jspf/navbar.jspf" %>

<div class="container cen">
	<h1>Welcome to Security Page</h1>
	
	<form method="POST" action="/login" class="myForm">
		User Name : <input type="text" name="username"/><br><br>
		Password  : <input type="password" name="password"/><br><br>
		<input type="submit" name="submit"/>
	</form>
</div>

<%@include file="jspf/footer.jspf" %>