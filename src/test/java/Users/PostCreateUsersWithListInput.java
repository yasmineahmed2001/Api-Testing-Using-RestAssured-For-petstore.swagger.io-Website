package Users;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;

public class PostCreateUsersWithListInput {
    @Test
    public void CreateUsersWithListInputswithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .contentType(ContentType.JSON)
                .body("[{\"id\": 0,\"username\": \"yasmine123\",\"firstName\": \"yasmine\",\"lastName\": \"ahmed\",\"email\": \"yasmine@gmail.com\",\"password\": \"kkkk\",\"phone\": \"01025987355\",\"userStatus\": 1}]")
                .when()
                .post("/user/createWithList")
                .then()
                .statusCode(200)
                .log().all(); // Logging response
    }
    @Test
    public void CreateUsersWithListInputswithResponseTime() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .contentType(ContentType.JSON)
                .body("[{\"id\": 0,\"username\": \"yasmine123\",\"firstName\": \"yasmine\",\"lastName\": \"ahmed\",\"email\": \"yasmine@gmail.com\",\"password\": \"kkkk\",\"phone\": \"01025987355\",\"userStatus\": 1}]")
                .when()
                .post("/user/createWithList")
                .then()
                .time(lessThan(5000L))
                .log().all();
    }
}
