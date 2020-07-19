<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="utf-8">

<head>
<jsp:include page="/views/commons/header.jsp"></jsp:include>
<title>HOME</title>
</head>

<body>
	<jsp:include page="/views/commons/mainMenu.jsp"></jsp:include>
	<jsp:include page="/views/commons/toast.jsp"></jsp:include>
	<div id="main">
		<div class="container">
			<div class="row mt-3">
				<div class="col-12">
					<div class="produce-titile">
						<h3>${product.productName }</h3>
					</div>
					<hr>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<img class="card-img-top"
						src="${product.productImageSouce }"
						alt="${product.productName }" />
				</div>
				<div class="col-6">
					<div class="card m-1">
						<div class="card-body">
							<div class="price">
								<h4 class="text-danger">${product.producePrice }đ</h4>
							</div>
							<div class="promotion">
								<ul class="m-0">
									<li>Tặng suất mua Đồng hồ thời trang giảm đến 40%</li>
									<li>Trả góp 0%, trả trước chỉ 469,000đ</li>
								</ul>
							</div>
							<div class="description mt-3">
								<h4>Description</h4>
							</div>
							<hr>
							<p class="card-text">${product.productDes }</p>
							<div class="card-footer text-muted">
								<a href="<%=request.getContextPath() %>/checkout?id=${product.productId }" class="btn btn-primary m-1 text-white">Buy now</a>
								<button  onclick="addToCart('${product.productId }')" class="btn btn-info m-1 text-white">Add to cart</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12 text-center">
					<div class="alert alert-primary" role="alert">
						<div class="col-12 text-center">
							<b>777</b> người đã mua sản phẩm này!
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/views/commons/footer.jsp"></jsp:include>
</body>

</html>