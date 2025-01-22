<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Product</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Update Product</h1>
    <form:form action="/products/processUpdateProduct" modelAttribute="product" method="post">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <form:hidden path="id" />
                <form:hidden path="productDetails.id" />

                <div class="form-group">
                    <label for="productName">Product Name</label>
                    <form:input type="text" cssClass="form-control" path="productName" placeholder="Enter product name" />
                    <form:errors path="productName" cssClass="text-danger" />
                </div>

                <div class="form-group">
                    <label for="productDetails.expirationDate">Expiration Date</label>
                    <form:input type="date" cssClass="form-control" path="productDetails.expirationDate" />
                    <form:errors path="productDetails.expirationDate" cssClass="text-danger" />
                </div>

                <div class="form-group">
                    <label for="productDetails.manufacturer">Manufacturer</label>
                    <form:input type="text" cssClass="form-control" path="productDetails.manufacturer" placeholder="Manufacturer" />
                    <form:errors path="productDetails.manufacturer" cssClass="text-danger" />
                </div>

                <div class="form-group">
                    <label for="productDetails.price">Price</label>
                    <form:input type="number" cssClass="form-control" path="productDetails.price" placeholder="Price" />
                    <form:errors path="productDetails.price" cssClass="text-danger" />
                </div>

                <div class="form-group">
                    <label for="productDetails.available">Availability</label>
                    <form:select cssClass="form-control" path="productDetails.available">
                        <form:option value="true" label="Available" />
                        <form:option value="false" label="Unavailable" />
                    </form:select>
                    <form:errors path="productDetails.available" cssClass="text-danger" />
                </div>

                <div class="form-group text-center">
                    <input type="submit" class="btn btn-primary" value="Update Product" />
                    <a href="/products/list" class="btn btn-secondary">Back to List</a>
                </div>
            </div>
        </div>
    </form:form>
</div>
</body>
</html>