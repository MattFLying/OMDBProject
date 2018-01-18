package omdb.controller.ratings;

import java.util.ArrayList;
import java.util.List;
import omdb.model.user.User;

public class UserController {
	private static final String ALIAS = "User_";
	
	
	public UserController() {}
	
	
	public List<User> generateUsers(int numberOfUsers) {
		List<User> list = new ArrayList<User>();

		System.err.println("Generowanie uzytkownikow...");
		for(int i = 0; i < numberOfUsers; i++) {
			list.add(new User(ALIAS + String.valueOf(i + 1)));
		}
		
		return list;
	}
}