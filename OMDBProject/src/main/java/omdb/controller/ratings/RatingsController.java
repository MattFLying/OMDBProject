package omdb.controller.ratings;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import omdb.controller.excel.ReadMoviesFromExcel;
import omdb.model.rate.Rate;
import omdb.model.user.User;

public class RatingsController {
	private ReadMoviesFromExcel moviesFromExcel;
	private UserController userController;
	private List<String> moviesTitles;
	private int numberOfUsers;
	
	
	public RatingsController(int numberOfUsers) {
		initialize(numberOfUsers);
	}
	
	
	public List<String> getMoviesTitles() {
		return moviesTitles;
	}
	public List<Rate> generateRatings() {
		List<User> list = userController.generateUsers(numberOfUsers);
		List<Rate> ratings = new ArrayList<Rate>();

		System.err.println("Generowanie ocen...");
		for(String title : moviesTitles) {
			HashSet<User> users = randomUsers(list);
			for(User user : users) {
				Rate rate = new Rate();
				rate.setMovieTitle(title);
				rate.setUserID(user.getUserID());
				rate.setDate(generateDate());
				rate.setRate(generateRate());
				
				ratings.add(rate);
			}
		}
		return ratings;
	}
	private void initialize(int numberOfUsers) {
		this.moviesFromExcel = new ReadMoviesFromExcel();
		this.userController = new UserController();
		this.moviesTitles = moviesFromExcel.getMoviesFromExcel();
		this.numberOfUsers = numberOfUsers;
	}
	private HashSet<User> randomUsers(List<User> list) {
		HashSet<User> users = new HashSet<User>();
		int randomNumberOfUsers = (new Random().nextInt(list.size()) + 1);
		
		while(users.size() < randomNumberOfUsers) {
			users.add(list.get(new Random().nextInt(list.size())));
		}
		return users;
	}
	private Date generateDate() {
		long beginTime = Timestamp.valueOf("2000-01-01 00:00:00").getTime();
		long endTime = Timestamp.valueOf("2018-01-18 00:59:00").getTime();
		
		long diff = endTime - beginTime + 1;
		long generatedTime = beginTime + (long) (Math.random() * diff);
		
		return new Date(generatedTime);
	}
	public int generateRate() {
		return (new Random().nextInt(10) + 1);
	}
}