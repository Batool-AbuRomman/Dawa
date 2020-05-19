<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<meta charset="utf-8">
    <head>
        <title>Dawa</title>
        <link rel="stylesheet" type="text/css" href="home.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
        <script src='https://kit.fontawesome.com/a076d05399.js'></script>
    </head>
    <body>
        <header>
         <div class="navpart">
             <nav>
         <img class="logo" src="Photo/logo2.png">
             <ul >
                 <li ><a href="home.jsp">Home</a></li>
                 <li><a href="login.jsp">Login</a></li>
                 <li><a href="index.jsp">Register</a></li>
                 <li><a>About</a></li>
                 <li><a>Contact Us</a></li>
             </ul>
             </nav>
           </div>  
        </header>
        <body>
			<div>
				 <h1 Style="color:red;margin:100px">${message}</h1>
			</div>
   
</body>
</html>