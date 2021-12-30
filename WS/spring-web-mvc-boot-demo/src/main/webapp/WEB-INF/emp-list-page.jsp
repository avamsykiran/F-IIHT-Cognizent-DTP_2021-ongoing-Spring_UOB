<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>A simple web app</title>
</head>
<body>
	<jsp:include page="/header" />
	<main style="padding: 15px">
		<h4>Employee List</h4>
		<c:choose>
			<c:when test="${emps==null || emps.isEmpty() }">
				<p><strong>No Employee Records Found</strong></p>
			</c:when>
			<c:otherwise>
				<table style="width:100%;border:1px solid #000000;">
					<thead>
						<tr>
							<th>EmpId</th><th>Name</th><th>Join Date</th><th>Salary</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="e" items="${emps }">
							<tr>
								<td>${e.empId }</td>
								<td>${e.fullName }</td>
								<td>${e.joinDate }</td>
								<td>${e.salary }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:otherwise>
		</c:choose>
	</main>
</body>
</html>