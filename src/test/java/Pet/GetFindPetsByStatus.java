package Pet;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.testng.Assert.assertTrue;

public class GetFindPetsByStatus {
    @Test
    public void PetByStatuswithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .get("/pet/findByStatus?status=available")
                .then()
                .statusCode(200)
                .log().all(); // Logging response
    }
    @Test
    public void PetByStatuswithResponseTime() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .get("/pet/findByStatus?status=available")
                .then()
                .time(lessThan(5000L))
                .log().all();
    }
}
