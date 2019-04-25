package fr.eni.TPCourses.bll;

import fr.eni.javaee.suividesrepas.dal.DAOFactory;

public class ListeManager {
public ListeManager instance;
	public ListeManager() {
		
	}
	//Singleton
	public ListeManager getInstance() {
		if(instance!=null) {
			instance= new ListeManager();
		}
		return instance;
	}
	public void setInstance(ListeManager instance) {
		this.instance = instance;
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
