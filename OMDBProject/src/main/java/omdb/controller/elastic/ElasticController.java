package omdb.controller.elastic;

import java.util.List;
import omdb.model.base.APIDetails;
import omdb.model.elastic.Elastic;

public class ElasticController {
	private Elastic elastic;
	private List<String> jsons;
	
	
	public ElasticController() {
		this.elastic = new Elastic();
	}
	public ElasticController(List<String> moviesJSONs) {
		this.elastic = new Elastic();
		this.jsons = moviesJSONs;
	}
	
	
	public void createMoviesIndexes() {
		System.err.println("Przygotowywanie indexow o filmach w Elasticsearchu...");
		if(!jsons.isEmpty() && jsons != null) {
			
			int counter = 1;
			for(String json : jsons) {
				elastic.createIndexRequest(APIDetails.INDEX.getName(), APIDetails.TYPE.getName(), counter, json);
				counter++;
			}
		}
		System.err.println("Przygotowywanie informacji o filmach w Elasticsearchu ukonczone...");
	}
}