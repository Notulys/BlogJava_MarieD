package Post;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		
		Factory factory = new Factory();
		DAOPost daoPost = factory.getDaoPost();
		
		Post newPost = new Post();
		newPost.setTitre("Titre1");
		newPost.setAuteur("Toto");
		newPost.setDate(date);
		newPost.setDescription("Description1");
		newPost.setTexte("Texte1");
		daoPost.addPost(newPost);
		
		Post createdPost = daoPost.getPost(newPost.getId());
		
		ArrayList<String> posts = new ArrayList<String>();
		posts.add(newPost.getTitre());
		posts.add(newPost.getAuteur());
		posts.add(newPost.getDescription());
		posts.add(newPost.getTexte());
		
		req.setAttribute("données", posts);
		
		for (int i =0; i < daoPost.getAllPost().size(); i++) {
			
			daoPost.deletePost(daoPost.getPost(i));
			
		}
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		
	}
	
	

}
