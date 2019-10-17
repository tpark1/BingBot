import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class BingBot {

  private final static HttpClient httpClient = HttpClient.newBuilder()
          .version(HttpClient.Version.HTTP_2)
          .build();

  public static void main(String[] args) throws Exception {
    System.out.println("Starting script");

    HttpRequest request = HttpRequest.newBuilder()
            .GET()
            // .uri(URI.create("https://httpbin.org/get"))
            .uri(URI.create("https://httpbin.org/get"))
            .setHeader("User-Agent", "Java 11 HttpClient Bot")
            .build();

    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

    // print status code
    System.out.println(response.statusCode());

    // print response body
    System.out.println(response.body());
  }

  private void logIn() throws Exception {
    // form parameters
    Map<Object, Object> data = new HashMap<>();
    data.put("username", "abc");
    data.put("password", "123");
    data.put("custom", "secret");
    data.put("ts", System.currentTimeMillis());

    HttpRequest request = HttpRequest.newBuilder()
                  .POST(buildFormDataFromMap(data))
                  .uri(URI.create("https://httpbin.org/post"))
                  .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                  .header("Content-Type", "application/x-www-form-urlencoded")
                  .build();

          HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

          // print status code
          System.out.println(response.statusCode());

          // print response body
          System.out.println(response.body());

      }
}
