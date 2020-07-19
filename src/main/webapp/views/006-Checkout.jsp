<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="/views/commons/header.jsp"></jsp:include>
<title>HOME</title>
</head>

<body>
	<jsp:include page="/views/commons/mainMenu.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<div class="row mt-3">
				<div class="col-12">
					<div class="carts-title">
						<h3>Check out</h3>
					</div>
					<hr>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th>Produce name</th>
								<th>Amount</th>
								<th>Price</th>
							</tr>
						</thead>
						<tbody>
						<c:if test="${checkoutType == 0 }">
							<c:forEach var="product" varStatus="index" items="${carts }">
									<tr>
										<td><b>${product.productName }</b></td>
										<td>1</td>
										<td><p class="text-danger">
												<b>${product.producePrice }</b>
											</p></td>
									</tr>
								</c:forEach>
						</c:if>
						<c:if test="${checkoutType == 1 }">
							<tr>
								<td><b>${product.productName }</b></td>
								<td>1</td>
								<td><p class="text-danger">
										<b>${product.producePrice }</b>
									</p></td>
							</tr>
						</c:if>
						</tbody>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<div class="actions d-flex justify-content-end mb-3">
						<button class="btn btn-link text-dark">
							Total: <b class="text-danger">${checkoutType == 0 ? totalPriceOnCart : product.producePrice  }đ</b>
						</button>
					</div>
				</div>
			</div>
			<div class="row my-2">
				<div class="col-12">
					<div class="alert alert-primary text-center" role="alert">
						Pay at home when delivery</div>
				</div>
			</div>
			<div class="row mb-3">
				<div class="col-12">
					<form action="<%=request.getContextPath()%>/order">
					<div class="form-group">
							<label for="exampleInputEmail1">Your name (*)</label> <input
								type="text" name="name" class="form-control" id="exampleInputEmail1"
								placeholder="Full Name" required="required">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Email (*)</label> <input
								type="email" name="email" class="form-control" id="exampleInputEmail1"
								placeholder="Email address" required="required">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Address (*)</label> <input
								type="text" name="address" class="form-control" id="exampleInputEmail1"
								placeholder="Your address" required="required">
						</div>
						<button type="submit" class="btn btn-success">Order</button>
						<button type="reset" class="btn btn-info">Reset</button>
						<a href="<%=request.getContextPath()%>/cart"
							class="btn btn-danger">Back to cart</a>
					</form>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/views/commons/footer.jsp"></jsp:include>
</body>

</html>