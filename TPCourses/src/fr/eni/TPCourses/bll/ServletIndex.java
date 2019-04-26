package fr.eni.TPCourses.bll;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import fr.eni.TPCourses.bo.Liste;

/**
 * Servlet implementation class ServletIndex
 */
@WebServlet("/ServletIndex")
public class ServletIndex extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletIndex() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		List<Liste> listeDeListe = ListeManager.getInstance().selectionnerToutesLesListes();
		request.setAttribute("ListedeListe", listeDeListe);
		this.getServletContext().getNamedDispatcher("index").forward(request, response);	
//		PrintWriter out = response.getWriter();
//		try {
//			Context context = new InitialContext();
//			DataSource datasource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
//			Connection cnx = datasource.getConnection();
//			out.print("La connexion est : " + (cnx.isClosed() ? "fermée!" : "ouverte!" ));
//			cnx.close();
//		} catch (NamingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
