package pharma;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Request
 */
@WebServlet("/Request")
public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Request() {
        super();
       
    }

	

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		String med=request.getParameter("medicine"); 
	    String num=request.getParameter("number"); 
	    String pharma=request.getParameter("pharma");
	    String email =request.getParameter("email1"); 
	      
	   
	      
	  System.out.println(email);
	    Request_Patient Rp=new  Request_Patient();
	    Rp.setDosage(Integer.parseInt(num));
	    Rp.setMedicine(med);
	    Rp.setPharmacy(pharma);
	 
	  int test=PatientDB.SaveRequest(email,Rp);
	if (test>0)
	{
		String m = "Your Request Send !";
	request.setAttribute("message", m);
	RequestDispatcher req= request.getRequestDispatcher("Sacess.jsp");
	req.include(request, response);
	}
	    
	    
	   
	}

}
