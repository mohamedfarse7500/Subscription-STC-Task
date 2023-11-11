package Utils;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JsonFileHandler {
	public JSONObject loadJson(String resourceName) {
		JSONObject jsonObject = null;
		InputStream inputStream = null;
		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(resourceName + ".json");
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			JSONTokener tokener = new JSONTokener(inputStreamReader);
			jsonObject = new JSONObject(tokener);
			if (inputStream != null) {
				inputStream.close();
			}
		} 
		catch (Exception e) {
		}
		return jsonObject;
	}
}
