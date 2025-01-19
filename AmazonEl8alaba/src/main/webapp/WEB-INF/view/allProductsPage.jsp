<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Products Data</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h2>Products Data</h2>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Show Details</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.productName}</td>
                <td>
                    <c:url var="details" value="/">
                        <c:param name="productId" value="${product.id}" />
                    </c:url>
                    <a class="btn btn-primary btn-sm" href="${details}">View Details</a>
                </td>
                <td>
                    <!-- Update Product -->
                    <c:url var="update" value="/updateProductForm">
                        <c:param name="productId" value="${product.id}" />
                    </c:url>
                    <a href="${update}" class="btn btn-warning btn-sm">Update</a>

                    <!-- Delete Product -->
                    <c:url var="delete" value="/delete">
                        <c:param name="productId" value="${product.id}" />
                    </c:url>
                    <a href="${delete}" class="btn btn-danger btn-sm">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- Button to Add a New Product -->
    <a href="/products/showFormForAdd" class="btn btn-success">Add New Product</a>
</div>
</body>
</html>
