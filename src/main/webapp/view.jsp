<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>HI ${name} </h1>

<table border="2px">

   <tr>
    <th>ID</th>
    <th>NAME</th>
    <th>EMAIL</th>
    <th>PASSWORD</th>
    <th>DELETE</th>
    <th>EDIT</th>
   </tr>
   <c:forEach  items="${ slist}" var="student">
   <tr>
   <td>${student.id}</td>
   <td>${student.name}</td>
   <td>${student.email}</td>
   <td>${student.password}</td>
   <td><a href="delete?id=${student.id}" >DELETE</a></td>
   <td><a href="edit?id=${student.id}" >EDIT</a></td>
   
   </tr>


</c:forEach>

</table>
</body>
</html>