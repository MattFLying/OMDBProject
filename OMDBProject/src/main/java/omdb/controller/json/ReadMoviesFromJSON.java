package omdb.controller.json;

import java.util.ArrayList;
import java.util.List;
import omdb.model.json.ReadJSON;

public class ReadMoviesFromJSON {
	private ReadJSON read;
	
	
	public ReadMoviesFromJSON() {
		this.read = new ReadJSON();
	}
	
	
	public String getJSONDataOfMovie(String url) {
		return read.createJsonStringFromURL(url).toString();
	}
	public List<String> getMoviesFromURLs(List<String> moviesURLs) {
		List<String> list = new ArrayList<String>();
		
		for(String movie : moviesURLs) {
			list.add(getJSONDataOfMovie(movie));
		}
		
        return list;
	}
}