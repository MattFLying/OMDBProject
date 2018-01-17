package start;

import java.util.List;
import omdb.controller.elastic.ElasticController;
import omdb.controller.movie.MoviesController;

public class StartApp {
	
	public static void main(String[] args) {
		/**
		 * Kontroller filmów umozliwiajacy ich pobranie z pliku excel oraz pobranie za pomoca API OMDB danych w formacie JSON.
		 */
		MoviesController moviesController = new MoviesController();
		/**
		 * Tworzenie listy skladajacej sie z danych o filmach w formacie JSON.
		 */
		List<String> movies = moviesController.getAllMoviesJSONs();
		/**
		 * Kontroller elasticsearcha pozwalajacy na przeslanie do niego danych, jako argument przyjmuje wczesniej utworzona liste filmow w formacie JSON.
		 */
		ElasticController elasticController = new ElasticController(movies);
		/**
		 * Tworzenie indexu movies i przesylanie danych o kazdym filmie jako typ movie, dostepnych pozniej pod adresem np: localhost:9200/movies/movie/1
		 */
		elasticController.createMoviesIndexes();
		
		
		
	}
}