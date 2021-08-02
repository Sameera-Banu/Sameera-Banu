  <%@page import="com.example.demo.*,java.util.*"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>

<%

response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader("Expires",0);
    if(session.getAttribute("name")==null)
    {
    response.sendRedirect("index.jsp");
    }
    
 %>
 <h1>Welcome, ${user}</h1>
       <a href='logout'>Logout</a>
      <h3>Create new todo</h3>
      <form action='create' method='post'>
      <input type='text' name='new'>
      <input type='submit' value='OK'>
      </form>
      <h1>Todo List</h1>

  
  <%
session.getAttribute("list");
         %>
           
           <table border='1' width='100%'> 
 <tr><th>TodoList</th><th>Edit</th><th>Delete</th></tr>
        <c:forEach items="${list}" var="u"> 
       
         <tr><td>${u.getTlist()}</td><td><a href='edit?id=${u.getTid()}&val=${u.getTlist()}' >edit</a></td><td><a href="<c:url value='/delete/${u.getTid()}' />" >delete</a></td></tr>
         </c:forEach>
     
        </table> 
           
          
           </body>
           </html>
