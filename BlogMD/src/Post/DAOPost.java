package Post;
import java.util.List;

public interface DAOPost {

	 public Post getPost(int id);
	 public List getAllPost();
	 public void addPost(Post post);
	 public void updatePost(Post post);
	 public void deletePost(Post post);
	
}
