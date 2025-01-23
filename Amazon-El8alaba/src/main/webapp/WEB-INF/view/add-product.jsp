<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add New Product</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css' />">
</head>
<body>
<div class="container mt-5">
    <h1>Add New Product</h1>
    <form:form action="processAddProduct" modelAttribute="product" method="post" enctype="multipart/form-data">
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


    <c:if test="${not empty product.productDetails.image}">
        <img src="data:image/jpeg;base64,${product.productDetails.imageBase64}" alt="Product Image" class="img-fluid" />
    </c:if>

        <div class="form-group">
            <label for="productDetails.image">Product Image</label>
            <input type="file" class="form-control" name="image" accept="image/*" />
            <form:errors path="productDetails.image" cssClass="text-danger" />
        </div>


        <div class="form-group">
            <label for="productDetails.available">Availability</label>
            <form:select cssClass="form-control" path="productDetails.available">
                <form:option value="true" label="Available" />
                <form:option value="false" label="Unavailable" />
            </form:select>
            <form:errors path="productDetails.available" cssClass="text-danger" />
        </div>

</div>
<div class="form-group text-center">
    <button type="submit" class="btn btn-primary">Add Product</button>
</div>
    </form:form>
</div>
</body>
</html>