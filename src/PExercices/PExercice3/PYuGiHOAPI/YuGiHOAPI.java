package PExercices.PExercice3.PYuGiHOAPI;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class YuGiHOAPI {
    private static final String API_ENDPOINT = "https://db.ygoprodeck.com/api/v7/cardinfo.php";
    private static JSONParser jsonParser = new JSONParser();

    public static JSONArray call(String[][] params) {
        // url preparation for api call
        StringBuilder url = new StringBuilder(API_ENDPOINT + (params.length > 0 ? "?" : ""));
        for (String[] param : params) {
            url.append("&").append(param[0]).append("=").append(param[1].replace(" ", "%20"));
        }

        // prepare request & response
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url.toString()))
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response;

        // try to call api
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

            // parse response to JSONObject
            JSONObject obj = (JSONObject) jsonParser.parse(response.body());

            // if success, return result
            return (JSONArray) obj.get("data");

        } catch (IOException | InterruptedException | ParseException e) {
            // if error, return null and print exception message
            e.printStackTrace();
            return null;
        }
    }
}
