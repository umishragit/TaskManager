<%@include file="jspf/header.jspf" %>
<%@include file="jspf/navbar.jspf" %>
<div class="container">
	<h1>${name} Task's</h1>
	<table class="table">
		<thead class="thead">
			<tr>
			<th>${year}</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach var="month" items="${months}">
		   		 <tr>
		   		 	<td>
		   		 	 <a type="button" class="btn btn-info" href="/listTask?year=${year}&month=${month}">${month}</a>
		   		 	<td>
		   		</tr>
		    </c:forEach>  
		</tbody>
	</table>
</div>
<%@include file="jspf/footer.jspf" %>