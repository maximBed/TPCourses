package fr.eni.TPCourses.bo;

import java.util.ArrayList;
import java.util.List;

public class Liste {
	private int id;
	private String nom;
	private List<Article> articles;
	public Liste(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
		this.articles = new ArrayList<Article>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Article> getArticles() {
		return articles;
	}
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
}
