package Users;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class GetLogoutUser {
    @Test
    public void LogoutUserwithResponseTime() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .get("/user/logout")
                .then()
                .time(lessThan(5000L))
                .log().all();
    }
    @Test
    public void LogoutUserwithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .get("/user/logout")
                .then()
                .statusCode(200)
                .log().all(); // Logging response
    }
}
