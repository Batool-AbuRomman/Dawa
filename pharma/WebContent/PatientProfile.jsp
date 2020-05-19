<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="pharma.Pharma_info"%>
<%@page import="pharma.Patient_Medicine"%>
<%@page import="pharma.Patient"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
    <head>
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
                           <li><a href="#">Home</a></li>
                           <li><a href="#">Setting</a></li>
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
                <li><p>${patient.getFirstName()}<span> ${patient.getLast_Name()}</span></p></li>
                <li><button id="bnt1">Personal Info</button></li>
                <li><button id="bnt2">Pharmacies</button></li>
                <li><button id="bnt3">Medicines</button></li>
                <li><button id="bnt4">Requests</button></li>
                <li><button id="bnt5">All Request</button></li>
            </ul>
        </div>
        <div id="info">
            <div>About Me</div>
            <table> 
                <tr>
                    <th> Name</th>
                    <td >${patient.getFirstName()}<span> ${patient.getLast_Name()}</span></td>
                </tr>
                <tr>
                    <th> Birthdate </th>
                     <td> ${patient.getBirthdate()} </td>
                    <th>Age</th>
                    <td>${patient.Age()}</td>
                </tr>
                <tr>
                    <th>Natonality Number</th>
                    <td>${patient.getNationality_Number()}</td>
                </tr>
                </table>
                <div>Address And Number</div>
                <table>
                <tr>
                    <th>Email</th>
                    <td>${patient.getEmail()}</td>
                </tr>
                <tr>
                    <th>Phone Number</th>
                    <td>${patient.getPhoneNumber()}</td>
                </tr>
                <tr>
                    <th>Conutry</th>
                    <td>${patient.getCountry()}</td>
                    <th>City</th>
                    <td>${patient.getCity()}</td>
                </tr>
            </table>
        </div>
        <div id="pharmainfo">
            <div>Pharmasies</div>
            <table> 
                <tr>
                    <th> Name</th>
                    <th>Address</th>
                </tr>
                <% List<Pharma_info> pharmacies =(ArrayList<Pharma_info>)request.getAttribute("pharmacies");
                for (Pharma_info pharma: pharmacies)
                {
                	out.println("<tr>");
                    out.println("<td>"+pharma.getName()+"</td>");
                   out.println("<td>"+pharma.getCountry()+"</td>");
                   out.println("<td>"+pharma.getCity()+"</td>");
                   out.println("<tr>");
                }
                %>
            </table>
        </div>
         <div id="medicneinfo">
            <div>Your Medicne</div>
            <table> 
                <tr>
                    <th> Medicine</th>
                    <th>Dosage</th>
                    <th>Dosage Per Day</th>
                    <th>Last Dosage</th>
                    <th>Pharamacy</th>
                </tr>
                 <% List<Patient_Medicine> list =(ArrayList<Patient_Medicine>)request.getAttribute("list");
                for (Patient_Medicine medicine: list)
                {
                	out.println("<tr>");
                    out.println("<td>"+medicine.getMedicine_name()+"</td>");
                   out.println("<td>"+medicine.getDosage()+"</td>");
                   out.println("<td>"+medicine.getDosage_per_day()+"</td>");
                   out.println("<td>"+medicine.getLast_Date()+"</td>");
                   out.println("<td>"+medicine.getPharmacy()+"</td>");
                   out.println("</tr>");
                }
                %>
                
            </table>
        </div>
        
        <div id="allrequest">
            <div>All Request</div>
            <table> 
                <tr>
                    <th> Medicine</th>
                    <th>Dosage</th>
                    <th>Date</th>
                    <th>Pharamacy</th>
                    <th>Note</th>
                </tr>
                <tr>
                    <% List<Patient_Medicine> lists =(ArrayList<Patient_Medicine>)request.getAttribute("lists");
                for (Patient_Medicine medicine: lists)
                {
                	out.println("<tr>");
                    out.println("<td>"+medicine.getMedicine_name()+"</td>");
                   out.println("<td>"+medicine.getDosage()+"</td>");
                   out.println("<td>"+medicine.getLast_Date()+"</td>");
                   out.println("<td>"+medicine.getPharmacy()+"</td>");
                   //out.println("<td>"+medicine.isAccept()+"</td>");
                   out.println("<tr>");
                }
                %>
                </tr>
            </table>
            
        </div>
        <div id="request">
            <div>New Request</div>
            <form action="Request" method="post" >
            <p>Medicne Name</p>
            <input type="text" name="medicine">
            <p>Dosage</p>
            <input type="text" name="number">
            <p>Pharmacy</p>
            <input type="text" name="pharma">
            <input  type="hidden" name="email1" value="${email}" />
            <input type="submit" name="Send">
      
            </form>
        </div>
    </body>
         <script src="user.js"></script>  

</html>