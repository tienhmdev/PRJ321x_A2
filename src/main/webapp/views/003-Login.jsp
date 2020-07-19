<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="/views/commons/header.jsp"></jsp:include>
<title>Login to cms</title>
</head>

<body>
	<div class="container-fluid">
		<div class="screen">
			<div class="box">
				<div class="card shadow">
					<div class="card-header lead text-center">Clickshop.com.vn</div>
					<div class="card-body">
						<div class="info text-center">
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
								Fugit iusto, nihil repudiandae quae repellat at beatae,
								consequuntur velit eligendi nisi aperiam corporis dolores in,
								reiciendis tempora laborum architecto? Inventore, hic!</p>
							<hr>
						</div>
						<form method="post" action="<%=request.getContextPath() %>/loginAuthentication">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" name="email" class="form-control"
									id="exampleInputEmail1" placeholder="Enter email" required>
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password (Must be
									enter numbers and alphabet)</label> <input type="password"
									name="password" minlength="6" class="form-control"
									id="exampleInputPassword1" placeholder="Password" required>
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
							<a href="<%=request.getContextPath() %>/home" class="btn btn-danger text-white">Back to home</a>
							<div class="alert text-danger"><p>${not empty errorMessage ? errorMessage : ''}</p></div>
							<%  request.getSession().setAttribute("errorMessage", ""); %>
						</form>
					</div>
					<div class="card-footer text-muted lead text-center">CMS V1 @
						FUNiX</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/views/commons/footer.jsp"></jsp:include>
</body>

</html>