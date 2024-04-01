package Users;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class PostCreateUsersWithArrayInputs {
    @Test
    public void CreateUsersWithArrayInputswithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .contentType(ContentType.JSON)
                .body("[{\"id\": 0,\"username\": \"yasmine123\",\"firstName\": \"Yasmine\",\"lastName\": \"Ahmed\",\"email\": \"yasmine@gmail.com\",\"password\": \"Yaso.123\",\"phone\": \"01025647896\",\"userStatus\": 0}]")
                .when()
                .post("/user/createWithArray")
                .then()
                .statusCode(200)
                .log().all(); // Logging response
    }
    @Test
    public void CreateUsersWithArrayInputswithResponseTime() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .contentType(ContentType.JSON)
                .body("[{\"id\": 0,\"username\": \"yasmine123\",\"firstName\": \"Yasmine\",\"lastName\": \"Ahmed\",\"email\": \"yasmine@gmail.com\",\"password\": \"Yaso.123\",\"phone\": \"01025647896\",\"userStatus\": 0}]")
                .when()
                .post("/user/createWithArray")
                .then()
                .time(lessThan(5000L))
                .log().all();
    }
}
