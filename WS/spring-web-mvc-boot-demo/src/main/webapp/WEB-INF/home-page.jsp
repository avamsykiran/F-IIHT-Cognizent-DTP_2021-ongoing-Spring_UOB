<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>A simple web app</title>
</head>
<body>
	<jsp:include page="/header" />
	<main style="padding: 15px">
		<h4>Credits</h4>
		<ol>
			<c:forEach var="member" items="${credits }">
				<li>${member }</li>
			</c:forEach>
		</ol>
	</main>
</body>
</html>