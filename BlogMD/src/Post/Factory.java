package Post;
import java.sql.Connection;

public class Factory {
	private MySQLManager manager;
	private DAOPost post;
	public Factory() {
		manager = MySQLManager.getInstance();
		post = new PostImpl(manager.getConnection());
	}
	public DAOPost getDaoPost() {
		return post;
	}
}
