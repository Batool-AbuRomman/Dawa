<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="pharma.Pharma_info"%>
    <%@page import="pharma.Pharma_Medicine" %>
    <%@page import="java.util.ArrayList"%>
	<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
   
        <title>Dawa</title>
        <link rel="stylesheet" type="text/css" href="user1.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
    </head>
    <body>
       <header>
         <div class="navpart">
             <nav>
            <img class="logo" src="Photo/logo2.png">
             <ul >
                 <li class="rightside"><a>Name <i class="fas fa-caret-down"></i></a>
                       <ul class="dropdownuser">
                           <li><a href="#">Medicines</a></li>
                           <li><a href="#">Requests</a></li>
                           <li><a href="logout.jsp">Logout</a></li>
                        </ul>
                 </li>
             </ul>
             </nav>
           </div>  
        </header>
        <div class="sidebar">
            <ul>
                <li><img  class="picperson" src="Photo/3461699.jpg"></li>
                <li><p>${pharma.getName()}</p></li>
                <li><button id="bnt1">Pharma Info</button></li>
                <li><button id="bnt2">Medicines</button></li>
                <li><button id="bnt3">Patients reviews</button></li>
                <li><button id="bnt4">Add Medicine</button></li>
            </ul>
        </div>
        <div id="info">
            <div>About Pharmacy</div>
            <table> 
                <tr>
                    <th> Name</th>
                    <td>${pharma.getName()}</td>
                </tr>
                <tr>
                    <th> Number </th>
                     <td> ${pharma.getNumber()} </td>
                    
                </tr>
                <tr>
                <th>Country</th>
                    <td>${pharma.getCountry()}</td>
                   <th>City</th>
                    <td>${pharma.getCity()}</td>
                    
                </tr>
                </table>
        </div>
        <div id="pharmainfo">
            <div>Medicnes</div>
            <table> 
                <tr>
                    <th>Medicine</th>
                    <th>Company</th>
                    <th>Number_of Medicine</th>
                    <th>Expire date</th>
                    <th>Note</th>
                </tr>
                <tr>
               
                  <%List<Pharma_Medicine> list =(ArrayList<Pharma_Medicine>)request.getAttribute("list");
                for (Pharma_Medicine medicine: list)
                {
                	out.println("<tr>");
                    out.println("<td>"+medicine.getMedicine_name()+"</td>");
                   out.println("<td>"+medicine.getCompany()+"</td>");
                   out.println("<td>"+medicine.getMount()+"</td>");
                   out.println("<td>"+medicine.getExpire_Date()+"</td>");
                  out.println("</tr>");
                }
                %>
                </tr>
            </table>
        </div>
        
        <div id="medicneinfo">
            <div>Patients</div>
            <table> 
                <tr>
                    <th>Name Patients</th>
                    <th>Medicine</th>
                    <th>Number_of Medicine</th>
                    <th> Exchange Date</th>
                    <th> Accept Request</th>
                </tr>
                <tr>
                <% List<Pharma_Medicine> lists =(ArrayList<Pharma_Medicine>)request.getAttribute("lists");
                boolean test;
                for (Pharma_Medicine medicine: lists)
                {
                	out.println("<tr>");
                    out.println("<td>"+medicine.getPatientname()+"</td>");
                   out.println("<td>"+medicine.getMedicine_name()+"</td>");
                   out.println("<td>"+medicine.getDosage()+"</td>");
                   out.println("<td>"+medicine.getExchange_Date()+"</td>");
                   if (medicine.isAccept())
                   out.print("<td>"+"Yes"+"</td>");
                   else 
                   { out.print("<td>"+"No"+"</td>");
           
                   out.println("</tr>");
                   
                   
                   }
    
                }
                %>
                </tr>
            </table>
        </div>
      
        
         <div id="request">
         <form action="AddMedicine" method="post">
            <div>ADD Medicine</div>
            <p>Medicne Name</p>
            <input type="text" name='medicine'>
            <p>Number</p>
            <input type="text" name='amount'>
             <p>Company</p>
            <input type="text" name='company'>
             <p>Expire date</p>
            <input type="date" name='date'>
            <input type="hidden" name="id" value="${id}">
            <input type="submit" name="OK" value="ADD">
           
            </form>
        </div>
 <div Style="color:red margin:350px;">${message}</div>
</body>
<script src="user.js"></script>
</html>