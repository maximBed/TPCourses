package fr.eni.TPCourses.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.TPCourses.dal.ListeDAO;
import fr.eni.TPCourses.bo.Article;
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
	
	public void statementsClose() {
		//Fermer le statement
		if (this.psmt != null) {
			try {
				this.psmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (this.stmt != null) {
			try {
				this.stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void dbClose() {

		if(this.cnx != null) {
			//Fermer la connexion
			try {
				this.cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void insert(Liste liste) {
		connect();
		try {
			ResultSet rs = null;
			String sql = "";		

			sql = "insert into listes values(?)";

			this.psmt = this.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			this.psmt.setString(1, liste.getNom());

			this.psmt.executeUpdate();
			rs = psmt.getGeneratedKeys();
			if(rs.next()) {
				liste.setId(rs.getInt(1));
			}

			for (Article article : liste.getArticles()) {
				sql = "insert into articles values(?,?)";

				this.psmt = this.cnx.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

				this.psmt.setString(1, article.getNom());
				this.psmt.setInt(2, liste.getId());

				this.psmt.executeUpdate();
			}

			this.cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbClose();
			statementsClose();
		}


	}

	@Override
	public List<Liste> selectAll() {
		connect();

		List<Liste> listes = new ArrayList<>();

		try {

			this.stmt = cnx.createStatement();
			String sql = "select * from listes";
			ResultSet rs =this.stmt.executeQuery(sql);

			while (rs.next()) {
				listes.add(this.selectById(rs.getInt("id")));
			}

			this.cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
			statementsClose();
		}


		return listes;
	}

	@Override
	public Liste selectById(int id) {
		connect();
		Liste liste = new Liste();

		try {

			String sql = "select * "
					+ "from listes "
					+ "where liste_id=?";
			this.psmt = cnx.prepareStatement(sql);
			this.psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {
				liste.setId(rs.getInt("liste_id"));
				liste.setNom(rs.getString("liste_nom"));
			}

			sql = "select * "
					+ "from articles "
					+ "where liste_id=?";

			this.psmt = cnx.prepareStatement(sql);
			this.psmt.setInt(1, id);
			rs = psmt.executeQuery();

			List<Article> articles = new ArrayList<Article>();

			while (rs.next()) {
				articles.add(new Article(rs.getInt("article_id"), rs.getString("article_nom")));
			}

			liste.setArticles(articles);

			this.cnx.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			dbClose();
			statementsClose();
		}


		return liste;
	}

	@Override
	public void delete(int id) {
		connect();
		String sql = "";

		try {
			sql = "delete from listes where liste_id = ?";
			this.psmt = cnx.prepareStatement(sql);
			this.psmt.setInt(1, id);
			psmt.execute();			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			dbClose();
			statementsClose();
		}

	}

	@Override
	public void update(Liste liste) {
		// TODO Auto-generated method stub

	}

}
