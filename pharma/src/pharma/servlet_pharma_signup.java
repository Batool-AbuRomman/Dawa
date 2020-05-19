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


@WebServlet("/servelt_pharma_singup")
@MultipartConfig(maxFileSize = 16177215)
public class servlet_pharma_signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public servlet_pharma_signup() {
        super();
        
    }

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher re=request.getRequestDispatcher("indexpharma.jsp");
		int test = 0;
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		InputStream inputStream = null;
		Part filePart = request.getPart("photo");
        if (filePart != null) {
            inputStream = filePart.getInputStream();
        }
        System.out.print("1");
		try {
		String Name=request.getParameter("name");
		String User_Name=request.getParameter("username");
		String Country =request.getParameter("Country");
		String bdate =request.getParameter("EDate");
		String Password=request.getParameter("pass");
	    String Email=request.getParameter("Email");
	    String city=request.getParameter("city");
	    String PhoneNumber=request.getParameter("number");
	    System.out.print("2");
	    Pharma_info pharma= new Pharma_info();
	    pharma.setName(Name);
	    pharma.setUsername(User_Name);
	    pharma.setCountry(Country);
	    pharma.setCity(city);
	    pharma.setPassword(Password);
	    pharma.setEdate(bdate);
	    pharma.setEmail(Email);
	    pharma.setNumber(Integer.parseInt(PhoneNumber));
        pharma.setImage(inputStream );
	    test =DB_Pharma.Save(pharma);
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
	   
	    RequestDispatcher req= request.getRequestDispatcher("indexpharma.jsp");
	    req.include(request, response);
	   
	
              }
	    	
	    
	
	}

}
