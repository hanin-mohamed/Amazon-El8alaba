<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Products</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">All Products</h1>
    <a href="/products/addProduct" class="btn btn-success mb-3">Add New Product</a>
    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th>Name</th>
            <th>Show Details</th>
            <th>Update</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.productName}</td>
                <td>
                    <a href="/products/productDetails?productId=${product.id}" class="btn btn-info btn-sm">View Details</a>
                </td>
                <td>
                    <a href="/products/updateProduct?productId=${product.id}" class="btn btn-warning btn-sm">Update Details</a>
                </td>
                <td>
                    <a href="/products/deleteProduct?productId=${product.id}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this product?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>