package pharma;



import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class PatientSignUP
 */
@WebServlet("/PatientSignUP")
@MultipartConfig(maxFileSize = 16177215)
public class PatientSignUP extends HttpServlet {
	//private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//RequestDispatcher re=request.getRequestDispatcher("SignUp.html");
		int test = 0;
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		InputStream inputStream = null;
		Part filePart = request.getPart("photo");
        if (filePart != null) {
        	
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
            inputStream = filePart.getInputStream();
        }
		try {
		String firstName=request.getParameter("firstname");
		String last_Name=request.getParameter("lastname");
		String Country =request.getParameter("Country");
		String bdate =request.getParameter("BDate");
		String Password=request.getParameter("pass");
	    String Email=request.getParameter("Email");
	    String city=request.getParameter("city");
	    String PhoneNumber=request.getParameter("number");
	    String Nationality_Number=request.getParameter("Nationality_number") ;
	    Patient patient =new Patient ();
	    patient.setFirstName(firstName);
	    patient.setLast_Name(last_Name);
	    patient.setCountry(Country);
	    patient.setCity(city);
	    patient.setPassword(Password);
	    patient.setBirthdate(bdate);
	    patient.setEmail(Email);
	    patient.setPhoneNumber(Integer.parseInt(PhoneNumber));
	    patient.setNationality_Number(Integer.parseInt(Nationality_Number));
        patient.setImage(inputStream );
	    test =PatientDB.Save(patient);
	    if (test>0) {
	    	String message ="Register Scessfully!";
		    request.setAttribute("message", message);
	    	 RequestDispatcher  req= request.getRequestDispatcher("Sacess.jsp");
	    	 req.forward(request, response);
	    	
	    }
		}
		catch (Exception e){
	    String message ="Register Filled";
	    request.setAttribute("message", message);
	    RequestDispatcher req= request.getRequestDispatcher("index.jsp");
	    req.include(request, response);
	   
	
              }
	    	
	    
	}
}

