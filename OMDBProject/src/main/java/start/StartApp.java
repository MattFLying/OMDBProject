package start;

import java.util.List;
import omdb.controller.elastic.ElasticController;
import omdb.controller.movie.MoviesController;
import omdb.controller.ratings.RatingsController;
import omdb.model.rate.Rate;

public class StartApp {
	private static final int USERS_COUNT_TO_GENERATE_FOR_RATINGS = 100;
	
	public static void main(String[] args) {
		MoviesController moviesController = new MoviesController();
		RatingsController ratingsController = new RatingsController(USERS_COUNT_TO_GENERATE_FOR_RATINGS);
		
		List<String> movies = moviesController.getAllMoviesJSONs();
		List<Rate> ratings = ratingsController.generateRatings();
		
		ElasticController elasticController = new ElasticController(movies, ratings);
		elasticController.createMoviesIndexes();
		elasticController.createRatingsIndexes();
	}
}