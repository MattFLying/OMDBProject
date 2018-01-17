package omdb.model.base;

public enum APIKey {
	API_KEY("c3502b44"),
	EXAMPLE("http://www.omdbapi.com/?t=Game%20of%20Thrones&Season=1&apikey=c3502b44");
	
	
	private String key;
	APIKey(String key) {
		this.key = key;
	}
	
	
	public String getKey() {
		return key;
	}
}