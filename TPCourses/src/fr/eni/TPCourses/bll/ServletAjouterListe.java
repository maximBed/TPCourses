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
	Liste listeCourse = null;
	List<Article> listeArticle= null;

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
		
				
		if(listeCourse == null)
		{	
			listeCourse = new Liste();
			listeCourse.setNom((String) request.getParameter("textboxListe"));
			listeArticle= new ArrayList<Article>();
			request.setAttribute("listeCourse", listeCourse);
				
		}
			
			Article article = new Article(request.getParameter("textboxArticle"));
			listeArticle.add(article);
			listeCourse.setArticles(listeArticle);
			request.setAttribute("listeArticle", listeArticle);
			
		
		
		this.getServletContext().getNamedDispatcher("nouvelleListe").forward(request, response);
		
		
	}

}
