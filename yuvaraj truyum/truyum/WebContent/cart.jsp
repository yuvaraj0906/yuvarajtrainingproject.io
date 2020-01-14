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
		<a href="ShowMenuItemListCustomer">MENU</a>
	</div>
	<h1>products</h1>
	<table>
		<tr>
			<th>Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
			<th>Category</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${cart.menuItemList}" var="menuItem">
			<tr>
				<td>${menuItem.name}</td>
				<td><c:choose>
						<c:when test="${menuItem.freeDelivery eq 'true'}">Yes</c:when>
						<c:otherwise>No</c:otherwise>
					</c:choose></td>
				<td><fmt:setLocale value="en_IN" /> <fmt:formatNumber
						value="${menuItem.price}" type="currency"
						pattern="#,##,##,##,###.00" /></td>
				<td>${menuItem.category}</td>
				<td><a href="RemoveCart?menuItemId=${menuItem.id}">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>

			<td class="total">Total</td>
			<td class="total">Rs.<fmt:formatNumber value="${cart.total}"
					pattern="#,##,##,##,###.00" />
			</td>
			<td></td>
		</tr>
		</table>
		<div class="footer" id="footer">
			 copyright@2019 
        </div>
</body>
</html>