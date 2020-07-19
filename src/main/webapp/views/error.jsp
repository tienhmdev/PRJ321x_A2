<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<jsp:include page="/views/commons/header.jsp"></jsp:include>
<title>Error!</title>
</head>
<body>
	<jsp:include page="/views/commons/mainMenu.jsp"></jsp:include>
	<jsp:include page="/views/commons/toast.jsp"></jsp:include>
	<div class="container-fluid text-center mb-4">
		<h1 class="mt-4 text-danger">
			<b>OPPS !!!</b>
		</h1>
		<p>
			<b class="lead">Looks like the page you were looking for is no
				longer here.</b>
		</p>
		<a href="<%=request.getContextPath()%>/redirecting"
			class="btn btn-info">Return</a>
	</div>
<jsp:include page="/views/commons/footer.jsp"></jsp:include>
</body>
</html>