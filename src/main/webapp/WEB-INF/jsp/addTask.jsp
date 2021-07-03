<%@include file="jspf/header.jspf" %>
<%@include file="jspf/navbar.jspf" %>
<div class="container">
	<h1>${name} Task's</h1>
	<form:form action="/addTask" method="post" modelAttribute="task">
		<div class="form-group">
			<form:hidden path="year"></form:hidden>
			<form:hidden path="month"></form:hidden>
			<form:hidden path="day"></form:hidden>
			<br><br>
			<form:label path="task_name">Task Name: </form:label>
			<form:input path="task_name" type="text" class="form-control" ></form:input>
			<br><br>
			<form:label path="comments" >comments: </form:label>
			<form:input path="comments" type="textbox" class="form-control"></form:input>
			<br><br>
			<form:button type="submit" class="btn btn-info">Add</form:button>
		</div>
	</form:form>
</div>
<%@include file="jspf/footer.jspf" %>