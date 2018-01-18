package omdb.controller.elastic;

import java.util.List;

import omdb.controller.json.CreateJSONForRatings;
import omdb.model.base.APIDetails;
import omdb.model.elastic.Elastic;
import omdb.model.rate.Rate;

public class ElasticController {
	private Elastic elastic;
	private CreateJSONForRatings jsonForRatings;
	private List<String> moviesJSONs;
	private List<Rate> ratings;
	
	
	public ElasticController() {
		this.elastic = new Elastic();
		this.jsonForRatings = new CreateJSONForRatings();
	}
	public ElasticController(List<String> moviesJSONs, List<Rate> ratings) {
		this.elastic = new Elastic();
		this.jsonForRatings = new CreateJSONForRatings();
		this.moviesJSONs = moviesJSONs;
		this.ratings = ratings;
	}
	
	
	public void createMoviesIndexes() {
		System.err.println("Przygotowywanie indexow o filmach w Elasticsearchu...");
		if(!moviesJSONs.isEmpty() && moviesJSONs != null) {
			
			int counter = 1;
			for(String json : moviesJSONs) {
				elastic.createIndexRequest(APIDetails.MOVIE_INDEX.getName(), APIDetails.MOVIE_TYPE.getName(), counter, json);
				counter++;
			}
		}
		System.err.println("Przygotowywanie informacji o filmach w Elasticsearchu ukonczone...");
	}
	public void createRatingsIndexes() {
		System.err.println("Przygotowywanie indexow ocen w Elasticsearchu...");
		System.err.println("Ilosc ocen: " + ratings.size());
		if(!ratings.isEmpty() && ratings != null) {
			List<String> ratingsJSONs = jsonForRatings.getJSONDataOfRatings(ratings);
			
			int counter = 1;
			for(String json : ratingsJSONs) {
				elastic.createIndexRequest(APIDetails.RATE_INDEX.getName(), APIDetails.RATE_TYPE.getName(), counter, json);
				counter++;
			}
		}
		System.err.println("Przygotowywanie informacji o ocenach w Elasticsearchu ukonczone...");
	}
}