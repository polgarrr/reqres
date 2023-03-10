package reqresin.examples;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GetSingleUserTest {

    @Test
    @DisplayName("Вызов метода GET /singleUser. Получение информации о вызываемом пользователе")
    public void successGetSingleUser() throws IOException {
        StringBuilder result = new StringBuilder();
        URL url = new URL("https://reqres.in/api/users/2");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        System.out.println(result);
    }

    @Test
    @DisplayName("Проверка получаемого статус-кода в ответ на вызов метода GET /singleUser")
    public void successGetSingleUserStatusCode() throws IOException {
        URL url = new URL("https://reqres.in/api/users/2");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        System.out.println(connection.getResponseCode());
    }

    @Test
    @DisplayName("еще один Вызов метода GET /singleUser")
    public void successGetSingleUserAnotherExample() throws IOException, InterruptedException, URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://reqres.in/api/users/2"))
                .GET().build();

        HttpResponse response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        assertEquals(200, response.statusCode(), "status code не соответствует");
    }
}