package Pet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.testng.Assert.assertTrue;

public class PutUpdatePet {
    @BeforeTest
    public void precondition(){
        PostAddPet p=new PostAddPet();
        p.AddPetWithStatus200();
    }
    @Test(priority = 1)
    public void UpdatePetWithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .contentType(ContentType.JSON)
                .body("{\"id\":220,\"category\": {\"id\":1,\"name\": \"gray\"},\"name\": \"doggie\",\"photoUrls\": [\"C:\\\\Users\\\\CompuCloud\\\\Pictures\\\\dog.jpg\"],\"tags\": [{\"id\": 0,\"name\": \"cats\"}],\"status\": \"Pending\"}")
                .when()
                .put("/pet")
                .then()
                .statusCode(200)
                .log().all(); // Logging response
    }
    @Test(priority = 2)
    public void UpdatePetWithResponseTime(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .contentType(ContentType.JSON)
                .body("{\"id\":220,\"category\": {\"id\":1,\"name\": \"gray\"},\"name\": \"doggie\",\"photoUrls\": [\"C:\\\\Users\\\\CompuCloud\\\\Pictures\\\\dog.jpg\"],\"tags\": [{\"id\": 0,\"name\": \"cats\"}],\"status\": \"Pending\"}")
                .when()
                .put("/pet")
                .then()
                .time(lessThan(5000L))
                .log().all();
    }

}
