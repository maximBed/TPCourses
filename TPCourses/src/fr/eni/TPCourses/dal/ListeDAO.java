package fr.eni.TPCourses.dal;

import java.util.List;

import fr.eni.TPCourses.bo.Liste;

public interface ListeDAO {
	public void insert(Liste liste);
	public List<Liste> selectAll();
	public Liste selectById(int id);
	public void delete(Liste liste);
	public void update(int id);
}
