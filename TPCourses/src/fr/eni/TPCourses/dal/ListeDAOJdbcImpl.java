package fr.eni.TPCourses.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.TPCourses.dal.ListeDAO;
import fr.eni.TPCourses.bo.Liste;

public class ListeDAOJdbcImpl implements ListeDAO{
	private PreparedStatement psmt = null;
	private Statement stmt = null;
	private Connection cnx = null;
	private DataSource datasource = null;
	private Context context;

	public void connect() {
		try {
			context = new InitialContext();
			this.datasource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			cnx = this.datasource.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Liste liste) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Liste> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Liste selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Liste liste) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int id) {
		// TODO Auto-generated method stub
		
	}

}
