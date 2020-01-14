<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="ie-edge">
<link rel="stylesheet" href="styles\style.css">
<title>menu item list customer</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img
			src="images\truyum-logo-light.png">
		<a href="ShowCart">CART</a><a href="ShowMenuItemListCustomer">MENU</a>
	</div>
	<c:if test="${addCartStatus}">
		<div id="paradiv">
			<p id="para">items added to cart succesfully!!!!</p>
		</div>
	</c:if>
	<div id="body">
		<h1>MENU ITEMS</h1>
		<table class="table">
			<tr bgcolor="">
				<th>NAME</th>
				<th>FREE DELIVERY</th>
				<th>PRICE</th>
				<th>CATEGORY</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${menuItem}" var="dataItem">
				<tr>
					<td>${dataItem.name}</td>
					<td><c:choose>
							<c:when test="${dataItem.freeDelivery}">yes</c:when>
							<c:otherwise>no</c:otherwise>
						</c:choose></td>
					<td>Rs.<fmt:formatNumber value="${dataItem.price}"
							pattern="#,##,##,##,###.00" /></td>
					<td>${dataItem.category}</td>
					<td><a href="AddToCart?menuItemId=${dataItem.id}">Add to
							Cart</a></td>
				</tr>
			</c:forEach>
		</table>
		</div>
	<div class="footer" id="footer">
	 copyright@2019
	 </div>
</body>
</html>