<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <form:form  action="updateStudent" modelAttribute="student">
  
  <form:label path="id">ID</form:label>
 <form:input path="id"  readonly="true"/> 
  
  <form:label path="name">NAME</form:label>
 <form:input path="name"/> 
 
 <form:label path="school">SCHOOL</form:label>
 <form:input path="school"/> 
 
 
 <form:label path="email">EMAIL</form:label>
 <form:input path="email"/> 
 
 <form:label path="password">PASSWORD</form:label>
 <form:input path="password"/>
  
 <form:label path="phone">PHONE</form:label>
 <form:input path="phone"/> 
 
 <input type="submit" >
  
  
  
  </form:form>


</body>
</html>