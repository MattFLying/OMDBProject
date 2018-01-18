package omdb.model.rate;

import java.util.Date;

public class Rate {
	private String userID, movieTitle;
	private int rate;
	private Date date;
	
	
	public Rate() {
		this.userID = null;
		this.movieTitle = null;
		this.rate = 0;
		this.date = null;
		
	}
	public Rate(String userID, String movie, int rate, Date date) {
		this.userID = userID;
		this.movieTitle = movie;
		this.rate = rate;
		this.date = date;
	}
	
	
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}