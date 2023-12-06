import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        try {
            List<String> stringList = new ArrayList<>();
            stringList.add("Hello");
            stringList.add("World");

            sendPostRequest(stringList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendPostRequest(List<String> stringList) throws Exception {
        // API endpoint
        String endpointUrl = "https://your.api.endpoint.com";

        URL url = new URL(endpointUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");

        connection.setRequestProperty("Content-Type", "application/json");

        connection.setDoOutput(true);

        String jsonInputString = String.join(",", stringList);

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        connection.disconnect();
    }
}