<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="ie-edge">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styles\style.css">
<title>edit Movie</title>
<script src="js\script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img
			src="images\truyum-logo-light.png">
		<a href="ShowMenuItemListAdmin">menu</a>
	</div>

	<h1 id="head1">EDIT MENU</h1>


	<div class="body-content-colour">
		<form action="EditMenuItem" onSubmit="return validateMenuItemForm()" name="menuItemForm" method="post">
			<div class="form-field-spacing">
				<label for="title"><b>NAME</b></label> <br>
				<input type="text" class="text-box" value="${menuItem.name}"
					name="name" id="title" size="100">
			</div>
	
	<div>
		<input type="hidden" name="id" value="${menuItem.id}">
	</div>
	<div class="form-field-spacing">
		<label for="gross"><b>PRICE(Rs.)</b></label> <br>
		<input type="text" class="text-box" value="${menuItem.price}"
			name="price" id="price">
	</div>
	<div class="form-field-spacing">
		<label for="active"><b>Active</b></label>
		<div>
			yes<input type="radio" name="active" value="yes"
				<c:if test="${menuItem.active}">checked</c:if>> no<input
				type="radio" name="active" value="no"
				<c:if test="${menuItem.active}">checked</c:if>>
		</div>
	</div>
	<div class="form-field-spacing">
		<label for="dateOfLaunch"><b>Date of Launch</b></label>
		<div>
			<input type="text" class="text-box" name="dateOfLaunch"
				value="<fmt:formatDate type="date" pattern="dd/MM/yyyy" value="${menuItem.dateOfLaunch}"/>">
		</div>
	</div>
	<div class="form-field-spacing">
		<label for="category"><b>category</b></label>
		<div>
			<select name="category" class="dropdown" id="category">
				<option value="${menuItem.category }">${menuItem.category }</option>
				<option value="maincourse">main course</option>
				<option value="starters">starters</option>
				<option value="dessert">dessert</option>
				<option value="drinks">drinks</option>
			</select>
		</div>
	</div>
	<div>
		<div class="form-field-spacing">
			<c:if test="${menuItem.freeDelivery }">
				<input type="checkbox" name="freeDelivery" checked>
			</c:if>
			<c:if test="${!menuItem.freeDelivery }">
				<input type="checkbox" name="freeDelivery">
			</c:if>
			<label for="freeDelivery">Free Delivery</label>
		</div>
	</div>
	<div>
		<input class="success-button" type="submit" value="save">
	</div>
	<div class="footer" id="footer">
	 copyright@2019
	</div>
	</form>
	</div>
</body>
</html>