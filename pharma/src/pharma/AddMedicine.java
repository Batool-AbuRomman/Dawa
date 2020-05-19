package pharma;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddMedicine
 */
@WebServlet("/AddMedicine")
public class AddMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();
	    String med=request.getParameter("medicine");
	    String num=request.getParameter("amount");
	    String company=request.getParameter("company");
	    String date=request.getParameter("date");
		   String id = request.getParameter("id");

	    Pharma_Medicine pharma=new Pharma_Medicine();
	    pharma.setMedicine_name(med);
	    pharma.setCompany(company);
	    pharma.setExpire_Date(date);
	    pharma.setMount(Integer.parseInt(num));
	    pharma.setID_patient(Integer.parseInt(id));
	    try {
			int test=DB_Pharma.Addmed(pharma, Integer.parseInt(id));
			if (test>0)
			{
				String m = "Medicine are add !";
		    request.setAttribute("message", m);
		    RequestDispatcher req= request.getRequestDispatcher("Sacess.jsp");
		    req.include(request, response);
		    }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	    
       
        
	}

}
