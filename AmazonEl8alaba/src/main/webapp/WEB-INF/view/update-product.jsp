<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css" />">
</head>
<body>
<h1>Update Product</h1>
<form:form action="/" modelAttribute="product" method="post">
    <div class="container mt-5">
    <div class="row justify-content-center">
    <div class="col-md-6">
    <form:hidden path="id" />
    <div class="form-group">
    <label for="productName">Product Name</label>
    <form:input type="text" cssClass="form-control" path="productName" placeholder="Enter product name" />
    <form:errors path="productName" cssClass="error" />
    </div>
    <div class="form-group">
    <label for="productDetails.expiryDate">Expiration Date</label>
    <form:input type="date" cssClass="form-control" path="productDetails.expiryDate" />
    <form:errors path="productDetails.expiryDate" cssClass="error" />
    </div>
    <div class="form-group">
    <label for="productDetails.manufacturer">Manufacturer</label>
    <form:input type="text" cssClass="form-control" path="productDetails.manufacturer" placeholder="Manufacturer" />
        <form:errors path="productDetails.manufacturer" cssClass="error" />
    </div>
        <div class="form-group">
            <label for="productDetails.price">Price</label>
            <form:input type="number" cssClass="form-control" path="productDetails.price" placeholder="Price" />
            <form:errors path="productDetails.price" cssClass="error" />
        </div>
        <div class="form-group">
            <label for="productDetails.available">Availability</label>
            <form:select cssClass="form-control" path="productDetails.available">
                <form:option value="true" label="Available" />
                <form:option value="false" label="Unavailable" />
            </form:select>
            <form:errors path="productDetails.available" cssClass="error" />
        </div>
        <input type="submit" class="btn btn-primary" value="Update Product" />
    </div>
    </div>
    </div>
</form:form>
</body>
</html>