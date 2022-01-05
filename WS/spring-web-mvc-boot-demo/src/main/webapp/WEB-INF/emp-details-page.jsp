<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>A simple web app</title>
</head>
<body>
	<jsp:include page="/header" />
	<main style="padding: 15px">
	
		<form>
			<label>Employee Id <input type="number" required name="eid" /></label>
			<button>Search</button>
		</form>
	
		<h4>Employee Details</h4>
		<c:choose>
			<c:when test="${emp==null }">
				<p>
					<strong>No Such Employee Record Found</strong>
				</p>
			</c:when>
			<c:otherwise>
				<table style="width: 40%; margin: auto; border: 1px solid #000000;">
					<tr>
						<td><strong>Employee#</strong></td>
						<td>${emp.empId }</td>
					</tr>
					<tr>
						<td><strong>Full Name</strong></td>
						<td>${emp.fullName }</td>
					</tr>
					<tr>
						<td><strong>Join Date</strong></td>
						<td>${emp.joinDate }</td>
					</tr>
					<tr>
						<td><strong>Salary</strong></td>
						<td>${emp.salary }</td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
	</main>
</body>
</html>