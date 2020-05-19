package pharma;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String n=request.getParameter("username");  
		    String p=request.getParameter("pass");  
		    RequestDispatcher rd=null;
		    RequestDispatcher rd2=null;
		    long []arr=new long [2];
		    arr=Users.Split(n);
		    //System.out.println(arr[0]+"    "+arr[1]);
		    if(arr[0]==1 && PatientDB.validate(n, p)){  
		    	Patient patient=PatientDB.RetrievePatient(n);
		        List<Pharma_info>pharmacies=DB_Pharma.pharmaies();
		        List<Patient_Medicine>list=PatientDB.RetrieveMedicine(n);
		        List<Patient_Medicine>lists=PatientDB.RetrieveALLRequest_Patient(n);
		        request.setAttribute("patient",patient);
		        request.setAttribute("pharmacies",pharmacies);
		        request.setAttribute("list", list);
		        request.setAttribute("lists", lists);
		        request.setAttribute("email",patient.getEmail());
		        rd=request.getRequestDispatcher("PatientProfile.jsp");
		        rd.forward(request,response);  
		    } 
		    else if (arr[0]==2 && Users.validate(arr, p)) {
		    	Pharma_info pharma =DB_Pharma.RetrievePharma(arr[1]);
		    	List<Pharma_Medicine>list=DB_Pharma.RetrieveALLMedicine((int)arr[1]);
		    	List<Pharma_Medicine>lists=DB_Pharma.RetrieveALLRequest_Patient((int)arr[1]);
		    	request.setAttribute("pharma", pharma);
		    	request.setAttribute("list", list);
		    	request.setAttribute("lists", lists);
		    	request.setAttribute("id", ((int)arr[1]));
		    	rd=request.getRequestDispatcher("Pharmacy.jsp");    	
		    	 rd.forward(request,response);
		    }
		    else{  
		    	String message ="Sorry username or password error";
			    request.setAttribute("message", message);
		         rd=request.getRequestDispatcher("login.jsp");  
		        rd.include(request,response);  
		    }  
	}

}
