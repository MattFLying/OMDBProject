package omdb.model.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadJSON {
	public ReadJSON() {}
	
	
	public JSONObject createJsonStringFromURL(String url) {
		try {
			return readJsonFromUrl(url);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	private JSONObject readJsonFromUrl(String url) throws IOException {
		InputStream inputStream = new URL(url).openStream();
		
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
			String jsonText = readAllLines(bufferedReader);
			JSONObject json = new JSONObject(jsonText);
			
			return json;
		}  catch (JSONException e) {
			e.printStackTrace(); 
			return null;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			inputStream.close();
		}
	}
	private String readAllLines(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int line;
		
		while ((line = rd.read()) != -1) {
			sb.append((char) line);
		}
		return sb.toString();
	}
}