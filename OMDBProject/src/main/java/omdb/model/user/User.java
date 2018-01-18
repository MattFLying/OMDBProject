package omdb.model.user;

public class User {
	private String userID;
	
	
	public User() {
		this.userID = null;
	}
	public User(String userID) {
		this.userID = userID;
	}


	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
}