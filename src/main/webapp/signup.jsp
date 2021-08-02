<%@page import="com.example.demo.*"%>
<!DOCTYPE html>
<html>
<head>
<title>SignUp</title>
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
<form action="sign" >
<div id="t1">
<h1 style="color:blue;">Todos</h1>
<h3>Create Account</h3>
Username: <input type="text" name="name"></br></br>
Email:&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;<input type="text" name="email"></br></br>
New Password: &nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password"></br></br>
Confirm Password: <input type="password" name="password1"></br>
<div align="center">
<input type="submit" value="Create" name="view" ></br>
</div>
</form>
</div>
</body>
</html>

