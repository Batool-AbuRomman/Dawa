<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dawa</title>
        <link rel="stylesheet" type="text/css" href="donor.css">
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
 <img src="Photo/pexels-photo-4047056.jpeg" style="height:350px;width:1350px;">
    <div class="signup">
        <form action='servlet_donation' method='post' >
           <h1>Donate Now</h1>
            <h2 style="color:red">${message}</h2>
             <div>
             <p>Credit  card</p>
            <input type="number"  name="credit" placeholder="Credit Card number">
            <input type="number"  name="cvv" placeholder="CVV">
            <br><br>
            <input type="number"  name="mm" placeholder="MM">/
             <input type="number"  name="yy" placeholder="YY">
             <br><br>
            <input type="number"  name="amount" placeholder="Amount $">
            </div>
            <br><br><br>
            <p>First Name:</p>
            <input type="text" name="firstname" placeholder="First Name"><br><br>
            <p>Last Name:</p>
             <input type="text" name="lastname" placeholder="last Name"><br><br>
             <p>Country </p>
            <input type="text" name="Country" placeholder="Country"><br><br>
             <p>City</p>
            <input type="text" name="city" placeholder="City"><br><br>
             <p>Phone Number</p>
            <input type="number"  name="number" placeholder="phone number"><br><br>
              <p>Email:</p>
             <input type="text" name="Email" placeholder="email">
            <br><br>
            <input type="submit" name="Donate" value="Donate">
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
    