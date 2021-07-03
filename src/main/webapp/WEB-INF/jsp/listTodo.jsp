<%@include file="jspf/header.jspf" %>
<%@include file="jspf/navbar.jspf" %>
<div class="container">
	<h1>${name} Todo's</h1>
	<table class="table">
		<thead class="thead">
			<tr>
			<th>Description</th>
			<th>TargetDate</th>
			<th>Status</th>
			<th>Actions</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach var="todo" items="${listTodo}">
		   		 <tr>
		   		 	<td>${todo.description}</td>
		   		 		 <td>
		   		 			 <fmt:formatDate pattern = "dd-MM-yyyy" value = "${todo.targetDate}" />
		   		 		 </td>
		   		 		 <td>${todo.status}</td>
		   		 		 <td>
		   		 		 	<a type="button" class="btn btn-info" href="/updateTodo?id=${todo.id}">Update</a>
		   		 		 	<a type="button" class="btn btn-warning" href="/deleteTodo?id=${todo.id}">Delete</a>
		   		 		 </td>
		   		</tr>
		    </c:forEach>  
		</tbody>
	</table>
	<a type="button" class="btn btn-success" href="/addTodo">Add</a>
</div>
<%@include file="jspf/footer.jspf" %>