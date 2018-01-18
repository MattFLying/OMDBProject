package omdb.model.base;

public enum APIDetails {
	API_URL_WITH_TITLE("http://www.omdbapi.com/?t="),
	API_KEY_TITLE("&apikey="),
	MOVIE_INDEX("movies"),
	MOVIE_TYPE("movie"),
	RATE_INDEX("ratings"),
	RATE_TYPE("rate");
	
	
	private String name;
	APIDetails(String name) {
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
}