<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="/views/commons/header.jsp"></jsp:include>
<title>Clickshop.com.vn - Thế giới mua sắm sản phẩm công nghệ</title>
</head>

<body>
	<jsp:include page="/views/commons/mainMenu.jsp"></jsp:include>
	<jsp:include page="/views/commons/toast.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<div class="row bg-light">
				<div class="col-12 p-0 mt-1">
					<div id="carouselExampleControls" class="carousel slide"
						data-ride="carousel">
						<div class="carousel-inner">
							<div class="carousel-item active">
								<img class="d-block w-100"
									src="<%=request.getContextPath()%>/resources/images/banner2.png"
									alt="First slide">
							</div>
							<div class="carousel-item">
								<img class="d-block w-100"
									src="<%=request.getContextPath()%>/resources/images/banner2.png"
									alt="Second slide">
							</div>
							<div class="carousel-item">
								<img class="d-block w-100"
									src="<%=request.getContextPath()%>/resources/images/banner2.png"
									alt="Third slide">
							</div>
						</div>
						<a class="carousel-control-prev" href="#carouselExampleControls"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon" aria-hidden="true"></span> <span
							class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carouselExampleControls"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon" aria-hidden="true"></span> <span
							class="sr-only">Next</span>
						</a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12 p-0 mt-1">
					<div class="jumbotron jumbotron-fluid">
						<div class="container">
							<h1 class="display-4">BEST SELLER</h1>
							<p class="lead">This is a modified jumbotron that occupies
								the entire horizontal space of its parent.</p>
						</div>
					</div>
				</div>
			</div>
			<div class="row p-0 m-0">
				<c:if test="${not empty products }">
					<c:forEach var="product" varStatus="status" items="${products }">
						<div class="col-3 p-0 m-0">
							<div class="card shadow m-1">
								<div class="ribbon shadow"><span>HOT</span></div>
								<img class="card-img-top" src="${product.productImageSouce }"
									alt="${product.productName }" />
								<div class="card-body">
									<div class="title">
										<a href="<%=request.getContextPath()%>/produce?id=${product.productId }"><h4>${product.productName }</h4></a>
									</div>
									<div class="price">
										<h4 class="text-danger text-center">${product.producePrice }đ</h4>
									</div>
									 <p class="card-text">${product.productDes }</p>
									<div class="card-footer text-muted">
										<a href="<%=request.getContextPath()%>/checkout?id=${product.productId }"
											class="btn btn-primary m-1 text-white">Buy now</a>
										<button onclick="addToCart('${product.productId }')"
											class="btn btn-info m-1 text-white">Add to cart</button>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
			<div class="row">
				<div class="col-12 p-0 mt-1">
					<div class="jumbotron jumbotron-fluid">
						<div class="container">
							<h1 class="display-4">TOP SELLOFF</h1>
							<p class="lead">This is a modified jumbotron that occupies
								the entire horizontal space of its parent.</p>
						</div>
					</div>
				</div>
			</div>
			<div class="row p-0 m-0">
				<c:if test="${not empty products }">
					<c:forEach var="product" varStatus="status" items="${products }">
						<div class="col-3 p-0 m-0">
							<div class="card shadow m-1">
								<img class="card-img-top" src="${product.productImageSouce }"
									alt="${product.productName }" />
								<div class="card-body">
									<div class="title">
										<a href="<%=request.getContextPath()%>/produce?id=${product.productId }"><h4>${product.productName }</h4></a>
									</div>
									<div class="price">
										<h4 class="text-danger">${product.producePrice }đ</h4>
									</div>
									<p class="card-text">${product.productDes }</p>
									<div class="card-footer text-muted">
										<a href="<%=request.getContextPath()%>/checkout?id=${product.productId }"
											class="btn btn-primary m-1 text-white">Buy now</a>
										<button onclick="addToCart('${product.productId }')"
											class="btn btn-info m-1 text-white">Add to cart</button>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</div>
		</div>
	</div>
	<jsp:include page="/views/commons/footer.jsp"></jsp:include>
</body>

</html>