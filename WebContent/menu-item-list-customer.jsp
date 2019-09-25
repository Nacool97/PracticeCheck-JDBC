<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style2.css">
<link rel="stylesheet" href="css/style1.css">
</head>
<body>
<header  id="p1">
<br>

<p id="a1">&nbsp&nbsp truYum &nbsp&nbsp&nbsp<img src="images/truyum-logo-light.png" height=20 width=20><a href="ShowCart" id="a2">Cart</a> <a href="ShowMenuItemListCustomer" id="a3" >Menu</a>
</p>

</header>
<div>
<c:if test="${addCartStatus==true}">
<center><p id="div111">Item added to cart successfully</p></center></c:if>
<p id="m1">Menu Items</p>

<table id="t1">
<tr>

  <th id="t11">Name</th>
  <th id="t12">Free Delievery</th>
  <th id="t13">Price</th>
  <th id="t14">Category</th>
  <th id="t15">Action</th>
</tr>
<c:forEach items="${menuItemListobj}" var="list" >
<tr>
  <td id="t11">${list.name}</td>
  <c:if test="${list.freeDelivery==true}">
  <td id="t12">Yes</td>
  </c:if>
   <c:if test="${list.freeDelivery==false}">
  <td id="t12">No</td>
  </c:if>
  <td id="t13">${list.price}</td>
  <td id="t14">${list.category}</td>
  
  <td id="t15"><a href="AddToCart?id=${list.id}">Add to cart</a></td>
</tr>
</c:forEach>
  </table>
</div>

<footer id="p3">
  
  <p id="f1">Copyright &copy 2019</p>
</footer>
</body>
</html>