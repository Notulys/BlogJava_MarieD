package Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostImpl implements DAOPost {
	
	public java.sql.Connection connection;
	
	public PostImpl(Connection connection) {
		this.connection = connection;
	}

	
	public Post getPost(int id) {
		
		Post post = new Post();
		try {
			String query = "SELECT * FROM post WHERE id=1;";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next() == false) {
				return null;
			} else {
				do {
					post.setId(rs.getInt("id"));
					post.setTitre(rs.getString("titre"));
					post.setAuteur(rs.getString("auteur"));
					post.setDate(rs.getDate("date"));
					post.setDescription(rs.getString("description"));
					post.setTexte(rs.getString("texte"));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}

	
	public List<Post> getAllPost() {
		List<Post> allPost = new ArrayList<Post>();
		
		try {
			String query = "SELECT * FROM post";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Post post = new Post();
				
				post.setId(rs.getInt("id"));
				post.setTitre(rs.getString("titre"));
				post.setAuteur(rs.getString("auteur"));
				post.setDate(rs.getDate("date"));
				post.setDescription(rs.getString("description"));
				post.setTexte(rs.getString("texte"));
				
				allPost.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allPost;
	}

	public void addPost(Post post) {
		try {
			String query = "INSERT INTO post (titre, auteur, date, description, texte) Values (?,?,?,?,?);";
			String generatedColumns[] = { "ID" };
			PreparedStatement ps = connection.prepareStatement(query, generatedColumns);

			ps.setString(1, post.getTitre());
			ps.setString(2, post.getAuteur());
			ps.setDate(3, post.getDate());
			ps.setString(4, post.getDescription());
			ps.setString(5, post.getTexte());
			
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				post.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void updatePost (Post post) {
		try {
			String query = "Update post Set, titre-?, auteur-?, date-?, description-?, texte-? WITH post id";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, post.getTitre());
			ps.setString(2, post.getAuteur());
			ps.setDate(3, post.getDate());
			ps.setString(4, post.getDescription());
			ps.setString(5, post.getTexte());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void deletePost (Post post) {
		try {
			String query = "DELETE FROM post WHERE id-?;";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, post.getId());
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

	
}



