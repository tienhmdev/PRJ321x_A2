<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
	<jsp:include page="/views/commons/header.jsp"></jsp:include>
	<title>Thank for your order!</title>
</head>
<body>
<jsp:include page="/views/commons/mainMenu.jsp"></jsp:include>
		<div class="container text-center my-4" style="height: 100vh !important;">
					<div class="text-success display-2"><i class="fa fa-check main-content__checkmark" id="checkmark"></i></div>
					<div class="my-3"><h1 class="site-header__title" data-lead-id="site-header-title">Thank you!</h1></div>
					<div class="alert alert-success">
  <strong>Success!</strong> We will contact you to confirm your order.
</div>
					<a href="<%=request.getContextPath()%>/redirecting" class="btn btn-lg btn-success text-white my-3">Buy More</a>
		</div>
		<jsp:include page="/views/commons/footer.jsp"></jsp:include>
	</body>
</html>