package Pet;

import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.number.OrderingComparison.lessThan;
import static org.testng.Assert.assertTrue;

public class GetPetById {
    @Test(priority=0)
    public void precondition(){
        PostAddPet p=new PostAddPet();
        p.AddPetWithStatus200();
    }
    @Test (priority = 1)
    public void PetByIdwithStatus200(){
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .get("/pet/320")
                .then()
                .statusCode(200)
                .log().all(); // Logging response
    }
    @Test (priority = 2)
    public void PetByIdwithResponseTime() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        given()
                .when()
                .get("/pet/320")
                .then()
                .time(lessThan(5000L))
                .log().all();
    }

}

