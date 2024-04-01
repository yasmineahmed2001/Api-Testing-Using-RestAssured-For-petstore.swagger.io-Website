package Users;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class PostCreateUser {
    @Test
    public void CreateUserswithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .contentType(ContentType.JSON)
                .body("{\"id\": 0,\"username\": \"mostafa249\",\"firstName\": \"mostafa\",\"lastName\": \"ahmed\",\"email\": \"mostafa@gmail.com\",\"password\": \"mmmm\",\"phone\": \"01025647854\",\"userStatus\": 3}")
                .when()
                .post("/user")
                .then()
                .statusCode(200)
                .log().all(); // Logging response
    }
    @Test
    public void CreateUserswithResponseTime() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .contentType(ContentType.JSON)
                .body("{\"id\": 0,\"username\": \"mostafa249\",\"firstName\": \"mostafa\",\"lastName\": \"ahmed\",\"email\": \"mostafa@gmail.com\",\"password\": \"mmmm\",\"phone\": \"01025647854\",\"userStatus\": 3}")
                .when()
                .post("/user")
                .then()
                .time(lessThan(5000L))
                .log().all();
    }
}
