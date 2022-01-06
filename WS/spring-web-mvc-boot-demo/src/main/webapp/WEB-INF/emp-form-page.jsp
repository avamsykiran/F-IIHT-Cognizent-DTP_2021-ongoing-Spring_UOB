<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>A simple web app</title>
</head>
<body>
	<jsp:include page="/header" />
	<main style="padding: 15px">

		<form:form method="POST" modelAttribute="emp">
			<table style="width: 40%; margin: auto; border: 1px solid #000000;">
				<tr>
					<td><strong>Employee Id</strong></td>
					<td><form:input type="number" path="empId" readonly="true" /> 
				</tr>
				<tr>
					<td><strong>Full Name</strong></td>
					<td><form:input type="text" path="fullName" /> <form:errors
							path="fullName" /></td>
				</tr>
				<tr>
					<td><strong>Join Date</strong></td>
					<td><form:input type="date" path="joinDate" /> <form:errors
							path="joinDate" /></td>
				</tr>
				<tr>
					<td><strong>Salary</strong></td>
					<td><form:input type="number" path="salary" /> <form:errors
							path="salary" /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right">
						<button>Save Employee</button>
					</td>
				</tr>
			</table>
		</form:form>

	</main>
</body>
</html>