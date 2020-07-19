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
	<jsp:include page="/views/commons/toast.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<div class="row">
				<div class="col-12 p-0 mt-1">
					<div class="jumbotron jumbotron-fluid">
						<div class="container">
							<h1 class="display-4">${brandName }</h1>
						</div>
					</div>
				</div>
			</div>
			<c:if test="${not empty products }">
				<!-- CONTENT -->
				<div class="row p-0 m-0">
					<c:forEach var="product" varStatus="status" items="${products }">
						<div class="col-3 p-0 m-0">
							<div class="card shadow m-1">
								<img class="card-img-top" src="${product.productImageSouce }"
									alt="${product.productName }" />
								<div class="card-body">
									<div class="title">
										<a
											href="<%=request.getContextPath()%>/produce?id=${product.productId }"><h4>${product.productName }</h4></a>
									</div>
									<div class="price">
										<h4 class="text-danger">${product.producePrice }đ</h4>
									</div>
									<p class="card-text">${product.productDes }</p>
									<div class="card-footer text-muted">
										<a
											href="<%=request.getContextPath()%>/checkout?id=${product.productId }"
											class="btn btn-primary m-1 text-white">Buy now</a>
										<button onclick="addToCart('${product.productId }')"
											class="btn btn-info m-1 text-white">Add to cart</button>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div class="row mt-2">
					<div class="col-12 text-center">
						<span>Showing ${currentPage } of ${totalPage } pages</span>
					</div>
				</div>
				<c:if test="${totalPage > 1}">
					<div class="row mt-2">
						<div class="col-12">
							<nav aria-label="...">
								<ul class="pagination pagination-lg justify-content-center">
									<c:forEach begin="1" end="${totalPage }" varStatus="loop">
										<li class="page-item"><a class="page-link"
											${currentPage == loop.index ? 'disable=' : 'href='}"<%=request.getContextPath()%>/shop?brandId=${brandIdSelected }
											&currentPage=${loop.index}&keyword=${keyword}">${loop.index}</a></li>
									</c:forEach>
								</ul>
							</nav>
						</div>
					</div>
				</c:if>
				<!-- CONTENT -->
			</c:if>
			<c:if test="${empty products }">
				<div class="row my-2">
					<div class="col-12 text-center">
						<span class="text-danger">No result has been matched!</span>
					</div>
				</div>
			</c:if>
		</div>
	</div>
	<jsp:include page="/views/commons/footer.jsp"></jsp:include>
</body>

</html>