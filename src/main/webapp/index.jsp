<%@page import="com.example.demo.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Todo</title>
<style>
#t1
{

border:1px solid;
width:400px;
padding:10px;
box-shadow:5px 10px #888888;
margin:auto;
position:absolute;
top:25%;
left:35%;

}

</style>
</head>
<body>
${error}
<form action="log">
<div id="t1">
<h1 style="color:blue;">Todos</h1>
<div align="center">
Username: <input type="text" name="username"></br></br>
Password: &nbsp;<input type="password" name="password"></br></br>
</div>
<div align="center">
<input type="submit" value="Login"></br>
</div></form>
_____________________________________</br></br>
<form action="signup">
<div align="center">
<input type="submit" value="SignUp" >
</div>
</form>
</body>
</html>

