<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ page import="com.cts.model.Employee,java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h4 style="color:blue">Welcome <%=request.getParameter("username") %></h4>
 
 <table>
 <tr>
 <td><a href="RegisterEmployee">Register</a></td>
 <td><a href="updateEmployee">Update</a></td>
 <td><a href="deleteEmployee">Delete</a></td>
 <td><a href="showAllEmployee">Show All</a></td>
 </tr>
 </table>
 
 <% if(session.getAttribute("status")!=null){ %>
 <%=session.getAttribute("status") %>
 <%session.removeAttribute("status"); }%>
 
 <% if(session.getAttribute("allEmp")!=null){ 
 
	 List<Employee> list=(List<Employee>)session.getAttribute("allEmp");
	 request.setAttribute("list", list);
 
 %>
 <table>
 <c:forEach items='${requestScope.list}' var="emp"> 
  <tr> <td>${emp.id}</td><td>${emp.name}</td><td>${emp.salary}</td></tr>
 </c:forEach>
 </table>
 <%session.removeAttribute("allEmp");
   out.println(session.getAttribute("allEmp"));
 }%>
 
 <% if(session.getAttribute("showReg")!=null){ %>
 <jsp:include page="registerEmployee.jsp"></jsp:include>
 <%session.removeAttribute("showReg"); }%>
 
 
 
</body>
</html>