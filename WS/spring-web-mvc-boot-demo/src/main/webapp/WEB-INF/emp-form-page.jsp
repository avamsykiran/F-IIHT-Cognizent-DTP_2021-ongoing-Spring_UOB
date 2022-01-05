<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>A simple web app</title>
</head>
<body>
	<jsp:include page="/header" />
	<main style="padding: 15px">

		<form method="POST">
			<table style="width: 40%; margin: auto; border: 1px solid #000000;">
				<tr>
					<td><strong>Full Name</strong></td>
					<td><input type="text" required name="fullName" /></td>
				</tr>
				<tr>
					<td><strong>Join Date</strong></td>
					<td><input type="date" requried name="joinDate" /></td>
				</tr>
				<tr>
					<td><strong>Salary</strong></td>
					<td><input type="number" name="salary" required /></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: right">
						<button>Add Employee</button>
					</td>
				</tr>
			</table>
		</form>

	</main>
</body>
</html>