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
	

/*




public void ajouterRepas(Repas r) {
this.repasDAO = new DAOFactory().getRepasDAO();
this.repasDAO.insert(r);
}

public List<Repas> selectionnerTousLesRepas(){
this.repasDAO = new DAOFactory().getRepasDAO();
return this.repasDAO.selectAll();
}

public Repas selectionnerById(int id) {
this.repasDAO = new DAOFactory().getRepasDAO();
return this.repasDAO.selectById(id);
}

public List<Repas> selectionnerTousLesRepasParJour(LocalDate date){
this.repasDAO = new DAOFactory().getRepasDAO();
return this.repasDAO.selectByDate(date);*/
	
	
	
	
}
