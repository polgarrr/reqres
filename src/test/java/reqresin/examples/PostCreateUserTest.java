package reqresin.examples;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class PostCreateUserTest {

    @Test
    @DisplayName("Вызов метода POST /createUser. Создание нового пользователя")
    public void successPostCreateUser() throws IOException, URISyntaxException, InterruptedException {
        byte[] out = "{\"name\":\"aida\",\"job\":\"thinker\"}".getBytes(StandardCharsets.UTF_8);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://reqres.in/api/users"))
                .POST(HttpRequest.BodyPublishers.ofByteArray(out))
                .build();

        HttpResponse response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.statusCode());
    }
}