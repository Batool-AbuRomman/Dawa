<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
    <head>
        <title>Dawa</title>
        <link rel="stylesheet" type="text/css" href="signup.css">
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
                 <li><a>About</a></li>
                 <li><a>Contact Us</a></li>
             </ul>
             </nav>
           </div>  
        </header>
        <img class="signinpic" src="Photo/undraw_authentication_fsn5.png">
        <div class="signin">
        <form action="loginservlet" method="post">
            <img src="Photo/240_F_259394679_GGA8JJAEkukYJL9XXFH2JoC3nMguBPNH.jpg">
            <h1>Sign in</h1>
             <h3 style="color:red">${message}</h3>
            <p>UserName:</p>
            <input id="h" type="text" name="username" placeholder="USERNAME" >
            <p>Password: </p>
            <input type="password" name="pass" placeholder="PASSWORD">
            <p><a href="" > Forget Password?</a></p>
            <input type="submit" value="LOG IN">
            <p class="forget">Don't have account? <a href=""> Sign Up</a></p>
            </form>
        </div>    
       <footer>
           <ul>
                <li><a>Home</a></li>
                <li><a>Register</a></li>
               <li><a>About</a></li>
               <li><a>Contact Us</a></li>
              
              
           </ul>
        </footer>
        <script src="login.js"></script>
    </body>
</html>