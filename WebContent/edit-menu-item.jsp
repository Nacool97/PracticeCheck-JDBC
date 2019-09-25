<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style1.css">
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<header  id="p1">
<br>

<p id="a1">&nbsp&nbsptruYum&nbsp&nbsp&nbsp<img src="images/truyum-logo-light.png" height=20 width=20><a href="ShowMenuItemListAdmin" id="a2">Menu</a></p>

</header>
<div>
<p id="e1">Edit Menu Item</p>
<form name="signup"  action="EditMenuItem?id=${menuItemobj.id}" onsubmit=" return validation()" method="post">
<table id="t2">
<tr>
   <td><label for="label1">Name</label></td>
</tr>
<tr>
<td><input id="label1" type="text" name="fname" size="68px" value="${menuItemobj.name}"></td>
</tr>
</table>
<table id="t3">
<tr>
   <td><label for="label2">Price (Rs.)</label></td>
   <td><label for="label3">Active</label></td>
   <td><label for="label4">Date of Launch</label></td>
   <td><label >Category</label></td>
</tr>

<tr>
    <td><input id="label2" type="text" name="fprice" size="8px" value="${menuItemobj.price}"></td>
    <td><input id="label3" type="radio" <c:if test="${menuItemobj.active==true}">checked</c:if> name="inStock" value="Yes" >Yes
    <input type="radio" <c:if test="${menuItemobj.active==false}">checked</c:if> name="inStock" value="No">No</td>
    <fmt:formatDate pattern="dd/MM/yyyy" value="${menuItemobj.dateOfLaunch}" var="dateinformat"/>
    <td><input id="label4" type="text" name="date" value="${dateinformat}"></td>
    <td>
      <select name = "category">
         <option value="Main Course" <c:if test="${menuItemobj.category=='Main Course'}">selected</c:if>>Main Course</option>
         <option value="Starters" <c:if test="${menuItemobj.category=='Starters'}">selected</c:if>>Starters</option>
         <option value="Main Course" <c:if test="${menuItemobj.category=='Main Course'}">selected</c:if>>Main Course</option>
         <option value="Dessert" <c:if test="${menuItemobj.category=='Dessert'}">selected</c:if>>Dessert</option>
         <option value="Drinks" <c:if test="${menuItemobj.category=='Drinks'}">selected</c:if>>Drinks</option>
      </select>
     </td>
</tr>
<tr>
    <td><input type="checkbox" value="java" name="freeDelievery" checked>Free Delivery</td>
</tr>
<tr>
<td><input type="submit"  value="Save" id="b1"/></td>
</tr>
</table>

</form>
</div>

<footer id="p3">
  
  <p id="f1">Copyright@2019</p>
</footer>
</body>
</html>