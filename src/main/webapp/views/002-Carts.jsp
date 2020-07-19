<%@page import="funix.edu.context.EcommerceDAO"%>
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
						<h3>Your cart</h3>
					</div>
					<hr>
				</div>
			</div>
			<c:if test="${ not empty carts}">
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
								<c:forEach var="product" varStatus="index" items="${carts }">
									<tr>
										<td><b>${product.productName }</b></td>
										<td>1</td>
										<td><p class="text-danger">
												<b>${product.producePrice }</b>
											</p></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
						<div class="actions d-flex justify-content-end mb-3">
							<button class="btn btn-link text-dark">
								Total: <b class="text-danger">${totalPriceOnCart }</b>
							</button>
							<a class="btn btn-info m-1" href="<%=request.getContextPath()%>/cart">Update cart</a> <a
								class="btn btn-primary m-1"
								href="<%=request.getContextPath()%>/checkout">Pay</a>
						</div>
					</div>
				</div>
			</c:if>
			<c:if test="${ empty carts}">
				<div class="row">
					<div class="col-12 text-center mb-4">
						<span>Your cart is empty!</span>
					</div>
				</div>
			</c:if>

		</div>
	</div>
	<jsp:include page="/views/commons/footer.jsp"></jsp:include>
</body>

</html>