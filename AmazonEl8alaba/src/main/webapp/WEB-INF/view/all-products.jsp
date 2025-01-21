<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
</head>
<body>
<h1>Product Details</h1>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    Product Details
                </div>
                <div class="card-body">
                    <h5 class="card-title">${product.productName}</h5>
                    <p class="card-text">Expiration Date: <fmt:formatDate value="${product.productDetails.expiryDate}" pattern="dd/MM/yyyy" /></p>
                    <p class="card-text">Manufacturer: ${product.productDetails.manufacturer}</p>
                    <p class="card-text">Price: ${product.productDetails.price}</p>
                    <p class="card-text">Available: ${product.productDetails.available ? 'Yes' : 'No'}</p>
                    <!-- لو عندك صورة -->
                    <c:if test="${not empty product.productDetails.image}">
                        <img src="data:image/jpeg;base64,${product.productDetails.image}" alt="Product Image" class="img-fluid" />
                    </c:if>
                </div>
            </div>
            <a href="/" class="btn btn-primary mt-3">Back to List</a>
            <a href="/updateProduct?productId=${product.id}" class="btn btn-warning mt-3">Edit Product</a>
        </div>
    </div>
</div>
</body>
</html>