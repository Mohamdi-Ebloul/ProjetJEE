package Login;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/login")
public class servlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dao dao = new dao();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		login login = new login();
		login.setUsername(username);
		login.setPassword(password);
		
		if (dao.validate(login))
		{
			response.sendRedirect("index.jsp");
			HttpSession session=request.getSession();  
	        session.setAttribute("name",username);  
		}
		else 
		{
			
			response.sendRedirect("login.jsp");
			
		}
		
	}



}
