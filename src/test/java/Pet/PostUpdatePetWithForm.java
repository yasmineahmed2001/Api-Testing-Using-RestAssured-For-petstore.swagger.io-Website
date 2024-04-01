package Pet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.testng.Assert.assertTrue;

public class PostUpdatePetWithForm {
    @BeforeTest
    public void precondition(){
        PostAddPet p=new PostAddPet();
        p.AddPetWithStatus200();
    }
    @Test(priority = 1)
    public void UpdatePetWithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .post("/pet/320")
                .then()
                .statusCode(200)
                .log().all(); // Logging response
    }
    @Test(priority = 2)
    public void UpdatePetWithResponseTime(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .post("/pet/320")
                .then()
                .time(lessThan(5000L))
                .log().all();
    }
}
