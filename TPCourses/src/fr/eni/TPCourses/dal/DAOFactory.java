package fr.eni.TPCourses.dal;

import fr.eni.TPCourses.bo.Liste;

public class DAOFactory {
	public static ListeDAO getListeDAO() {
		ListeDAO listeDAO = new ListeDAOJdbcImpl();
		return listeDAO;
	}
}
