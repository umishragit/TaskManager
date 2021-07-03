<%@include file="jspf/header.jspf" %>
<%@include file="jspf/navbar.jspf" %>
<div class="container">
	<h1>${name} Todo's</h1>
	<form:form action="/updateTodo" method="post" modelAttribute="todo">
		<div class="form-group">
			<form:hidden path="id"></form:hidden>
			<br><br>
			<form:label path="description">Description: </form:label>
			<form:input path="description" type="text" class="form-control"></form:input>
			<br><br>
			<form:label path="targetDate" >TargetDate: </form:label>
			<form:input path="targetDate" type="date" class="form-control"></form:input>
			<br><br>
			<form:label path="status">Status: </form:label>
			<form:input path="status" type="text" class="form-control"></form:input>
			<br><br>
			<form:button type="submit" class="btn btn-info">Update</form:button>
		</div>
	</form:form>
</div>
<%@include file="jspf/footer.jspf" %>