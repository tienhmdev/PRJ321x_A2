<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="/views/commons/header.jsp"></jsp:include>
<title>Login to cms</title>
</head>

<body>
	<div class="container-fluid m-0 p-0">
        <div class="row m-0 p-0">
            <div class="col-2 p-0 m-0">
                <div class="left-menu">
                    <div class="row p-0 m-0">
                        <div class="col-12 p-0 m-0">
                            <div class="menu">
                                <nav class="navbar navbar-dark bg-dark justify-content-between">
                                    <a class="navbar-brand text-white">CLICKSHOP</a>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <a class="item-menu btn btn-info w-100 p-4 my-1" href="">Dashboard</a>
                            <a class="item-menu btn btn-info w-100 p-4 my-1" href="">Add Category</a>
                            <a class="item-menu btn btn-info w-100 p-4 my-1" href="">Add Produce</a>
                            <a class="item-menu btn btn-info w-100 p-4 my-1" href="">Member Manager</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-10 p-0 m-0">
                <div class="right-body">
                    <div class="row p-0 m-0">
                        <div class="col-12 p-0 m-0">
                            <div class="menu" style="height: 5em;">
                                <nav class="navbar navbar-dark bg-dark justify-content-end">
                                <div class="right-menu">
                                        <div class="user-welcome text-white mr-3"><a href="<%=request.getContextPath()%>/redirecting"><b>Trang bán hàng</b></a></div>
                                    </div>
                                    <div class="right-menu">
                                        <div class="user-welcome text-white mr-3"><b>Wellcome Hoàng Tiến</b></div>
                                    </div>
                                    <div class="right-menu">
                                        <div class="user-welcome text-white">Logout</div>
                                    </div>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <div class="row p-0 m-0">
                        <div class="col-6 pr-1">
                            <div class="card shadow m-2">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Danh mục sản phẩm</h6>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table id="categoryTable" class="table table-hover table-bordered">
                                            <thead class="bg-dark text-light">
                                                <tr>
                                                    <th>STT</th>
                                                    <th>Name</th>
                                                    <th>Total Produce</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>iPhone</td>
                                                    <td>25</td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>Nokia</td>
                                                    <td>25</td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>Sony</td>
                                                    <td>25</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-6 pl-1">
                            <div class="card shadow m-2">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Thành viên</h6>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table id="categoryTable" class="table table-hover table-bordered">
                                            <thead class="bg-dark text-light">
                                                <tr>
                                                    <th>STT</th>
                                                    <th>Username</th>
                                                    <th>Email</th>
                                                    <th>Password</th>
                                                    <th>Phone</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>1</td>
                                                    <td>admin</td>
                                                    <td>admin@funix.edu.vn</td>
                                                    <th>***</th>
                                                    <th>0123456789</th>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>admin</td>
                                                    <td>admin@funix.edu.vn</td>
                                                    <th>***</th>
                                                    <th>0123456789</th>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>admin</td>
                                                    <td>admin@funix.edu.vn</td>
                                                    <th>***</th>
                                                    <th>0123456789</th>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row p-0 m-0">
                        <div class="col-12">
                            <div class="card shadow m-2">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">Sản phẩm</h6>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table id="categoryTable" class="table table-hover table-bordered">
                                            <thead class="bg-dark text-light">
                                                <tr>
                                                    <th>STT</th>
                                                    <th>Username</th>
                                                    <th>Title</th>
                                                    <th>Category</th>
                                                    <th>Descriptions</th>
                                                    <th>Promotions</th>
                                                    <th>Price</th>
                                                    <th>Image</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr class="">
                                                    <td>1</td>
                                                    <td>admin</td>
                                                    <td>iPhone XR 64GB</td>
                                                    <td>iPhone</td>
                                                    <td>Siêu phẩm Samsung S20+ đã xuất hiện. Thể hiện đẳng cấp đích thực với thiết kế cao cấp, màn hình lớn đẹp tuyệt mỹ, 5 camera chuyên nghiệp và hiệu suất đáng kinh ngạc.</td>
                                                    <td>Ưu đãi đặc biệt khi mua S20 Plus đến 07/06: Giảm ngay
                                                        9,000,000đ (*) Trả góp 0%.</td>
                                                    <td>17.990.000</td>
                                                    <td>https://cdn.fptshop.com.vn/Uploads/Originals/2020/2/12/637170945536714482_ss-s20-plus-den-1.png</td>
                                                </tr>
                                                <tr>
                                                    <td>2</td>
                                                    <td>admin</td>
                                                    <td>iPhone XR 64GB</td>
                                                    <td>iPhone</td>
                                                    <td>Siêu phẩm Samsung S20+ đã xuất hiện. Thể hiện đẳng cấp đích thực với thiết kế cao cấp, màn hình lớn đẹp tuyệt mỹ, 5 camera chuyên nghiệp và hiệu suất đáng kinh ngạc.</td>
                                                    <td>Ưu đãi đặc biệt khi mua S20 Plus đến 07/06: Giảm ngay
                                                        9,000,000đ (*) Trả góp 0%.</td>
                                                    <td>17.990.000</td>
                                                    <td>https://cdn.fptshop.com.vn/Uploads/Originals/2020/2/12/637170945536714482_ss-s20-plus-den-1.png</td>
                                                </tr>
                                                <tr>
                                                    <td>3</td>
                                                    <td>admin</td>
                                                    <td>iPhone XR 64GB</td>
                                                    <td>iPhone</td>
                                                    <td>Siêu phẩm Samsung S20+ đã xuất hiện. Thể hiện đẳng cấp đích thực với thiết kế cao cấp, màn hình lớn đẹp tuyệt mỹ, 5 camera chuyên nghiệp và hiệu suất đáng kinh ngạc.</td>
                                                    <td>Ưu đãi đặc biệt khi mua S20 Plus đến 07/06: Giảm ngay
                                                        9,000,000đ (*) Trả góp 0%.</td>
                                                    <td>17.990.000</td>
                                                    <td>https://cdn.fptshop.com.vn/Uploads/Originals/2020/2/12/637170945536714482_ss-s20-plus-den-1.png</td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<jsp:include page="/views/commons/footer.jsp"></jsp:include>
</body>

</html>