package pharma;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet_donation")
public class servlet_donation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public servlet_donation() {
        super();
    }

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int test = 0;
		response.setContentType("text/html");
		String amount=request.getParameter("amount");
		String firstName=request.getParameter("firstname");
		String last_Name=request.getParameter("lastname");
		String Country =request.getParameter("Country");
		String city =request.getParameter("city");
		String number =request.getParameter("number");
		String email =request.getParameter("Email");
		System.out.println(amount+" "+firstName+" "+last_Name);
		donation donat1=new donation();
		donat1.setAmount(Integer.parseInt(amount));
		donat1.setFirstname(firstName);
		donat1.setLastname(last_Name);
		donat1.setCountry(Country);
		donat1.setCity(city);
		donat1.setEmail(email);
		donat1.setPhone(Integer.parseInt(number));
		 try {
			test=donat1.save();
			 if (test>0) {
			    	String message ="Donate Scessfully!</br> Thank you";
				    request.setAttribute("message", message);
			    	 RequestDispatcher  req= request.getRequestDispatcher("Sacess.jsp");
			    	 req.forward(request, response);
		}
		 }
		 catch (SQLException e) {
			 String message ="Doante Filled ";
			    request.setAttribute("message", message);
			    RequestDispatcher req= request.getRequestDispatcher("indexdonor.jsp");
			    req.include(request, response);
			e.printStackTrace();
		}
		
		
		
		
	}

}
