package fr.eni.TPCourses.bll;

import java.util.List;

import fr.eni.TPCourses.bo.Liste;
import fr.eni.TPCourses.dal.DAOFactory;
import fr.eni.TPCourses.dal.ListeDAO;

public class ListeManager {
	public static ListeManager instance;
	private ListeDAO listeDAO;
	
	private ListeManager() {

	}
	
	//Singleton
	public static ListeManager getInstance() {
		if(instance!=null) {
			instance= new ListeManager();
		}
		return instance;
	}	

	//Methodes
	public void ajouterListe(Liste l) {
		this.listeDAO = new DAOFactory().getListeDAO();
		this.listeDAO.insert(l);
	}

	public List<Liste> selectionnerToutesLesListes(){
		this.listeDAO = new DAOFactory().getListeDAO();
		return this.listeDAO.selectAll();
	}


	public Liste selectionnerById(int id) {
		this.listeDAO = new DAOFactory().getListeDAO();
		return this.listeDAO.selectById(id);
	}
}
