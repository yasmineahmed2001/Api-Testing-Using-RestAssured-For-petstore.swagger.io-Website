package Pet;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.testng.Assert.assertTrue;

public class GetFindPetsByTags {
    @BeforeTest
    public void precondition(){
        PostAddPet p=new PostAddPet();
        p.AddPetWithStatus200();
    }
    @Test(priority = 1)
    public void PetByTagswithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .get("/pet/findByTags?tags=cats")
                .then()
                .statusCode(200)
                .log().all(); // Logging response
    }
    @Test(priority = 2)
    public void PetByTagswithResponseTime() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .get("/pet/findByTags?tags=cats")
                .then()
                .time(lessThan(5000L))
                .log().all();
    }
}
