package omdb.controller.json;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import omdb.model.rate.Rate;

public class CreateJSONForRatings {
	public CreateJSONForRatings() {}
	
	
	public List<String> getJSONDataOfRatings(List<Rate> ratings) {
		List<String> list = new ArrayList<String>();
		
		for(Rate rate : ratings) {
			JSONObject jsonObject = new JSONObject(rate);
			list.add(jsonObject.toString());
		}
		
		return list;
	}
}