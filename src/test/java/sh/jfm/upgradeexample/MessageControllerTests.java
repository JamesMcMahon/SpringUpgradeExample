package sh.jfm.upgradeexample;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MessageControllerTests {

    @LocalServerPort
    private int port;

    @BeforeAll
    static void setup() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

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
                .get("/db-messages")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body(equalTo("[\"message from db 1\",\"message from db 2\"]"));
    }

    @Test
    void getSecuredMessageReturns401IfUnauthorized() {
        given()
                .port(port)
                .when()
                .get("/secure-message")
                .then()
                .statusCode(401);
    }

    @Test
    void getSecuredMessageReturnMessageIfAuthorized() {
        given()
                .port(port)
                .auth().basic("admin", "admin")
                .when()
                .get("/secure-message")
                .then()
                .statusCode(200)
                .body(equalTo("Hello Secure World!"));
    }
}
