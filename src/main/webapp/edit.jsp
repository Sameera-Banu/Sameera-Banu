<%@page import="com.example.demo.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
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
<form action='edit2'>
Update the Todo:<br>
<input type='text' name='list' value='${lvalue}'>
<input type='submit' value='OK'>
</form>
</body>
</html>