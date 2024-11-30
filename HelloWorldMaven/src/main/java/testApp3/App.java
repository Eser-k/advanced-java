package testApp3;

public class App {
	public static void main(String[] args){
		
		User user = new User(0L,"James");
		
		Repository rep = new Repository<User>();
		rep.save(user);
	}
}