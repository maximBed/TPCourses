package fr.eni.TPCourses.bll;

import fr.eni.javaee.suividesrepas.dal.DAOFactory;

public class CourseManager {
public CourseManager instance;
	public CourseManager() {
		
	}
	//Singleton
	public CourseManager getInstance() {
		if(instance!=null) {
			instance= new CourseManager();
		}
		return instance;
	}
	public void setInstance(CourseManager instance) {
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
