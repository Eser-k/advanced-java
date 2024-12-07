package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import entities.User;
import greeters.Greeter;
import repositories.UserRepository;

@Component
public class Runner implements CommandLineRunner {
	
	@Autowired
	private UserRepository userDao;
	
	@Override
	public void run(String... args) throws Exception {
		var user1 = new User("Neptune", "neptune@example.com");
		userDao.save(user1);
		
		var user2 = new User("Jupiter", "jupiter@example.com");
		userDao.save(user2);
		
		var user3= userDao.findByName("Neptune");
	}

}
