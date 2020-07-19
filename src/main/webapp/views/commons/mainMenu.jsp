<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="header">
	<div class="header-menu bg-menu">
		<div class="container">
			<div class="row py-3">
				<div class="col-2 d-flex justify-content-start">
					<a href="<%=request.getContextPath()%>/redirecting"><img
						id="logo-img"
						src="<%=request.getContextPath()%>/resources/images/logo.png"
						alt=""></a>
				</div>
				<div class="col-8">
					<form method="get" action="<%=request.getContextPath()%>/shop">
						<div class="row">
							<div class="col-4">
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text" id="basic-addon1"><i
											class="fas fa-filter"></i></span>
									</div>
									<select name="brandId" class="form-control" aria-label="search"
										aria-describedby="basic-addon1">
										<c:forEach var="brand" varStatus="status" items="${brands }">
										<option value="${brand.brandId }" ${ brandIdSelected == brand.brandId ? 'selected' : ''}>${brand.brandName }</option>										
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="col-6">

								<input class="form-control" value="${keyword }" type="text"
									name="keyword" placeholder="Search" aria-label="Search" maxlength="50">
							</div>
							<div class="col-2">
								<button class="btn btn-outline-success my-2 my-sm-0"
									type="submit">Search</button>
							</div>
						</div>
					</form>
				</div>
				<div class="col-2 d-flex justify-content-end">
					<div class="right-menu">
						<div class="carts">
							<a href="<%=request.getContextPath()%>/cart"><i
								class="fas fa-shopping-cart"></i></a>
							<div id="countCart" class="count">0</div>
						</div>
						<div class="carts ml-3">
							<a href="<%=request.getContextPath()%>/login"><i
								class="fas fa-user"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="header-second-menu" style="background-image: linear-gradient(-90deg,#ec1f1f 0%,#ff9c00 100%);">
			<div class="container">
				<div class="row">
					<c:if test="${not empty brands }">
						<c:forEach var="brand" varStatus="status" items="${brands }">
							<div class="col-2 p-0 text-center">
								<a class="text-light item-menu shadow"
									href="<%=request.getContextPath()%>/shop?brandId=${brand.brandId }">${brand.brandName }</a>
							</div>
						</c:forEach>
					</c:if>
					<c:if test="${empty brands }">
						<%
							String redirectURL = request.getContextPath() + "/redirecting";
						response.sendRedirect(redirectURL);
						%>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>