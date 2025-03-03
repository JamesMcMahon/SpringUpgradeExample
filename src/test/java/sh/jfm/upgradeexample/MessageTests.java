package sh.jfm.upgradeexample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageTests {

    @LocalServerPort
    private int port;

    @Test
    void getMessageReturnsHelloWorld() {
        given()
                .port(port)
                .when()
                .get("/message")
                .then()
                .statusCode(200)
                .body(equalTo("Hello World!"));
    }

    @Test
    void getDbMessageReturnsAMessageFromTheDb() {
        given()
                .port(port)
                .when()
                .get("/db-message")
                .then()
                .statusCode(200)
                .body(equalTo("Hello World from DB!"));
    }
}
