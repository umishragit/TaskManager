<%@include file="jspf/header.jspf" %>
<%@include file="jspf/navbar.jspf" %>
<div class="container">
	<h1>${name} Task's</h1>
	<table class="table">
		<thead class="thead">
			<tr>
			<th>Name</th>
			<th>Comments</th>
			<th>Create Date</th>
			<th>Actions</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach var="task" items="${tasks}">
		   		 <tr>
		   		 	<td>${task.task_name}</td>
		   		 	<td>${task.comments}</td>
		   		 	<td>${task.day}</td>
		   		 		
		   		 		 <td>
		   		 		 	<a type="button" class="btn btn-info" href="/updateTodo?id=${task.taskid}">Update</a>
		   		 		 	<a type="button" class="btn btn-warning" href="/deleteTask?id=${task.taskid}">Delete</a>
		   		 		 </td>
		   		</tr>
		    </c:forEach>  
		</tbody>
	</table>
	<a type="button" class="btn btn-success" href="/addTask">Add</a>
</div>
<%@include file="jspf/footer.jspf" %>