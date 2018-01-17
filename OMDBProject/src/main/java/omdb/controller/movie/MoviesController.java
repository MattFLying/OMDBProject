package omdb.controller.movie;

import java.util.ArrayList;
import java.util.List;
import omdb.controller.excel.ReadMoviesFromExcel;
import omdb.controller.json.ReadMoviesFromJSON;
import omdb.model.base.APIDetails;
import omdb.model.base.APIKey;

public class MoviesController {
	private ReadMoviesFromExcel excel;
	private ReadMoviesFromJSON json;
	
	
	public MoviesController() {
		this.excel = new ReadMoviesFromExcel();
		this.json = new ReadMoviesFromJSON();
	}
	
	
	

	public String getMovieJSON(String url) {
		return json.getJSONDataOfMovie(url);
	}
	public List<String> getAllMoviesJSONs() {
		System.err.println("Przygotowywanie informacji o filmach w formacie JSON...");
		List<String> list = new ArrayList<String>();
		List<String> urls = buildMoviesURL();
		
		for(String url : urls) {
			list.add(getMovieJSON(url));
		}
		System.err.println("Przygotowywanie informacji o filmach w formacie JSON ukonczone...");
		
		return list;
	}
	private List<String> buildMoviesURL() {
		List<String> urls = new ArrayList<String>();
		List<String> titles = getMovieTitlesFromExcel();
		
		for(String title : titles) {
			StringBuilder sb = new StringBuilder(APIDetails.API_URL_WITH_TITLE.getName());
			sb.append(title.replaceAll(" ", "%20").replaceAll("'", "%27"));
			sb.append(APIDetails.API_KEY_TITLE.getName());
			sb.append(APIKey.API_KEY.getKey());
			
			urls.add(sb.toString());
		}
		return urls;
	}
	private List<String> getMovieTitlesFromExcel() {
		return excel.getMoviesFromExcel();
	}
}