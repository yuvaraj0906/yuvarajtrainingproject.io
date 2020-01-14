<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Menu Item List Admin</title>

<meta name="viewport" content="width=device-width,initial-scale=1.0">
<link rel="stylesheet" href="styles\style.css">
</head>

<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<a href="ShowMenuItemListAdmin">Menu</a>
		<img
			src="images\truyum-logo-light.png">
	</div>
	<h1 id="head1">Menu Items</h1>
	<div class="form-field-spacing">
		<table class="table" cellspacing="10px">
			<tr>
					<th>NAME</th>
					<th>PRICE</th>
					<th>ACTIVE</th>
					<th>DATE OF LAUNCH</th>
					<th>CATEGORY</th>
					<th>FREE DELIVERY</th>
					<th>ACTION</th>
				
			</tr>
			<c:forEach items="${menuItem}" var="dataItem">
				<tr>
					<td>${dataItem.name}</td>
					<td>Rs.<fmt:formatNumber value="${dataItem.price}"
							pattern="#,##,##,##,###.00" /></td>
					<td><c:choose>
							<c:when test="${dataItem.active}">yes</c:when>
							<c:otherwise>no</c:otherwise>
						</c:choose></td>
					<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
							value="${dataItem.dateOfLaunch}" /></td>
					<td>${dataItem.category}</td>
					<td><c:choose>
							<c:when test="${dataItem.freeDelivery}">yes</c:when>
							<c:otherwise>no</c:otherwise>
						</c:choose></td>
					<td><a href="ShowEditMenuItem?id=${dataItem.id}">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<div class="footer" id="footer">
			copyright@2019
		</div>
	</div>

</body>
</html>
