<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product Details</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/product-details.css" />">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Product Details</h1>
    <div class="row justify-content-center">
        <div class="col-md-10">
            <div class="product-details-container">
                <c:if test="${not empty product.productDetails.image}">
                    <div class="product-image">
                        <img src="data:image/jpeg;base64,${product.productDetails.imageBase64}" alt="Product Image" />
                    </div>
                </c:if>

                <div class="product-info">
                    <h5>${product.productName}</h5>
                    <p><strong>Expiration Date:</strong> ${product.productDetails.expirationDate}</p>
                    <p><strong>Manufacturer:</strong> ${product.productDetails.manufacturer}</p>
                    <p><strong>Price:</strong> $${product.productDetails.price}</p>
                    <p><strong>Availability:</strong> ${product.productDetails.available ? 'Yes' : 'No'}</p>
                    <a href="/products/list" class="btn btn-primary">Back to List</a>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>