<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style1.css">
<link rel="stylesheet" href="css/style2.css">
</head>
<body>
<header  id="p1">
<br>

<p id="a1">&nbsp&nbsptruYum&nbsp&nbsp&nbsp<img src="images/truyum-logo-light.png" height=20 width=20><a href="ShowMenuItemListAdmin" id="a2">Menu</a></p>

</header>
<div>
<p id="m1">Menu Items</p>
<table id="t1">
<tr>
  <th>Name</th>
  <th>Price</th>
  <th>Active</th>
  <th>Date of Launch</th>
  <th>Category</th>
  <th>Free Delievery</th>
  <th>Action</th>
</tr>
<c:forEach items="${menuItemListobj}" var="list" >
<tr>
  <td id="t11">${list.name}</td>
  <td id="t12">${list.price}</td>
  <c:if test="${list.active==true}">
  <td id="t13">Yes</td>
  </c:if>
   <c:if test="${list.active==false}">
  <td id="t13">No</td>
  </c:if>
  <td id="t14"><fmt:formatDate pattern="dd/MM/yyyy" value="${list.dateOfLaunch}"/></td>
  <td id="t15">${list.category}</td>
  <c:if test="${list.freeDelivery==true}">
  <td id="t16">Yes</td>
  </c:if>
   <c:if test="${list.freeDelivery==false}">
  <td id="t16">No</td>
  </c:if>
  <td id="t17"><a href="ShowEditMenuItem?id=${list.id}">Edit</a></td>
</tr>
</c:forEach>
</table>
</div>
<footer id="p3">
  
  <p id="f1">Copyright &copy2019</p>
</footer>
</body>
</html>