package fr.eni.TPCourses.bll;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.TPCourses.bo.Article;
import fr.eni.TPCourses.bo.Liste;

/**
 * Servlet implementation class ajouterServlet
 */
@WebServlet("/ServletAjouterListe")
public class ServletAjouterListe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor. 
	 */
	public ServletAjouterListe() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getNamedDispatcher("nouvelleListe").forward(request, response);



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		if(request.getSession().getAttribute("listeEnCours") == null && request.getParameter("textboxListe") != null)
		{				
			Liste listeCourse = new Liste();
			listeCourse.setNom((String) request.getParameter("textboxListe"));

			List<Article> articles= new ArrayList<Article>();
			articles.add(new Article(request.getParameter("textboxArticle")));
			listeCourse.setArticles(articles);
			request.getSession().setAttribute("listeEnCours", listeCourse);	
			
		}else if(request.getSession().getAttribute("listeEnCours") != null){
			Liste listeCourse = (Liste)request.getSession().getAttribute("listeEnCours");
			List<Article> articles= listeCourse.getArticles();
			articles.add(new Article(request.getParameter("textboxArticle")));
			listeCourse.setArticles(articles);
			request.getSession().setAttribute("listeEnCours", listeCourse);	
		}

		this.getServletContext().getNamedDispatcher("nouvelleListe").forward(request, response);

	}

}
