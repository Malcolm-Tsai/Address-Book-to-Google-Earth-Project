package google.maps;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;


public class address {

	public void get_address_info() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader("src\\google\\maps\\address_book.txt"));
			String address = reader.toString();
			PrintWriter coords_out = new PrintWriter("src\\google\\maps\\coordinates.txt");
			coords_out.println("Lattitude, Longitude");
			while ((address = reader.readLine()) != null) {
				address = address.replaceAll(",$", "");
				String key = "AIzaSyAk_GyrO3JsZof-gKKjTMxMz6YZnSJkxrU";
				String encoded_url = "https://maps.googleapis.com/maps/api/geocode/json?address=" + URLEncoder.encode(address, StandardCharsets.UTF_8)+"&key="+key;
				URL url = new URL(encoded_url);
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				String json_results;
				PrintWriter json_out = new PrintWriter("src\\google\\maps\\temp_response.json");
				while ((json_results = in.readLine()) != null) json_out.println(json_results);
				json_out.close();

				JSONParser parser = new JSONParser();
				Object obj = parser.parse(new FileReader("src\\google\\maps\\temp_response.json"));
				JSONObject jsonObject = (JSONObject) obj;

				JSONArray results = (JSONArray) jsonObject.get("results");

				for (int a = 0; a < results.size(); a++) {
					JSONObject second_level_results = (JSONObject) results.get(a);

					JSONObject geometry = (JSONObject) second_level_results.get("geometry");
					JSONObject location = (JSONObject) geometry.get("location");

					coords_out.println(location.get("lat")+", "+location.get("lng"));

				}

				in.close();

			}
			coords_out.close();
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
