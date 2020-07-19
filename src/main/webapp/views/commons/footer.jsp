<div id="footer">
	<div class="row p-0 m-0 bg-menu">
		<div class="col-12 p-0">
			<div class="container">
				<div class="copyright text-center lead mt-2 mb-2">
					<p>
						<b>Copyright 2020 @ TienHMSE00201X . FUNiX</b>
					</p>
				</div>
			</div>
		</div>
	</div>
</div>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/main.js"></script>
<script>
	var cartCount = $('#countCart');
	var viewCart = $('#viewCart');
	
	
	/* UPDATE CART */
	var data = { productId: -1, status: 'update' };
	$.ajax({
		type: "POST",
		url: "cart",
		contentType: "application/json",
		dataType: 'json',
		data: JSON.stringify(data),
		success: function (data) {
			/*show alert */
			var countNumber = parseInt(data["totalCart"]);
			cartCount.html(countNumber);
		},
		error: function (error) {
			/*show alert */
			alert('error');
		},

	});
	
	/* UPDATE CART WHEN CLICK */
	function addToCart(id) {
		//using ajax sent id to controller and save id to table cart
		var data = { productId: id, status: 'insert' };
		$.ajax({
			type: "POST",
			url: "cart",
			contentType: "application/json",
			dataType: 'json',
			data: JSON.stringify(data),
			success: function (data) {
				/*show alert */
				var vc = '<a href="' + '<%=request.getContextPath() %>/cart' + '" id="viewCart"><b>View cart</b></a>';
				var countNumber = parseInt(data["totalCart"]);
				viewCart.html(vc);
				cartCount.html(countNumber);
				$('.toast').toast('show');
			},
			error: function (error) {
				/*show alert */
				var vc = 'Add product to cart has been error!';
				var countNumber = parseInt(cartCount.text());
				viewCart.html(vc);
				cartCount.html(countNumber + 1);
				$('.toast').toast('show');
			},

		});
	}
</script>