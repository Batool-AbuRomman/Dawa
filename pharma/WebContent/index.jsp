<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
        <img  class="signuppic" src="Photo/undraw_fill_forms_yltj.png">
    <div class="signup">
        <form action='PatientSignUP' method='post' enctype="multipart/form-data">
            <h1>Sing UP</h1>
            <h1 style="color:red">${message}</h1>
            <h3>Personal Information</h3>
            <div>
                
            </div>
            <span >First Name:</span>
            <input type="text" name="firstname" placeholder="First Name"><br><br>
            <span >Last Name:</span>
             <input type="text" name="lastname" placeholder="last Name"><br><br>
             <span>Date of birth</span>
            <input type="date" name="BDate" placeholder="Date Of Birth"><br><br>
             <span>
            Country
            </span>
            <input type="text" name="Country" placeholder="Country"><br><br>
             <span>
            City
            </span>
            <input type="text" name="city" placeholder="City"><br><br>
             <span>Phone Number</span>
            <input type="number"  name="number" placeholder="phone number"><br><br>
            <span >Nationality Number:</span>
              <input type="number" name="Nationality_number" placeholder="nationality number">
            <br><br>
              <span >Email:</span>
             <input type="text" name="Email" placeholder="email">
            <br><br>
            <span>
            Password
            </span>
            <input type="password" name="pass" placeholder="PassWord">
            <br><br>
            <span >Confirm Password:</span>
            <input type="password"  placeholder="Confirm PassWord">
            <br><br>
             <span>
            personal image
            </span><br>
            <input type="file" name="photo" style="margin-left: 50px; size=50 "><br><br>
            <input type="submit" name="Sign Up" value="Sign Up">
            </form>
            
        </div>
          <footer>
              <ul>
                <li><a>Home</a></li>
               <li><a>About</a></li>
               <li><a>Contact Us</a></li>
           </ul>
    </footer>  
            
    </body>
</html>
